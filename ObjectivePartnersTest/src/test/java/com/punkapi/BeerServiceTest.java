package com.punkapi;

import com.punkapi.repository.IBeerRepository;
import com.punkapi.repository.JpaBeerRepository;
import com.punkapi.repository.model.Beer;
import com.punkapi.service.IBeerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by Puja on 13/04/20.
 */
@RunWith(SpringRunner.class)
public class BeerServiceTest {

    @InjectMocks
    IBeerService iBeerService;

    @Mock
    JpaBeerRepository jpaBeerRepository;

    public static final int id=1;

    @Test
    public void findByIdTest() throws Exception{
        iBeerService.getSingleBeer(id);
        verify(jpaBeerRepository).findById(Long.valueOf(id));

    }
    public void findAllTest() throws Exception{
        iBeerService.getAllBeers(1,25,null);
        verify(jpaBeerRepository).findAll();

    }

}
