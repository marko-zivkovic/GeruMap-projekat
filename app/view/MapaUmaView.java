package app.view;

import app.observer.ISubscriber;
import app.painters.ElementPainter;
import app.painters.PojamPainter;
import app.painters.SelectPainter;
import app.painters.VezaPainter;
import app.repository.composite.MapNode;
import app.repository.imp.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class MapaUmaView extends JPanel implements ISubscriber {

    private MapaUma mp;
    double transX = 0;
    double transY = 0;
    double scale = 1;
    final static double translateFactor = 10;
    final public static double scalingFactor = 1.2;
    private AffineTransform transformation = new AffineTransform();

    private boolean pressed = false;
    private ArrayList<ElementPainter> paintersList;
    private ArrayList<MapNode> selektovani = new ArrayList<>() ;
    private JScrollBar sbVertical;
    private JScrollBar sbHorizontal;




    public MapaUmaView(MapaUma mapa) {
        this.mp = mapa;
        mp.addSubscriber(this);
        this.addMouseListener(new MyMouseController(mp,this));
        this.addMouseMotionListener(new MyMouseController(mp,this));
        this.paintersList = new ArrayList<ElementPainter>();
        Inicialized();
    }


    private void Inicialized() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);
        transformation.scale(scale,scale);
        transformation.translate(transX ,transY);

        sbHorizontal=new JScrollBar(JScrollBar.HORIZONTAL,100, 20, 0, 200);
        sbVertical=new JScrollBar(JScrollBar.VERTICAL,100, 20, 0, 200);
        //this.add(sbHorizontal,BorderLayout.SOUTH);
        //this.add(sbVertical,BorderLayout.EAST);
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof String && notification.equals("delete")) {
            this.removeAll();
        }
        if (notification instanceof String && notification.equals("novoDete") || notification.equals("deleteDete")) {
            this.repaint();
        }
    }

    public ArrayList<ElementPainter> getPaintersList() {
        return paintersList;
    }
    public ArrayList<MapNode> getSelektovani() {
        return selektovani;
    }

    public MapaUma getMp() {return mp;}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
       // g2.setTransform(transformation);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        paintersList.clear();
        LassoElement Lasso = null;
        for (MapNode element : mp.getChildren()) {
            if (element instanceof Element) {
                if (element instanceof PojamElement) {
                    ElementPainter painter = new PojamPainter((Element) element);
                    if (selektovani.contains(element)){
                        ((PojamElement) element).setPaint(new Color(0,0,253));

                    }else if (((PojamElement)element).getPaint().equals(new Color(0,0,253))){
                        ((PojamElement)element).setPaint(new Color(255,255,255));
                        System.out.println("USLO DA BOJIBNDKJVBSKJ");
                    }
                    painter.paint(g2, (Element) element);
                    paintersList.add(painter);
                }
                if (element instanceof VezaElement) {
                    ElementPainter painter = new VezaPainter((Element) element);
                    painter.paint(g2, (Element) element);
                    paintersList.add(painter);
                }
                if (element instanceof LassoElement){
                    ElementPainter painter = new SelectPainter((Element) element);
                    painter.paint(g2, (Element) element);
                 //   System.out.println("P1: " + ((LassoElement) element).getPosition().getX() + "," + ((LassoElement) element).getPosition().getY()
                 // +" P2:" + ((LassoElement) element).getPoint2().getX() + "," + ((LassoElement) element).getPoint2().getY() );
                    paintersList.add(painter);

                }
            }
        }
        if(MainWindow.getInstance().getDesniPanel() instanceof ProjectView){
            ((ProjectView) MainWindow.getInstance().getDesniPanel()).setPaintersList(paintersList);
        }
        System.out.println("Izvršena paintComponent metoda view-a");
    }
    public void zoomIn(){
        scale = scale * scalingFactor;
        System.out.println(scale);
        if(scale > 5){
            scale = 5;
            transformation.setToScale(scale,scale);
        }else{
            transformation.setToScale(scale,scale);
        }
        this.repaint();
    }
    public void zoomOut(){
        scale = scale / scalingFactor;
        System.out.println(scale);
        if(scale < 1){
            scale = 1;
            transformation.setToScale(scale,scale);
        }else{
            transformation.setToScale(scale,scale);
        }
        this.repaint();
    }

}
