package app.view;

import app.painters.ElementPainter;
import app.painters.PojamPainter;
import app.painters.SelectPainter;
import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.LassoElement;
import app.repository.imp.MapaUma;
import app.repository.imp.VezaElement;
import state.concrete.AddPojamState;
import state.concrete.AddVezaState;
import state.concrete.MovePojamState;
import state.concrete.SelectState;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseController extends MouseAdapter
{

    MapaUmaView mv; MapaUma mp;
    boolean flag1;
    boolean flag2;
    Element moveEle;

  public MyMouseController(MapaUma mp, MapaUmaView mv){
      this.mv =mv;
      this.mp=mp;
  }


    public void mousePressed(MouseEvent e) {
        Point pos = e.getPoint();
        if (MainWindow.getInstance().getDesniPanel() instanceof ProjectView) {

            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof AddPojamState) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    ((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp);
                }
            }
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof MovePojamState) {
                flag2 = false;
                for (ElementPainter ele : mv.getPaintersList()) {
                    int broj = mv.getPaintersList().indexOf(ele);
                    if (ele.elementAt((Element) mp.getChildren().get(broj), pos)) {
                        System.out.println("kliknut je element");
                        //((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp, pos.x, pos.y);
                        flag2 = true;
                        moveEle = (Element) mp.getChildren().get(broj);
                    }
                }
            }
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof AddVezaState) {
                System.out.println("usao u presssed Button");
                flag1 = false;
                for (ElementPainter ele : mv.getPaintersList()) {
                    int broj = mv.getPaintersList().indexOf(ele);
                    if (ele.elementAt((Element) mp.getChildren().get(broj), pos)) {
                        System.out.println("kliknut je element");
                        ((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp, pos.x, pos.y);
                    }
                }
            }
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof SelectState) {
                mv.getSelektovani().clear();
                mv.repaint();
                ((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp, true);
            }

        }

    }
/////////////////////////////////////////////////////////////////////////////////////////
    public void mouseDragged(MouseEvent e) {
        System.out.println("Usao u mouse Dregged");
        Point pos = e.getPoint();
        if (MainWindow.getInstance().getDesniPanel() instanceof ProjectView) {
            // System.out.println("Usao u mouse Dregged");
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof AddVezaState) {
                int size = mp.getChildren().size();
                MapNode veza = mp.getChildren().get(size - 1);

                if (veza instanceof VezaElement) {
                    ((VezaElement) veza).setX2(pos.x);
                    ((VezaElement) veza).setY2(pos.y);
                    mv.repaint();
                }
            }
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof MovePojamState) {
                if(flag2){
                    System.out.println("Usao u mouse Dregged");
                    ((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp,mv,moveEle);
                    mv.repaint();
                }
            }
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof SelectState) {
                ((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp, false);
                mv.repaint();
            }

        }
    }

////////////////////////////////////////////////////////////////////////////////////////////
    public void mouseReleased(MouseEvent e) {
        Point pos = e.getPoint();
        if (MainWindow.getInstance().getDesniPanel() instanceof ProjectView) {
            if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof AddVezaState) {
                int size = mp.getChildren().size();
                MapNode veza = mp.getChildren().get(size - 1);

                for (ElementPainter ele : mv.getPaintersList()) {
                    int broj = mv.getPaintersList().indexOf(ele);
                    if (ele.elementAt((Element) mp.getChildren().get(broj), pos)) {
                        if (veza instanceof VezaElement) {
                            ((VezaElement) veza).setX2(pos.x);
                            ((VezaElement) veza).setY2(pos.y);
                        }
                        flag1 = true;
                    }

                }
                if (!flag1) {
                    mp.deleteChild(veza);
                    mv.repaint();
                }
            }if(((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof SelectState) {
                if (mv.getPaintersList().get(mv.getPaintersList().size() - 1) instanceof SelectPainter) {
                    SelectPainter selectPainter = (SelectPainter) mv.getPaintersList().get(mv.getPaintersList().size() - 1);
                    for (ElementPainter painter : mv.getPaintersList()) {
                        if (painter instanceof PojamPainter) {
                            //Area area1 = new Area(selectPainter.getShape());
                            //Area area2 = new Area( ((PojamPainter)painter).getShape());
                            if (selectPainter.getShape().getBounds2D().intersects(((PojamPainter) painter).getShape().getBounds2D())) {
                                mv.getSelektovani().add(painter.getElement());
                            }


                        }
                    }
                    LassoElement brisanje = null;
                    for (MapNode element : mp.getChildren()) {
                        if (element instanceof LassoElement) {
                            brisanje = (LassoElement) element;
                            break;
                        }
                    }
                    if (brisanje != null)
                        mp.getChildren().remove(brisanje);
                    mv.repaint();
                }else {

                }
            }
        }
        if (((ProjectView) MainWindow.getInstance().getDesniPanel()).getStateManager().getCurrent() instanceof MovePojamState) {
            if(flag2){
                ((ProjectView) MainWindow.getInstance().getDesniPanel()).klikMisem(pos.x, pos.y, mp,mv, moveEle);
            }
            flag2=false;
        }
    }


}


