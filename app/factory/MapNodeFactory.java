package app.factory;

import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;

import java.util.Map;

 public abstract class MapNodeFactory {


     public MapNode getNode(MapNode parent){
         MapNode child = makeNode(parent);


         return child;
     }
     public abstract MapNode makeNode(MapNode parent);
}
