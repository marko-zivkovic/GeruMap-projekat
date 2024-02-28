package app.controller;

import app.JsonSerializer;
import app.view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class OpenAction extends AbstarctMyAction{

    public OpenAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("slike/delete.png"));
        putValue(SHORT_DESCRIPTION, "open");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser j = new JFileChooser();
        // j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        j.showDialog(MainWindow.getInstance(), null);
        File file = j.getSelectedFile();

        // System.out.println(pr.getFilePath());
        JsonSerializer serializer = new JsonSerializer();
        serializer.loadProject(file);


    }
}
