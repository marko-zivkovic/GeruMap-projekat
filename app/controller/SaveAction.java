package app.controller;

import app.JsonSerializer;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import app.view.MainWindow;
import app.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Map;

public class SaveAction extends AbstarctMyAction{



    public SaveAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/save.png"));
        putValue(SHORT_DESCRIPTION, "save as");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainWindow.getInstance().getDesniPanel() instanceof  ProjectView) {
            ProjectView pw = (ProjectView) MainWindow.getInstance().getDesniPanel();
            Project pr = pw.getModel();

            JFileChooser j = new JFileChooser();
           // j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            j.showDialog(MainWindow.getInstance(), null);
            File file = j.getSelectedFile();
            pr.setFilePath(file.getAbsolutePath());
           // System.out.println(pr.getFilePath());
            JsonSerializer serializer = new JsonSerializer();
            serializer.saveProject(pr);
        }




    }
}
