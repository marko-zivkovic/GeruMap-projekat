package app.view;

import javax.swing.*;

public class Toolbar  extends JToolBar {

    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add (MainWindow.getInstance().getActionManager().getExitAction());
        add (MainWindow.getInstance().getActionManager().getNewProjectAction());
        add (MainWindow.getInstance().getActionManager().getRenameAutorAction());
        add (MainWindow.getInstance().getActionManager().getDeleteAction());
        add (MainWindow.getInstance().getActionManager().getUndoAction());
        add (MainWindow.getInstance().getActionManager().getReDoAction());
        add (MainWindow.getInstance().getActionManager().getSaveAction());
        //add (MainWindow.getInstance().getActionManager().getOpenAction());



    }
}
