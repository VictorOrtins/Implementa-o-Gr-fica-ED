package Estruturas;

public class InvalidPositionException extends Exception{
    protected String message;

    public InvalidPositionException(){
        this.message = null;
    }
    
    public InvalidPositionException(String message){
        setMessage(message);
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}