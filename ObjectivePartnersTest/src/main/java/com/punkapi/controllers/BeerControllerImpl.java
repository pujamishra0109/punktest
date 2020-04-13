package com.punkapi.controllers;

import com.punkapi.exception.handler.IExceptionHandler;
import com.punkapi.exceptions.BeerValidationException;
import com.punkapi.service.IBeerService;
import com.punkapi.validators.IBeerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by Puja on 10/04/20.
 */

@RestController
public class BeerControllerImpl implements IBeerController {

    @Autowired
    IBeerService iBeerService;

    @Autowired
    IExceptionHandler exceptionHandler;

    @Autowired
    IBeerValidator iBeerValidator;


      /*
      Returns a single beer object by beer id
       @param name- id which is the id of the beer to be returned
    */

    @Validated
    @Override
    @RequestMapping(value = "/beers/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getSinglBeer(@PathVariable(value = "id")String id) {
        try {
            iBeerValidator.validateParams(id,"id");

            return new ResponseEntity<Object>(iBeerService.getSingleBeer(Integer.parseInt(id)), HttpStatus.OK);
        }
        catch (BeerValidationException e){
              return exceptionHandler.handleException(e);
        }

        catch (Exception e){
            return exceptionHandler.handleException(e);
        }

    }

    /*
        Returns all the beers with the default pagination from 1 to 25. There are optional query parameters like page,per_page and search
         @RequestParam - page- > which is the page number to be returned
         @RequestParam- per_page -> which is the number of beers per page
         @RequestParam- search -> which the filter on name or description of the beer
      */
    @RequestMapping(value = "/beers", method = RequestMethod.GET, produces = "application/json")
    @Validated
    public ResponseEntity<?> getAllBeers(@RequestParam(value = "page",required = false,defaultValue = "1")String page,
                                         @Max(80)@RequestParam(value="per_page",required = false,defaultValue = "25")String per_page,
                                         @RequestParam(value="search",required = false)String searchStr)  {

        try
        {

            iBeerValidator.validateParams(page,"page");
            iBeerValidator.validateParams(per_page,"per_page");


            return new ResponseEntity<Object>(iBeerService.getAllBeers(Integer.parseInt(page), Integer.parseInt(per_page), searchStr), HttpStatus.OK);
        }


        catch (BeerValidationException e){
            return exceptionHandler.handleException(e);
        }


        catch (Exception e)
        {
            return exceptionHandler.handleException(e);
        }
    }

     /*
        Return a random beer from the beer list
     */

    @RequestMapping(value = "/beers/random", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<?> getRandomBeer() {

        try{
            return new ResponseEntity<Object>(iBeerService.getRandomBeer(),HttpStatus.OK);
        }
        catch (Exception e){
            return exceptionHandler.handleException(e);
        }

    }



}

