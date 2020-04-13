package com.punkapi.controllers;

import com.punkapi.exception.handler.IExceptionHandler;
import com.punkapi.exceptions.BeerValidationException;
import com.punkapi.service.IBeerService;
import com.punkapi.validators.IBeerValidator;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by Puja on 10/04/20.
 */


public class BeerControllerImplTest  {

    @Autowired
    IBeerService iBeerService;

    @Autowired
    IExceptionHandler exceptionHandler;

    @Autowired
    IBeerValidator iBeerValidator;



}

