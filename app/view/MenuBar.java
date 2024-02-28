package app.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    public MenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add (MainWindow.getInstance().getActionManager().getExitAction());
        fileMenu.add (MainWindow.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add (MainWindow.getInstance().getActionManager().getRenameAutorAction());
        fileMenu.add (MainWindow.getInstance().getActionManager().getDeleteAction());


        this.add(fileMenu);

    }
}
