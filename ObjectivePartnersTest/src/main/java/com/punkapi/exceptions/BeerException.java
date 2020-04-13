package com.punkapi.exceptions;

/**
 * Created by Puja on 12/04/20.
 */
//for any exception
public class BeerException extends Exception {

    private Exception cause;

    public BeerException(Exception cause) {
        this.cause = cause;
    }

    public BeerException(String message, Exception cause) {
        super(message);
        this.cause = cause;
    }

    @Override
    public Exception getCause() {
        return cause;
    }

    public void setCause(Exception cause) {
        this.cause = cause;
    }

}
