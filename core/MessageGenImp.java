package core;

import app.observer.ISubscriber;

import java.util.LinkedList;

public class MessageGenImp extends MessageGen{

    LinkedList<ISubscriber> ll = new LinkedList<ISubscriber>();

    @Override
    public void addSubscriber(ISubscriber sub) {
        ll.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        ll.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber s : ll){
            s.update(notification);
        }
    }

    @Override
    public String generateMessage(String s) {
        if (s.equals("PROJECTEXPD")){
            return "Ne mozete obrisati project explorer";
        }else if (s.equals("LEAFA")){
            return "Ne moze se dodati fajl na element";
        }else if (s.equals("AUTHORC")){
            return "Samo projektu moze da se menja ime autora";
        }else if (s.equals("EMPTYNAME")){
            return "Ime ne moze da bude prazno";
        }
        return null;
    }
}
