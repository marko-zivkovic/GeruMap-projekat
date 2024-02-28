package app.tree;

import app.repository.imp.ProjectExp;
import app.tree.model.MapTreeItem;
import app.tree.view.MapTreeView;

public interface MapTree {
    MapTreeView generateTree(ProjectExp projectExplorer);
    void addChild(MapTreeItem parent);
    void deleteChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();
}
