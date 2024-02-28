package core;

import app.observer.ISubscriber;

public abstract class ErrorLog implements ISubscriber {


    public abstract void log(String s);
}
