package state.concrete;

import app.commands.AbstarctCommand;
import app.commands.impcommand.AddChildCommand;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.repository.imp.PojamElement;
import app.view.MapaUmaView;
import state.State;

import java.awt.*;

public class AddPojamState implements State {
    @Override
    public void prikazi(int x, int y, MapaUma m) {
        Paint fill = new Color(255,255,255);
        String ime = "Element " + m.getBroj(); m.setBroj(m.getBroj()+1);

        PojamElement pojam = new PojamElement(ime,m,new BasicStroke(2f),
                fill,new Point(x,y),new Dimension(100,50));
       // m.addChild(pojam);
        AbstarctCommand command = new AddChildCommand(m,pojam);
        m.getCommandManager().addCommand(command);

    }

    @Override
    public void prikazi(int x, int y, MapaUma m, MapaUmaView mv, Element ele) {

    }

}
