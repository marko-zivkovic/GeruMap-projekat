package app.factory;

import app.repository.composite.MapNode;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import app.repository.imp.ProjectExp;

public  class FactoryUtil {

    static ElementFactory elementFactory = new ElementFactory();
    static MapaUmaFactory  mapaUmaFactory = new MapaUmaFactory();
    static ProjectFactory projectFactory = new ProjectFactory();
    public static MapNodeFactory getFactory(MapNode parent){
//        if (parent instanceof MapaUma){
//            return elementFactory;
//        }
         if(parent instanceof Project){
            return mapaUmaFactory;
        }
        else if(parent instanceof ProjectExp){
            return projectFactory;
        }

        return null;

    }
}
