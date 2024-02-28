package app.commands.impcommand;

import app.commands.AbstarctCommand;
import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.view.MapaUmaView;

import java.awt.*;

public class BojaChildCommand extends AbstarctCommand {
    private MapNode child;private MapaUmaView mw;
    private Paint boja;
    public BojaChildCommand(MapNode child, Paint p, MapaUmaView mw) {
        this.child = child;
        this.boja=p;
        this.mw = mw;
    }


    @Override
    public void doCommand() {
        if(child != null ) {
            if(child instanceof Element){
                ((Element) child).setPaint(boja); mw.repaint();
            }
        }else{return;}
    }

    @Override
    public void undoCommand() {
        if(child != null ) {
            if(child instanceof Element){
                Paint boja2 = ((Element) child).getStaraBoja();
                ((Element) child).setPaint(boja2); mw.repaint();
            }
        }else{return;}
    }
}
