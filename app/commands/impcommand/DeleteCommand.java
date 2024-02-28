package app.commands.impcommand;

import app.commands.AbstarctCommand;
import app.repository.composite.MapNode;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;

public class DeleteCommand extends AbstarctCommand {
    private MapNode parent;
    private MapNode child;

    public DeleteCommand(MapNode parent, MapNode child) {
        this.parent = parent;
        this.child = child;
    }
    @Override
    public void doCommand() {
        if(child != null ||  parent != null) {
            if(child instanceof Element && parent instanceof MapaUma){
                ((MapaUma) parent).deleteChild((Element)child);
            }
        }else{return;}
    }

    @Override
    public void undoCommand() {
        if(child != null ||  parent != null) {
            if(child instanceof Element && parent instanceof MapaUma){
                ((MapaUma) parent).addChild((Element)child);
            }
        }else{return;}
    }
}
