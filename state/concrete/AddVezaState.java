package state.concrete;

import app.commands.AbstarctCommand;
import app.commands.impcommand.AddChildCommand;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.repository.imp.VezaElement;
import app.view.MapaUmaView;
import state.State;

import java.awt.*;

public class AddVezaState implements State {
    int x2; int y2;
    @Override
    public void prikazi(int x, int y, MapaUma m) {
        Paint fill = new Color(255,255,255);
        String ime = "Element " + m.getBroj(); m.setBroj(m.getBroj()+1);
        VezaElement veza = new VezaElement(ime,m,new BasicStroke(4f),
                fill,new Point(x,y),new Dimension(100,50));
        veza.setX2(x2); veza.setY2(y2);
        AbstarctCommand command = new AddChildCommand(m,veza);
        m.getCommandManager().addCommand(command);
       // m.addChild(veza);
    }

    @Override
    public void prikazi(int x, int y, MapaUma m, MapaUmaView mv, Element ele) {

    }


    public void setX2(int x2) {this.x2 = x2;}
    public void setY2(int y2) {this.y2 = y2;}
}
