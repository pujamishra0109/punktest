package com.punkapi.exceptions;

/**
 * Created by Puja on 12/04/20.
 */
//for any validation exception
public class BeerValidationException extends BeerException {

    public String param;

    public BeerValidationException(Exception cause, String param) {
        super(cause);
        this.param = param;
    }

    public BeerValidationException(String message, Exception cause, String param) {
        super(message, cause);
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
