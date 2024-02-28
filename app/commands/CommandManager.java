package app.commands;

import app.view.MainWindow;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstarctCommand> commands = new ArrayList<AbstarctCommand>();
    private int currentCommand = 0;

    public void addCommand(AbstarctCommand command){
        while(currentCommand < commands.size()){
            commands.remove(currentCommand);
        }
        commands.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
           // MainWindow.getInstance().enableUndoAction();
        }
        if(currentCommand==commands.size()){
            //MainWindow.getInstance().disableRedoAction();
        }
    }
    public void undoCommand(){
        if(currentCommand > 0){
            //MainWindow.getInstance().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            //MainWindow.getInstance().disableUndoAction();
        }
    }

}
