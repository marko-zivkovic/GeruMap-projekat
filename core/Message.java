package core;

public class Message {

    private String type;
    private String message;

    public void setType(String type){
        this.type = type;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getType(){
        return type;
    }
    public String getMessage(){
        return message;
    }

}
