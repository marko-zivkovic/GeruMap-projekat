package state.concrete;

import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.LassoElement;
import app.repository.imp.MapaUma;
import app.repository.imp.PojamElement;
import app.view.MapaUmaView;
import state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class SelectState implements State {
    int mainX = -1;
    int mainy = -1;
    @Override
    public void prikazi(int x, int y, MapaUma m) {
        Paint fill = new Color(220,240,239);
        String ime = "";

        LassoElement select = new LassoElement(ime,m,new BasicStroke(2f),
                fill,new Point(mainX,mainy),new Dimension(100,50));
        select.setSecondPoint(new Point(x,y));

        ArrayList<MapNode> brisanje = new ArrayList<>();
        for (MapNode element : m.getChildren()){
            if (element instanceof  LassoElement)
              brisanje.add(element);
        }
        for(MapNode element : brisanje){
            m.getChildren().remove(element);
        }
        m.addChild(select);

    }

    @Override
    public void prikazi(int x, int y, MapaUma m, MapaUmaView mv, Element ele) {
    }


    public void setStarting(int x , int y){
        mainX = x;
        mainy = y;

    }


}
