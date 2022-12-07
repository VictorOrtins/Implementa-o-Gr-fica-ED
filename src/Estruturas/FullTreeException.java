package Estruturas;

public class FullTreeException extends Exception{
    protected String message;

    public FullTreeException(){
        this.message = null;
    }
    
    public FullTreeException(String message){
        setMessage(message);
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
