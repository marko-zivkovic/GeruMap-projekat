package app.controller;

import app.view.MainWindow;
import app.view.MapaUmaView;
import app.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ZoomIn extends AbstarctMyAction{
    public ZoomIn() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/pluss.png"));
        putValue(SHORT_DESCRIPTION, "+");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainWindow.getInstance().getDesniPanel() instanceof ProjectView){
            if(((ProjectView) MainWindow.getInstance().getDesniPanel()).getMtp().getSelectedComponent() instanceof MapaUmaView){
                MapaUmaView mp =((MapaUmaView) ((ProjectView) MainWindow.getInstance().getDesniPanel()).getMtp().getSelectedComponent());
                mp.zoomIn();
            }else{System.out.println("NIJE MAPVIEW");}
        }
    }
}
