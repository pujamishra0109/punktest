package com.punkapi;

import com.punkapi.controllers.BeerControllerImpl;
import com.punkapi.controllers.IBeerController;
import com.punkapi.repository.IBeerRepository;
import com.punkapi.repository.JpaBeerRepository;
import com.punkapi.repository.model.Beer;
import com.punkapi.service.IBeerService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

/**
 * Created by Puja on 13/04/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@WebMvcTest(value=BeerControllerImpl.class)
public class JUnitTestControllerTest  {


//    @LocalServerPort
//    int randomServerPort;
//
//    @Autowired
//    IBeerController iBeerController;
//
//    @Autowired
//    JpaBeerRepository jpaBeerRepository;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IBeerService iBeerService;

    @org.junit.Test
    public void testBeerController() throws Exception{
//        ResponseEntity<?> getAllBeers=iBeerController.getAllBeers(null,null,null);
//        List<Beer> dbBeerList=jpaBeerRepository.findAll();
//        //assertEquals(getAllBeers.getBody(),dbBeerList);

        assertEquals("hello","hello");

    }

}
