package com.punkapi.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.punkapi.service.model.Beer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puja on 11/04/20.
 */
@Component
public class ModelMapperImpl implements  IModelMapper {

    ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<Beer> mapRepositoryToService(List<com.punkapi.repository.model.Beer> beers) {

        List<Beer>beerList=new ArrayList<>();
        for(com.punkapi.repository.model.Beer eachBeer : beers)
            beerList.add(mapRepositoryToService(eachBeer));
        return beerList;
    }

    @Override
    public List<com.punkapi.controllers.model.Beer> mapServiceToController(List<Beer> beers) {

        List<com.punkapi.controllers.model.Beer> beerList=new ArrayList<>();
        for(Beer beer : beers){
            beerList.add(mapServiceToController(beer));
        }
        return beerList;
    }

    @Override
    public com.punkapi.service.model.Beer mapRepositoryToService(com.punkapi.repository.model.Beer beer) {

        com.punkapi.service.model.Beer beerService=modelMapper.map(beer,com.punkapi.service.model.Beer.class);

        return beerService;
    }

    @Override
    public com.punkapi.controllers.model.Beer mapServiceToController(Beer beer) {

        com.punkapi.controllers.model.Beer beerController=modelMapper.map(beer,com.punkapi.controllers.model.Beer.class);
        return beerController;


    }
}
