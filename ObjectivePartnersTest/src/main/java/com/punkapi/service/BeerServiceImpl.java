package com.punkapi.service;

import com.punkapi.exceptions.BeerException;
import com.punkapi.mapper.IModelMapper;
import com.punkapi.repository.IBeerRepository;
import com.punkapi.service.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Puja on 11/04/20.
 */
@Service
public class BeerServiceImpl implements IBeerService {

    @Autowired
    IBeerRepository iBeerRepository;

    @Autowired
    IModelMapper iModelMapper;

    @Override
    public com.punkapi.controllers.model.Beer getSingleBeer(Integer id) throws BeerException
    {
        try {
            Beer beer = iBeerRepository.getSingleBeer(id);
            com.punkapi.controllers.model.Beer mappedBeer = iModelMapper.mapServiceToController(beer);
            return mappedBeer;
        }
        catch (BeerException e){
            throw e;
        }
        catch (Exception e){
            throw new BeerException(e);
        }
    }

    @Override
    public com.punkapi.controllers.model.Beer getRandomBeer() throws BeerException {
        try {
            Beer beer = iBeerRepository.getRandomBeer();
            com.punkapi.controllers.model.Beer mappedBeer = iModelMapper.mapServiceToController(beer);
            return mappedBeer;
        }
        catch (BeerException e){
            throw e;
        }
        catch (Exception e){
            throw new BeerException(e);
        }

    }

    @Override
    public List<com.punkapi.controllers.model.Beer> getAllBeers(int page,int per_page,String searchString) throws BeerException {

        try {
            List<Beer> beers = iBeerRepository.getAllBeers(page, per_page, searchString);
            List<com.punkapi.controllers.model.Beer> beerList = new ArrayList<>();
            beerList.addAll(iModelMapper.mapServiceToController(beers));
            return beerList;
        }
        catch (BeerException e){
            throw e;
        }
        catch (Exception e){
            throw new BeerException(e);
        }
    }

}
