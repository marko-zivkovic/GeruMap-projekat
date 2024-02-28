package app.tree.view;

import app.tree.controller.MapTreeCellEditor;
import app.tree.controller.MapTreeSelectionL;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {
    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        MapTreeCellRender ruTreeCellRenderer = new MapTreeCellRender();
        addTreeSelectionListener(new MapTreeSelectionL());
        setCellEditor(new MapTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }
}
