package com.offcn.hmework20;

/*
class IllegalAgeException extends RuntimeException{
    private String message;
    private Throwable cause;

    public IllegalAgeException() {
    }

    public IllegalAgeException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    public IllegalAgeException(String message) {
        this.message = message;
    }

    public IllegalAgeException(Throwable cause) {
        this.cause = cause;
    }
}
*/

public class IllegalAgeException extends Throwable{
    private String message;
    private Throwable cause;

    public IllegalAgeException() {
    }

    public IllegalAgeException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    public IllegalAgeException(String message) {
        this.message = message;
    }

    public IllegalAgeException(Throwable cause) {
        this.cause = cause;
    }
}


