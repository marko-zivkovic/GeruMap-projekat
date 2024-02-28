package app.tree.controller;

import app.repository.composite.MapNode;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import app.tree.model.MapTreeItem;
import app.view.MainWindow;
import app.view.MapaUmaView;
import app.view.MojTabbedPane;
import app.view.ProjectView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
    private Object clickedOn =null;
    private JTextField edit=null;

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent) {
            if (((MouseEvent) arg0).getClickCount() == 2) {
                NapraviTabbedPane();
            }
            if(((MouseEvent) arg0).getClickCount() == 3) {
                return true;
            }
        }
        return false;
    }

    public void NapraviTabbedPane(){
        MapTreeItem selected = (MapTreeItem) MainWindow.getInstance().getMapTree().getSelectedNode();
        MapNode mn = selected.getMapNode();
        if(mn instanceof Project){

            ProjectView proview = new ProjectView((Project)mn);
            for(MapNode mapa : ((Project)mn).getChildren()){
                MapaUmaView mapaview = new MapaUmaView((MapaUma)mapa);
                proview.getMtp().add(mapa.getName(),mapaview);
            }
            MainWindow.getInstance().setDesniPanel(proview);
            System.out.println("PROJECT VIEW");


        }
    }



    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof MapTreeItem))
            return;

        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());

    }
    private void addMyTabToTabbedPane(String nazivTaba, MapaUmaView p, MojTabbedPane mtp) {
        mtp.add(nazivTaba,p);

    }

}
