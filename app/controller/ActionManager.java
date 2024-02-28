package app.controller;

import state.concrete.AddVezaState;

import javax.swing.*;

public class ActionManager {

    ExitAction exitAction;
    NewProjectAction newProjectAction;
    RenameAutorAction renameAutorAction;
    DeleteAction deleteAction;
    AddPojam addPojam;
    AddVeza addVeza;
    SelectAction selectAction;
    EditorElemenataAkcija editorElemenataAkcija;
    DeleteSelectedElementAction deleteSelectedElementAction;
    ReDoAction reDoAction;
    UndoAction undoAction;
    MovePojam movePojam;
    ZoomOut zoomOut;
    ZoomIn zoomIn;

    OpenAction openAction;

    SaveAction saveAction;
    public ActionManager(){

        this.exitAction = new ExitAction();
        this.newProjectAction = new NewProjectAction();
        this.renameAutorAction = new RenameAutorAction();
        this.deleteAction = new DeleteAction();
        this.addPojam = new AddPojam();
        this.addVeza = new AddVeza();
        this.movePojam = new MovePojam();
        this.selectAction = new SelectAction();
        this.editorElemenataAkcija = new EditorElemenataAkcija();
        this.reDoAction = new ReDoAction();//reDoAction.setEnabled(false);
        this.undoAction = new UndoAction();// undoAction.setEnabled(false);
        this.deleteSelectedElementAction = new DeleteSelectedElementAction();
        this.zoomOut = new ZoomOut();
        this.zoomIn = new ZoomIn();
        this.saveAction = new SaveAction();
        this.openAction = new OpenAction();


    }

    public ExitAction getExitAction() {
        return exitAction;
    }
    public AddPojam getAddPojam() {return addPojam;}
    public MovePojam getMovePojam() {return movePojam;}
    public AddVeza getAddVeza() {return addVeza;}
    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }
    public RenameAutorAction getRenameAutorAction() {
        return renameAutorAction;
    }
    public DeleteAction getDeleteAction() {
        return deleteAction;
    }
    public SelectAction getSelectAction() {
        return selectAction;
    }
    public ReDoAction getReDoAction() {return reDoAction;}
    public UndoAction getUndoAction() {return undoAction;}
    public EditorElemenataAkcija getEditorElemenataAkcija() {
        return editorElemenataAkcija;
    }
    public DeleteSelectedElementAction getDeleteSelectedElementAction() {return deleteSelectedElementAction;}
    public ZoomOut getZoomOut() {return zoomOut;}
    public ZoomIn getZoomIn() {return zoomIn;}
    public SaveAction getSaveAction(){return saveAction;}
    public OpenAction getOpenAction(){return openAction;}
}
