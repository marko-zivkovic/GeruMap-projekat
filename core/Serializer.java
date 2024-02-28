package core;

import app.repository.imp.Project;

import java.io.File;

public interface Serializer {



    Project loadProject(File file);
    void saveProject(Project node);
}
