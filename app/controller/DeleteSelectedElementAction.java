package app.controller;

import app.commands.AbstarctCommand;
import app.commands.impcommand.AddChildCommand;
import app.commands.impcommand.DeleteCommand;
import app.repository.composite.MapNode;
import app.repository.imp.MapaUma;
import app.view.MainWindow;
import app.view.MapaUmaView;
import app.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DeleteSelectedElementAction extends AbstarctMyAction{
    public DeleteSelectedElementAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/korpa.png"));
        putValue(SHORT_DESCRIPTION, "DELETE");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView pw = null; MapaUmaView mw = null;
        ArrayList<MapNode> lista = new ArrayList<>();
        if(MainWindow.getInstance().getDesniPanel() instanceof ProjectView){
            pw = (ProjectView) MainWindow.getInstance().getDesniPanel();
            if(pw.getMtp().getSelectedComponent() instanceof MapaUmaView){
                mw = ((MapaUmaView) pw.getMtp().getSelectedComponent());
                lista = mw.getSelektovani();
            }
        }
        if(mw != null && pw != null){
            MapaUma mapa = mw.getMp();
            for(MapNode ele : lista){
                //mapa.deleteChild(ele);
                AbstarctCommand command = new DeleteCommand(mapa,ele);
                mapa.getCommandManager().addCommand(command);
            }
            mw.repaint();
            mw.getSelektovani().clear();
        }
    }
}
