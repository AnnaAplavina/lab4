package exceptions;

public class TrollsNameException extends Exception{
    private String exc;
    public TrollsNameException(String message){
        super(message);
        exc = message;
    }
    public String getExc(){
        return exc;
    }
}
