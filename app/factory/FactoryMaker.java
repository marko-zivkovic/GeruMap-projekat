package app.factory;

import app.repository.composite.MapNode;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import app.repository.imp.ProjectExp;

public class FactoryMaker {


    MapNodeFactory factory;

    public MapNode make(MapNode parent){

//        if (parent instanceof MapaUma){
//            factory = new ElementFactory();
//        }
        if(parent instanceof Project){
            factory = new MapaUmaFactory();
        }
        else if(parent instanceof ProjectExp){
            factory = new ProjectFactory();
        }
        else {
            factory = null;
        }
        if (factory == null){
            return null;
        }else
            return factory.makeNode(parent);



    }
}
