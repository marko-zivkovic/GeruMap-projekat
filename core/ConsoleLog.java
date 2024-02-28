package core;

public class ConsoleLog extends ErrorLog{
    @Override
    public void log(String s) {
        System.out.println(s);
    }

    @Override
    public void update(Object notification) {
        Message m = (Message)notification;

        String toConsole = "[" + m.getType() + "]" + java.time.LocalDateTime.now() + " " + m.getMessage();
        log(toConsole);

    }
}
