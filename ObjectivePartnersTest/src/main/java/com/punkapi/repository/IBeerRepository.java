package com.punkapi.repository;

import com.punkapi.exceptions.BeerException;
import com.punkapi.repository.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Puja on 11/04/20.
 */


public interface IBeerRepository  {

    public List<com.punkapi.service.model.Beer> getAllBeers(int page,int per_page,String searchString) throws BeerException;

    public  com.punkapi.service.model.Beer getSingleBeer(Integer id) throws BeerException;

    public com.punkapi.service.model.Beer getRandomBeer() throws BeerException;

}
