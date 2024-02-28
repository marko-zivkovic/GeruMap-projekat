package app.controller;

import app.tree.model.MapTreeItem;
import app.view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstarctMyAction{
    public DeleteAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/delete.png"));
        putValue(SHORT_DESCRIPTION, "brisanje cvora");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainWindow.getInstance().getMapTree().getSelectedNode();
        MainWindow.getInstance().getMapTree().deleteChild(selected);

    }
}
