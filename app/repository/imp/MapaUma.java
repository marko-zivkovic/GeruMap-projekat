package app.repository.imp;

import app.commands.CommandManager;
import app.observer.IPublisher;
import app.observer.ISubscriber;
import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.tree.MapTreeImp;
import app.tree.model.MapTreeItem;
import app.view.MainWindow;
import app.view.ProjectView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapaUma extends MapNodeComp {

    private transient List<ISubscriber> subscribers;
    private int brojID;
    private int broj = 0;
    private transient CommandManager commandManager;

    public List<Element> elementi = new ArrayList<>();


    public MapaUma(String name, MapNode parent) {
        super(name, parent);
        this.commandManager = new CommandManager();
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element){
            this.getChildren().add(child);
        }
        else{System.out.println("dete nije element");}
        this.notifySubscribers("novoDete");

        if(MainWindow.getInstance().getMapTree() instanceof MapTreeImp){
                ((MapTreeImp) MainWindow.getInstance().getMapTree()).addChildElement(this,(Element)child,brojID);
          }

    }

    @Override
    public void deleteChild(MapNode child) {
        if (child != null &&  child instanceof Element){
            Element veza = null; boolean flag = false;
            if(!(child instanceof VezaElement)){
                List<MapNode> deca = this.getChildren();
                for(MapNode ele: deca){
                    if(ele instanceof VezaElement){
                        int lok = this.getChildren().indexOf(child);
                        Point p1 = ((VezaElement) ele).getPosition();
                        Point p2 = new Point(((VezaElement) ele).getX2(), ((VezaElement) ele).getY2());
                        if(MainWindow.getInstance().getMapTree() instanceof MapTreeImp){
                            flag = ((MapTreeImp) MainWindow.getInstance().getMapTree()).deleteVezaElement((Element) child,p1,p2,lok);
                        }
                        if(flag){veza = (Element) ele;}
                    }
                }
            }
            this.getChildren().remove((Element)child);
            if(flag){this.deleteChild(veza);}
            this.notifySubscribers("deleteDete");
//////////////////////////////////////////
            if(MainWindow.getInstance().getMapTree() instanceof MapTreeImp){
                    ((MapTreeImp) MainWindow.getInstance().getMapTree()).deleteChildElement(brojID,(Element) child,this);
                }

        }
    }
    @Override
    public String getAutor() {return null;}
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        // TODO Auto-generated method stub
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        // TODO Auto-generated method stub
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        // TODO Auto-generated method stub
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(ISubscriber listener : subscribers){
            listener.update(notification);
        }
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof String && notification.equals("deleteMap")){
            this.notifySubscribers("delete");
        }

    }

    public void setBroj(int broj) {this.broj = broj;}
    public int getBroj() {return broj;}

    public int getBrojID() {
        return brojID;
    }
    public void setBrojID(int brojID) {
        this.brojID = brojID;
    }
}
