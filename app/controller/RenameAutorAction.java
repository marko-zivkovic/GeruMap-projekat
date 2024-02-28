package app.controller;

import app.repository.composite.MapNode;
import app.repository.imp.Project;
import app.tree.model.MapTreeItem;
import app.view.MainWindow;
import core.AppFramework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class RenameAutorAction extends AbstarctMyAction{
    public RenameAutorAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/edit.png"));
        putValue(SHORT_DESCRIPTION, "autor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame prozor = new JFrame();
        JLabel poruka = new JLabel("Unesite novo ime autora");
        prozor.setSize(300,150);
        prozor.setLayout(new BorderLayout());
        prozor.setLocationRelativeTo(null);
        prozor.setVisible(true);
        prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField text = new JTextField();
        JButton dugme = new JButton("Promeni");

        prozor.getContentPane().add(poruka,BorderLayout.NORTH);
        prozor.getContentPane().add(text,BorderLayout.CENTER);
        prozor.getContentPane().add(dugme,BorderLayout.SOUTH);
        poruka.setHorizontalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        dugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapTreeItem selected = (MapTreeItem) MainWindow.getInstance().getMapTree().getSelectedNode();
                MapNode mn = selected.getMapNode();
                if( mn instanceof Project){
                    System.out.println(((Project) mn).getAutor());
                    ((Project) mn).setAutor(text.getText());
                    System.out.println(((Project) mn).getAutor());
                }
                else{
                    AppFramework.getInstance().getErrorGenerator().generate("AUTHORC");}
            }
        });
    }
}
