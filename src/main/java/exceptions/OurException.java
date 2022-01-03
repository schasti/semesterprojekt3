package exceptions;

public class OurException extends Exception {

    @Override
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    String Message ="Error 420";

}
