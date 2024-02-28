package app.repository.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNodeComp extends MapNode{
    transient List<MapNode> children;

    public MapNodeComp(String name, MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public MapNodeComp(String name, MapNode parent, List<MapNode> children) {
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(MapNode child);
    public abstract void deleteChild(MapNode child);

    public MapNode getChildByName(String name) {
        for (MapNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }
}
