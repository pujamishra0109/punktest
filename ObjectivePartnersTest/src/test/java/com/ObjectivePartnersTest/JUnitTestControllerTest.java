package com.ObjectivePartnersTest;

import com.punkapi.controllers.IBeerController;
import com.punkapi.repository.JpaBeerRepository;
import com.punkapi.repository.model.Beer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Puja on 13/04/20.
 */

public class JUnitTestControllerTest {

    @Autowired
    IBeerController iBeerController;

    @Autowired
    JpaBeerRepository jpaBeerRepository;

    @Test
    public void testBeerController() throws Exception{
        ResponseEntity<?> getAllBeers=iBeerController.getAllBeers(null,null,null);
        List<Beer> dbBeerList=jpaBeerRepository.findAll();
        assertEquals(getAllBeers.getBody(),dbBeerList);


    }

}
