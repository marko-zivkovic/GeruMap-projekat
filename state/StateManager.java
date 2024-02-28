package state;

import state.concrete.AddPojamState;
import state.concrete.AddVezaState;
import state.concrete.MovePojamState;
import state.concrete.SelectState;

public class StateManager {
    private State currentState;
    private AddPojamState addPojamState;
    private AddVezaState addVezaState;
    private SelectState  selectState;
    private MovePojamState movePojamState;

    public StateManager() {
        addPojamState = new AddPojamState();
        addVezaState = new AddVezaState();
        selectState = new SelectState();
        movePojamState = new MovePojamState();
        currentState = null;
    }
    public State getCurrent(){
        return currentState;
    }
    public void setAddPojamState() {
        currentState = addPojamState;
        System.out.println("State je promenjen na Pojam");
    }
    public void setAddVezaState() {
        currentState = addVezaState;
        System.out.println("State je promenjen na Veza");
    }
    public void setSelectState(){
        currentState = selectState;
        System.out.println("State je promenjen na Select");
    }
    public void setMoveState(){
        currentState = movePojamState;
        System.out.println("State je promenjen na Move");
    }
}
