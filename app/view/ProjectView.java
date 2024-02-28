package app.view;

import app.observer.ISubscriber;
import app.painters.ElementPainter;
import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import state.StateManager;
import state.concrete.AddVezaState;
import state.concrete.SelectState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectView extends JPanel implements ISubscriber {

    private Project pro;
    private JLabel ime;
    private JLabel autor;
    private String imeAutora;
    private MojTabbedPane mtp;
    private StateManager stateManager;
    private ArrayList<ElementPainter> paintersList;

    public ProjectView(Project p){
        this.pro = p;
        imeAutora = pro.getAutor();
        pro.addSubscriber(this);
        mtp = new MojTabbedPane();
        ime = new JLabel(pro.getName());
        autor = new JLabel(imeAutora);
        stateManager = new StateManager();
        paintersList = new ArrayList<>();
        inicialized();

    }
    public void setAutor(){
        imeAutora = pro.getAutor();
        autor.setText(imeAutora);
    }
    private void inicialized(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.green);
        this.add(mtp, BorderLayout.CENTER);
        this.add(autor, BorderLayout.SOUTH);
        this.add(ime, BorderLayout.NORTH);
        autor.setHorizontalAlignment(SwingConstants.CENTER);
        ime.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVisible(true);

    }

    public MojTabbedPane getMtp() {return mtp;}
    public void setPaintersList(ArrayList<ElementPainter> paintersList) {
        this.paintersList = paintersList;
    }
    public ArrayList<ElementPainter> getPaintersList() {
        return paintersList;
    }

    ////ZA STATE METODE
    public void startAddPojam(){this.stateManager.setAddPojamState();}
    public void startAddVeza(){this.stateManager.setAddVezaState();}
    public void startSelectAction(){this.stateManager.setSelectState();}
    public void startMoveAction(){this.stateManager.setMoveState();}
    public void klikMisem(int x, int y, MapaUma m)
    {this.stateManager.getCurrent().prikazi(x,y,m);}
    public void klikMisem(int x, int y, MapaUma m, MapaUmaView mv,Element e)
    {this.stateManager.getCurrent().prikazi(x,y,m,mv,e);}
    public void klikMisem(int x,int y,MapaUma m,boolean clicked){
      if (this.stateManager.getCurrent() instanceof SelectState){
          if (clicked)
          ((SelectState)(this.stateManager.getCurrent())).setStarting( x ,  y);
          else {((SelectState)(this.stateManager.getCurrent())).prikazi(x,y,m);}
      }
    }
    public void klikMisem(int x, int y, MapaUma m, int x2, int y2){
        if(this.stateManager.getCurrent() instanceof AddVezaState)
        {
            ((AddVezaState) this.stateManager.getCurrent()).setY2(y2);
            ((AddVezaState) this.stateManager.getCurrent()).setX2(x2);
            this.stateManager.getCurrent().prikazi(x,y,m);
        }
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof String && notification.equals("delete")) {
            this.removeAll();
            this.mtp.removeAll();
        }
        if (notification instanceof MapaUma) {
            mtp.remove(((MapaUma) notification).getBrojID());
        }
        if (notification instanceof String && notification.equals("autor")) {
            setAutor(); revalidate();
        }
        if (notification instanceof String && notification.equals("novoDete")) {
            int ind = pro.getChildren().size();
            System.out.println("aaaaaaaaa "+ ind);
            MapNode novo = pro.getChildren().get(ind-1);
            MapaUmaView novomv = new MapaUmaView((MapaUma)novo);
            this.getMtp().add(((MapaUma)novo).getName(),novomv);
        }
        if (notification instanceof String && notification.equals("novoIme")) {
            ime.setText(pro.getName());
        }
    }
    public StateManager getStateManager() {
        return stateManager;
    }

    public Project getModel(){
        return pro;
    }
}
