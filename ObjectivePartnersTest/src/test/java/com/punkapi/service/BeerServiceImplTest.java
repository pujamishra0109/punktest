package com.punkapi.service;

import com.punkapi.controllers.model.Beer;
import com.punkapi.exceptions.BeerException;
import com.punkapi.mapper.IModelMapper;
import com.punkapi.repository.IBeerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Puja on 11/04/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeerServiceImplTest {

    @Autowired
    IBeerService beerService;

    @Test
    public void testGetSingleBeer() throws BeerException {
        Beer beer = beerService.getSingleBeer(1);
        System.out.print(beer.getId()+" "+ beer.getName()+ beer.getAbv());
        Assert.assertTrue(beer.getId().equals("1"));

    }

    @Test
    public void testGetRandomBeer() throws BeerException {
        Beer beer = beerService.getRandomBeer();
        Assert.assertTrue(null!=beer);
    }

    public void testGetAllBeers() throws Exception{
        List<Beer> beerList = beerService.getAllBeers(1,20,null);
        Assert.assertTrue(beerList.size()<=20);
    }
}
