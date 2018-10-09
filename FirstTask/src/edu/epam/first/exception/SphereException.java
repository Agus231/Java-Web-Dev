package edu.epam.first.exception;

public class SphereException extends Exception {
    public SphereException(){
    }

    public SphereException(String message, Throwable exception){
        super(message, exception);
    }

    public SphereException(String message){
        super(message);
    }

    public SphereException(Throwable exception){
        super(exception);
    }
}
