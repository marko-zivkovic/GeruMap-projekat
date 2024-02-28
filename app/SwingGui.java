package app;

import app.view.MainWindow;
import com.sun.tools.javac.Main;
import core.Gui;
import core.Message;

import javax.swing.*;

public class SwingGui implements Gui {
    private MainWindow instance;
    public SwingGui() {
    }
    @Override
    public void start() {
        instance = MainWindow.getInstance();
        instance.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        Message m = (Message) notification;
        JOptionPane.showMessageDialog(MainWindow.getInstance(),m.getMessage());

    }
}
