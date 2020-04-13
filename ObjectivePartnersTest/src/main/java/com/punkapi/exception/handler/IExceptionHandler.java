package com.punkapi.exception.handler;

import com.punkapi.controllers.model.BeerError;
import com.punkapi.exceptions.BeerException;
import com.punkapi.exceptions.BeerValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by Puja on 12/04/20.
 */
//handles the exception of different type
public interface IExceptionHandler {

    public ResponseEntity<BeerError> handleException(Exception e);


    public ResponseEntity<BeerError> handleException(NoHandlerFoundException e);

    public ResponseEntity<BeerError> handleException(BeerException e);

    public  ResponseEntity<BeerError> handleException(BeerValidationException e);

}
