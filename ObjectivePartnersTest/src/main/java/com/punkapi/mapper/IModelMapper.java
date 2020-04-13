package com.punkapi.mapper;



import java.util.List;

/**
 * Created by Puja on 11/04/20.
 */

//maps from one object to another
public interface IModelMapper
{

   public List<com.punkapi.service.model.Beer> mapRepositoryToService(List<com.punkapi.repository.model.Beer> beer);

    public List<com.punkapi.controllers.model.Beer> mapServiceToController(List<com.punkapi.service.model.Beer> beer);

    public com.punkapi.service.model.Beer mapRepositoryToService(com.punkapi.repository.model.Beer beer);

    public com.punkapi.controllers.model.Beer mapServiceToController(com.punkapi.service.model.Beer beer);

}
