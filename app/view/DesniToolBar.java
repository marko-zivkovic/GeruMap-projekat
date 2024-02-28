package app.view;

import javax.swing.*;

public class DesniToolBar extends JToolBar{

    public DesniToolBar(){
        super(VERTICAL);
        setFloatable(false);
        add (MainWindow.getInstance().getActionManager().getAddPojam());
        add (MainWindow.getInstance().getActionManager().getAddVeza());
        add (MainWindow.getInstance().getActionManager().getSelectAction());
        add (MainWindow.getInstance().getActionManager().getMovePojam());
        add (MainWindow.getInstance().getActionManager().getDeleteSelectedElementAction());
        add (MainWindow.getInstance().getActionManager().getEditorElemenataAkcija());
        add (MainWindow.getInstance().getActionManager().getZoomIn());
        add (MainWindow.getInstance().getActionManager().getZoomOut());

    }
}
