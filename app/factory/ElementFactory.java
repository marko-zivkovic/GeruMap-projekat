package app.factory;

import app.repository.composite.MapNode;
import app.repository.imp.Element;

public class ElementFactory extends MapNodeFactory{

    static int counter = 0;

    @Override
    public MapNode makeNode(MapNode parent) {
        //return new Element("Element" + counter++,parent);
        return null;
    }
}
