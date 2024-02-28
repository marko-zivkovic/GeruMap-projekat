package app.controller;

import app.repository.imp.MapaUma;
import app.view.MainWindow;
import app.view.MapaUmaView;
import app.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ReDoAction extends AbstarctMyAction{
    public ReDoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/redo.png"));
        putValue(SHORT_DESCRIPTION, "REDO");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainWindow.getInstance().getDesniPanel() instanceof ProjectView){
            if(((ProjectView) MainWindow.getInstance().getDesniPanel()).getMtp().getSelectedComponent() instanceof MapaUmaView){
                System.out.println("OVO JE MAPAVIEW");
                MapaUma mp =((MapaUmaView) ((ProjectView) MainWindow.getInstance().getDesniPanel()).getMtp().getSelectedComponent()).getMp();
                mp.getCommandManager().doCommand();
            }else{System.out.println("NIJE MAPVIEW");}
        }

    }
}
