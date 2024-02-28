package app.controller;

import app.repository.imp.Project;
import app.tree.model.MapTreeItem;
import app.view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstarctMyAction{
    public NewProjectAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/plus.png"));
        putValue(SHORT_DESCRIPTION, "new");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainWindow.getInstance().getMapTree().getSelectedNode();
                MainWindow.getInstance().getMapTree().addChild(selected);


    }
}
