package app.factory;

import app.repository.composite.MapNode;
import app.repository.imp.MapaUma;

public class MapaUmaFactory extends MapNodeFactory{

    static int counter = 1;
    @Override
    public MapNode makeNode(MapNode parent) {
        return new MapaUma("MapaUma " + counter++,parent);
    }
}
