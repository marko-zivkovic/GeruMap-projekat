package app.tree.model;

import app.repository.composite.MapNode;
import app.repository.imp.Project;
import core.AppFramework;

import javax.swing.tree.DefaultMutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {
    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }
    @Override
    public String toString() {
        return mapNode.getName();
    }
    public void setName(String name) {
        if (name.equals("") || name.replace(" ", "").equals("")){
            AppFramework.getInstance().getErrorGenerator().generate("EMPTYNAME");
            return;
        }
        this.mapNode.setName(name);
        System.out.println("promena imena ");
        if(mapNode instanceof Project){
            ((Project) mapNode).notifySubscribers("novoIme");
        }
    }
    public MapNode getMapNode() {
        return mapNode;
    }
    public void setMapNode(MapNode mapNode) {
        this.mapNode = mapNode;
    }
}
