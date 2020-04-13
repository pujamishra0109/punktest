package com.punkapi.controllers;

import com.sun.net.httpserver.HttpServer;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServlet;

/**
 * Created by Puja on 11/04/20.
 */
public interface IBeerController {

    public ResponseEntity<?> getAllBeers(String page, String per_page, String searchString)  ;

    public ResponseEntity<?> getSinglBeer(String id)  ;


    public ResponseEntity<?> getRandomBeer()  ;

}
