package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLog extends ErrorLog{

    @Override
    public void log(String s) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ErrorLog.txt",true));
            writer.write(s);

            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Object notification) {
        Message m = (Message) notification;
        String s ="[" + m.getType() + "]" + java.time.LocalDateTime.now() + " " + m.getMessage() + "\n";
        log(s);

    }
}
