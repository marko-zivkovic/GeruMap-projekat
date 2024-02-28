package core;

import app.observer.IPublisher;

public abstract class MessageGen implements IPublisher {
        public Message msg;

        public void generate(String s){
            msg = new Message();
            msg.setType("ERROR");
            msg.setMessage(generateMessage(s));
            this.notifySubscribers(msg);
        }
        public abstract String generateMessage(String s);



}
