package com.punkapi;

import com.punkapi.repository.IBeerRepository;
import com.punkapi.repository.JpaBeerRepository;
import com.punkapi.repository.model.Beer;
import com.punkapi.service.IBeerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Puja on 13/04/20.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BeerServiceTest {

    @Autowired
    IBeerService iBeerService;

    @Mock
    JpaBeerRepository jpaBeerRepository;

    public static final Long id=1L;

    @Test
    public void getSingleBeerTest() throws Exception{
        when(jpaBeerRepository.findById(id).get()).thenReturn(new Beer(id,"Buzz","A Real Bitter Experience.","09/2007",
                "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.","https://images.punkapi.com/v2/keg.png",
                new BigDecimal(4.5)));
        com.punkapi.controllers.model.Beer expectedBeer=new com.punkapi.controllers.model.Beer(id.toString(),"Buzz","A Real Bitter Experience.","09/2007",
                "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.","https://images.punkapi.com/v2/keg.png",
                "4.5");
        assertEquals(expectedBeer,iBeerService.getSingleBeer(Integer.valueOf(id.toString())));


    }
    public void findAllTest() throws Exception{
        iBeerService.getAllBeers(1,25,null);
        verify(jpaBeerRepository).findAll();

    }

}
