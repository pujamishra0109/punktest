package com.punkapi.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.punkapi.repository.model.Beer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puja on 11/04/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ModelMapperImplTest {

    @Autowired
    IModelMapper modelMapper;

    @Test
    public void testMapRepositoryToService(){
        Beer beer = getRepoBeer();
        com.punkapi.service.model.Beer serviceBeer = modelMapper.mapRepositoryToService(beer);
        Assert.assertTrue(serviceBeer.getId().equals(beer.getId().toString()));
        Assert.assertTrue(serviceBeer.getAbv().equals(beer.getAbv().toString()));
        Assert.assertTrue(serviceBeer.getDescription().equals(beer.getDescription().toString()));
        Assert.assertTrue(serviceBeer.getFirst_brewed().equals(beer.getFirst_brewed().toString()));
        Assert.assertTrue(serviceBeer.getImage_url().equals(beer.getImage_url().toString()));
        Assert.assertTrue(serviceBeer.getName().equals(beer.getName().toString()));
        Assert.assertTrue(serviceBeer.getTagline().equals(beer.getTagline().toString()));
    }


    @Test
    public void  testMapServiceToController(){
        com.punkapi.service.model.Beer beer = getServBeer();
        com.punkapi.controllers.model.Beer serviceBeer = modelMapper.mapServiceToController(beer);
        Assert.assertTrue(serviceBeer.getId().equals(beer.getId().toString()));
        Assert.assertTrue(serviceBeer.getAbv().equals(beer.getAbv().toString()));
        Assert.assertTrue(serviceBeer.getDescription().equals(beer.getDescription().toString()));
        Assert.assertTrue(serviceBeer.getFirst_brewed().equals(beer.getFirst_brewed().toString()));
        Assert.assertTrue(serviceBeer.getImage_url().equals(beer.getImage_url().toString()));
        Assert.assertTrue(serviceBeer.getName().equals(beer.getName().toString()));
        Assert.assertTrue(serviceBeer.getTagline().equals(beer.getTagline().toString()));
    }

    @Test
    public void testMapRepositoryToServiceList(){
        List<Beer> beerList =getRepoBeerList();
        List<com.punkapi.service.model.Beer> beerListServ =  modelMapper.mapRepositoryToService(beerList);

        for(int i=0;i<beerList.size();i++){
            Beer beer = beerList.get(i);
            com.punkapi.service.model.Beer serviceBeer = beerListServ.get(i);
            Assert.assertTrue(serviceBeer.getId().equals(beer.getId().toString()));
            Assert.assertTrue(serviceBeer.getAbv().equals(beer.getAbv().toString()));
            Assert.assertTrue(serviceBeer.getDescription().equals(beer.getDescription().toString()));
            Assert.assertTrue(serviceBeer.getFirst_brewed().equals(beer.getFirst_brewed().toString()));
            Assert.assertTrue(serviceBeer.getImage_url().equals(beer.getImage_url().toString()));
            Assert.assertTrue(serviceBeer.getName().equals(beer.getName().toString()));
            Assert.assertTrue(serviceBeer.getTagline().equals(beer.getTagline().toString()));
        }
    }


    @Test
    public void testMapServiceToControllerList(){
        List<com.punkapi.service.model.Beer> beerList =getServBeerList();
        List<com.punkapi.controllers.model.Beer> beerListCon =  modelMapper.mapServiceToController(beerList);

        for(int i=0;i<beerList.size();i++){
            com.punkapi.service.model.Beer beer = beerList.get(i);
            com.punkapi.controllers.model.Beer serviceBeer = beerListCon.get(i);
            Assert.assertTrue(serviceBeer.getId().equals(beer.getId().toString()));
            Assert.assertTrue(serviceBeer.getAbv().equals(beer.getAbv().toString()));
            Assert.assertTrue(serviceBeer.getDescription().equals(beer.getDescription().toString()));
            Assert.assertTrue(serviceBeer.getFirst_brewed().equals(beer.getFirst_brewed().toString()));
            Assert.assertTrue(serviceBeer.getImage_url().equals(beer.getImage_url().toString()));
            Assert.assertTrue(serviceBeer.getName().equals(beer.getName().toString()));
            Assert.assertTrue(serviceBeer.getTagline().equals(beer.getTagline().toString()));
        }
    }

    private List<com.punkapi.service.model.Beer> getServBeerList(){
        List<com.punkapi.service.model.Beer> beerList = new ArrayList<>();
        for(int i=0;i<5;i++){
            beerList.add(getServBeer());
        }
        return beerList;
    }

    private List<Beer> getRepoBeerList(){
        List<Beer> beerList = new ArrayList<>();
        for(int i=0;i<5;i++){
            beerList.add(getRepoBeer());
        }
        return beerList;
    }


    private com.punkapi.service.model.Beer getServBeer() {
        com.punkapi.service.model.Beer beer = new com.punkapi.service.model.Beer();
        beer.setId("1");
        beer.setAbv("12331");
        beer.setDescription("Fine beer");
        beer.setFirst_brewed("09/2000");
        beer.setImage_url("http://image/url");
        beer.setName("Tuborg");
        beer.setTagline("A fine beer for a fine gentlemen");
        return beer;
    }


    private Beer getRepoBeer() {
        Beer beer = new Beer();
        beer.setId(1L);
        beer.setAbv(new BigDecimal(12331));
        beer.setDescription("Fine beer");
        beer.setFirst_brewed("09/2000");
        beer.setImage_url("http://image/url");
        beer.setName("Tuborg");
        beer.setTagline("A fine beer for a fine gentlemen");
        return beer;
    }

}
