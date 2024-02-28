package app.repository.composite;

import app.observer.IPublisher;
import app.observer.ISubscriber;
import com.google.gson.annotations.SerializedName;

public abstract class MapNode implements IPublisher, ISubscriber {
    @SerializedName("name")
    private String name;
    private transient MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public MapNode getParent() {
        return parent;
    }
    public abstract String getAutor();
}
