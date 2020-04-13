package com.punkapi.service;

import com.punkapi.exceptions.BeerException;
import com.punkapi.service.model.Beer;

import java.util.List;

/**
 * Created by Puja on 11/04/20.
 */
public interface IBeerService
{

    public List<com.punkapi.controllers.model.Beer> getAllBeers(int page,int per_page,String searchString) throws BeerException;

    public com.punkapi.controllers.model.Beer getSingleBeer(Integer id) throws BeerException;

    public  com.punkapi.controllers.model.Beer getRandomBeer() throws BeerException;
}
