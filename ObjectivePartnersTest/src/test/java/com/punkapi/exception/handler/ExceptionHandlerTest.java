package com.punkapi.exception.handler;

import com.punkapi.controllers.model.BeerError;
import com.punkapi.exceptions.BeerException;
import com.punkapi.exceptions.BeerValidationException;
import com.punkapi.repository.IBeerRepository;
import com.punkapi.repository.JpaBeerRepository;
import com.punkapi.repository.model.Beer;
import com.punkapi.service.IBeerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Puja on 13/04/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExceptionHandlerTest {

    @Autowired
    IExceptionHandler exceptionHandler;

    @Test
    public void testHandleExceptionTypeException(){
        Exception e = new Exception();
        ResponseEntity<BeerError> responseEntity = exceptionHandler.handleException(e);
        Assert.assertTrue(null!=responseEntity.getBody());
        Assert.assertTrue(responseEntity.getBody().getErrorMessage()==e.getMessage());
        Assert.assertTrue(responseEntity.getBody().getStatusCode().equals("500"));
        Assert.assertTrue(responseEntity.getBody().getErrorDetails() == null);
        Assert.assertTrue(responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testHandleExceptionTypeBeerException(){
        BeerException e = new BeerException("Unknown Error",new ArrayIndexOutOfBoundsException());
        ResponseEntity<BeerError> responseEntity = exceptionHandler.handleException(e);
        Assert.assertTrue(null!=responseEntity.getBody());
        Assert.assertTrue(responseEntity.getBody().getErrorMessage()==e.getMessage());
        Assert.assertTrue(responseEntity.getBody().getStatusCode().equals("500"));
        Assert.assertTrue(responseEntity.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testHandleExceptionTypeBeerValidationException(){
        BeerValidationException beerValidationException = new BeerValidationException("Invalid param",new ArrayIndexOutOfBoundsException(),"id");
        ResponseEntity<BeerError> responseEntity = exceptionHandler.handleException(beerValidationException);
        Assert.assertTrue(null!=responseEntity.getBody());
        System.out.print(responseEntity.getBody().getErrorMessage());
        Assert.assertTrue(responseEntity.getBody().getErrorMessage().equals("Invalid param id"));
        Assert.assertTrue(responseEntity.getBody().getStatusCode().equals("400"));
        Assert.assertTrue(responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST);
    }
}
