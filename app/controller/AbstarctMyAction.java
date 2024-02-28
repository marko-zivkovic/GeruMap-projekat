package app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public abstract class AbstarctMyAction extends AbstractAction {

    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }else {
            System.err.println("Slika nije pronadjena: " + fileName);
        }
        return icon;
    }
}
