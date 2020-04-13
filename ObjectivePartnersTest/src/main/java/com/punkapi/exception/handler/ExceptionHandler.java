package com.punkapi.exception.handler;

import com.punkapi.controllers.model.BeerError;
import com.punkapi.exceptions.BeerException;
import com.punkapi.exceptions.BeerValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by Puja on 12/04/20.
 */
//handles the exception of different type
@Service
public class ExceptionHandler implements  IExceptionHandler {

    @Override
    public ResponseEntity<BeerError> handleException(Exception e) {
        BeerError beerError=new BeerError();
        beerError.setStatusCode("500");
        beerError.setErrorMessage(e.getMessage());
        if(null!=e.getCause())
            beerError.setErrorDetails(e.getCause().getMessage());
        return new ResponseEntity<BeerError>(beerError, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<BeerError> handleException(BeerException e) {
        BeerError beerError=new BeerError();
        beerError.setStatusCode("500");
        beerError.setErrorMessage(e.getMessage());
        if(null!=e.getCause())

            beerError.setErrorDetails(e.getCause().getMessage());
        return new ResponseEntity<BeerError>(beerError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<BeerError> handleException(NoHandlerFoundException e) {

        BeerError beerError=new BeerError();
        beerError.setStatusCode("404");
        beerError.setErrorMessage(e.getMessage());
        if(null!=e.getCause())

            beerError.setErrorDetails(e.getCause().getMessage());
        return new ResponseEntity<BeerError>(beerError, HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<BeerError> handleException(BeerValidationException e) {

        BeerError beerError=new BeerError();
        beerError.setStatusCode("400");
        beerError.setErrorMessage(e.getMessage()+" " +e.getParam());
        if(null!=e.getCause())

            beerError.setErrorDetails(e.getCause().getMessage());
        return new ResponseEntity<BeerError>(beerError, HttpStatus.BAD_REQUEST);

    }
}
