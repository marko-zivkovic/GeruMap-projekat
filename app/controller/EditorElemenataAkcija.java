package app.controller;

import app.commands.AbstarctCommand;
import app.commands.impcommand.AddChildCommand;
import app.commands.impcommand.BojaChildCommand;
import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.tree.MapTreeImp;
import app.view.MainWindow;
import app.view.MapaUmaView;
import app.view.ProjectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EditorElemenataAkcija extends AbstarctMyAction{
    public EditorElemenataAkcija() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/opcije.png"));
        putValue(SHORT_DESCRIPTION, "PODESAVANJA");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame prozor = new JFrame();
        JLabel poruka = new JLabel("PODESAVANJA ELEMENATA");
        prozor.setSize(350,110);
        prozor.setLayout(new BorderLayout());
        prozor.setLocationRelativeTo(null);
        prozor.setVisible(true);
        prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton dugme= new JButton("Uredu");

        JTextField ime = new JTextField("name",7);
        JTextField debljina = new JTextField("0",7);
        JPanel centar = new JPanel(); centar.setLayout(new FlowLayout());
        centar.add(ime);centar.add(debljina);
        prozor.getContentPane().add(poruka,BorderLayout.NORTH);
        prozor.getContentPane().add(centar,BorderLayout.CENTER);
        prozor.getContentPane().add(dugme,BorderLayout.SOUTH);
        poruka.setHorizontalAlignment(SwingConstants.CENTER);
        JColorChooser c = new JColorChooser();
        Paint color = JColorChooser.showDialog(null,"Izaberi boju", Color.black);

        dugme.addActionListener(new ActionListener() {
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
                    Paint boja = color;
                    String name = ime.getText();
                    String stroke = debljina.getText();
                    for(MapNode ele : lista){
                        if(ele instanceof Element){
                            ((Element) ele).setStaraBoja(((Element) ele).getPaint());
                            AbstarctCommand command = new BojaChildCommand(ele,boja,mw);
                            mw.getMp().getCommandManager().addCommand(command);
                            //((Element) ele).setPaint(boja);
                            if(!stroke.equals("") || !stroke.equals("0")){((Element) ele).setStroke(new BasicStroke(Integer.valueOf(stroke)));}
                            if(!name.equals("")){((Element)ele).setName(name);}
                        }
                    }

                    mw.getSelektovani().clear();
                    mw.repaint();
                    ((MapTreeImp)MainWindow.getInstance().getMapTree()).getTreeView().updateUI();
                }
            }
        });


    }
}
