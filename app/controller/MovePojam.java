package app.controller;

import app.view.MainWindow;
import app.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MovePojam extends AbstarctMyAction{
    public MovePojam(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/play.png"));
        putValue(SHORT_DESCRIPTION, "MOVE");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainWindow.getInstance().getDesniPanel() instanceof ProjectView){
            ((ProjectView) MainWindow.getInstance().getDesniPanel()).startMoveAction();
        }
    }
}
