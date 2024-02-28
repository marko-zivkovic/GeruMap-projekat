package state.concrete;

import app.painters.ElementPainter;
import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.repository.imp.VezaElement;
import app.view.MapaUmaView;
import state.State;

import java.awt.*;

public class MovePojamState implements State {
    @Override
    public void prikazi(int x, int y, MapaUma m) {}

    @Override
    public void prikazi(int x, int y, MapaUma m, MapaUmaView mv, Element ele) {
        Point pos = new Point(x,y);
        ele.setPosition(pos); mv.repaint();
        for(MapNode veza: m.getChildren()){
            if(veza instanceof VezaElement){
                Point point1 = new Point(((VezaElement) veza).getX2(),((VezaElement) veza).getY2());
                Point point2 = new Point(((VezaElement) veza).getPosition());
                //if (ele.elementAt((Element) mp.getChildren().get(broj), pos))
                for(ElementPainter ep : mv.getPaintersList()){
                    if(ep.getElement().getName().equals(ele.getName())){
                        if(ep.elementAt(ele,point1)){
                            ((VezaElement) veza).setX2(pos.x);
                            ((VezaElement) veza).setY2(pos.y); mv.repaint();
                        }
                        if(ep.elementAt(ele,point2)){
                            ((VezaElement) veza).setPosition(pos); mv.repaint();
                        }
                    }
                }
            }
        }
    }

}
