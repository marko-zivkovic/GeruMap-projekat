package app.repository;

import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.repository.imp.ProjectExp;
import core.MapRepository;

public class MapRepositoryImp implements MapRepository {
    private ProjectExp projectExplorer;
    public MapRepositoryImp() {
        projectExplorer = new ProjectExp("Project Explorer");
    }
    @Override
    public ProjectExp getProjectExplorer() {
        return projectExplorer;
    }
    @Override
    public void addChild(MapNodeComp parent, MapNode child) {
        //TODO: implement add Child method
    }
}
