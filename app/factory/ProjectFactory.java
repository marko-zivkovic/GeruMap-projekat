package app.factory;

import app.repository.composite.MapNode;
import app.repository.imp.Project;

public class ProjectFactory extends MapNodeFactory{

    static int counter = 1;
    @Override
    public MapNode makeNode(MapNode parent) {
        return new Project("Project " + counter++ ,parent);
    }
}
