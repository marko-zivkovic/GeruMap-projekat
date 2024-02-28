package app.repository.imp;

import app.observer.IPublisher;
import app.observer.ISubscriber;
import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.view.MainWindow;
import app.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

public class Project extends MapNodeComp{

    private String autor = "Ana Markovic";
    private transient List<ISubscriber> subscribers;
    private int broj = 0;

    protected transient boolean changed = true;
    public  ArrayList<MapaUma> mapeUma = new ArrayList<>();
    protected String filePath = "";
    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof MapaUma){

            MapaUma mapa = (MapaUma) child;
            mapa.setBrojID(broj++);
            if (!this.getChildren().contains(mapa)){
                this.getChildren().add(mapa);
                int b = this.getChildren().size();
                System.out.println(b);
                this.addSubscriber(mapa);
            }
        }
        this.notifySubscribers("novoDete");

    }

    @Override
    public void deleteChild(MapNode child) {
        if (child != null &&  child instanceof MapaUma){
            this.getChildren().remove((MapaUma)child);
            this.notifySubscribers("deleteMap");
            this.notifySubscribers((MapaUma) child);

        }
    }


    public String getAutor() {return autor;}
    public void setAutor(String autor) {
        this.autor = autor;
       this.notifySubscribers("autor");
    }

    ////////////observer
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
        if (notification instanceof String && notification.equals("deletePro")){
           this.notifySubscribers("delete");
        }
    }
    public void setFilePath(String path){
        this.filePath = path;
    }
    public String  getFilePath(){
        return filePath;
    }
}
