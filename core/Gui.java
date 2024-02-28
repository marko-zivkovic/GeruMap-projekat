package core;

import app.observer.ISubscriber;

import java.util.concurrent.Flow;

public interface Gui extends ISubscriber{
    void start();
}
