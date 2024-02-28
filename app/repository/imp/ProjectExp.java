package app.repository.imp;

import app.observer.IPublisher;
import app.observer.ISubscriber;
import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.tree.MapTree;
import app.tree.MapTreeImp;
import app.tree.view.MapTreeView;
import app.view.MainWindow;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ProjectExp extends MapNodeComp {

    private transient List<ISubscriber> subscribers;
    public ProjectExp(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Project){
            Project project = (Project) child;
            if (!this.getChildren().contains(project)){
                this.getChildren().add(project);
                this.addSubscriber(project);
            }
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child != null &&  child instanceof Project){
             this.getChildren().remove((Project)child);
             System.out.println("Izbrisali smo " + child.getName());
            this.notifySubscribers("deletePro");

        }
    }


    @Override
    public String getAutor() {return null;}

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
    public void update(Object notification) {}
}
