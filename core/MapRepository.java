package core;

import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.repository.imp.ProjectExp;

public interface MapRepository {
    ProjectExp getProjectExplorer();
    void addChild(MapNodeComp parent, MapNode child);
}
