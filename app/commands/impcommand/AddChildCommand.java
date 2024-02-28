package app.commands.impcommand;

import app.commands.AbstarctCommand;
import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.tree.model.MapTreeItem;

public class AddChildCommand extends AbstarctCommand {
//    private MapTreeItem parent;
//    private MapTreeItem child;
    private MapNode parent;
    private MapNode child;

    public AddChildCommand(MapNode parent, MapNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {
//        parent.addC(child);
////      ((MapNodeComp) parent.getMapNode()).addChild(child.getMapNode());
        if(child != null ||  parent != null) {
            if(child instanceof Element && parent instanceof MapaUma){
                ((MapaUma) parent).addChild((Element)child);
            }
        }else{return;}
    }

    @Override
    public void undoCommand() {
        if(child != null ||  parent != null) {
            if(child instanceof Element && parent instanceof MapaUma){
                ((MapaUma) parent).deleteChild((Element)child);
            }
        }else{return;}
    }
}
