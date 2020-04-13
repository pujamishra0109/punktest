package com.punkapi.repository;

import com.punkapi.exceptions.BeerException;
import com.punkapi.mapper.IModelMapper;
import com.punkapi.repository.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by Puja on 11/04/20.
 */
@Component
public class BeerRepositoryImpl implements IBeerRepository
{
    @Autowired
    JpaBeerRepository beerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IModelMapper iModelMapper;


    /*
       Gets all the beers and uses the default pagination if not provided
       or filters by pagination or search result

     */
    @Override
    public List<com.punkapi.service.model.Beer> getAllBeers(int page,int per_page,String searchString) throws BeerException {
        try {

            List<Beer>beerList=new ArrayList<>();
            Pageable defaultPages = PageRequest.of(page-1,per_page, Sort.by("id"));

            /*filters the beer list by matching the search string on name or decscription

               it check if the name or description contains a string like the search paramter
             */

            if (Objects.nonNull(searchString))
                beerList = beerRepository.findByNameOrDescriptionContainingIgnoreCase(searchString, searchString, defaultPages);
            else
                beerList = beerRepository.findAll(defaultPages).toList();

            List<com.punkapi.service.model.Beer> beerServiceList = new ArrayList<>();
            beerServiceList.addAll(iModelMapper.mapRepositoryToService(beerList));
            return beerServiceList;
        }
        catch (Exception e)
        {
            BeerException beerException=new BeerException("Unknow Exception",e);
            throw beerException;
        }

    }


   // To return a random beer
    @Override
    public com.punkapi.service.model.Beer getRandomBeer() throws BeerException{
        try {
            // It will randomly select a beer and return

            String query = "SELECT o.id FROM Beer o ORDER BY random()";
            Query q = entityManager.createQuery(query).setMaxResults(1);
            Beer beer = beerRepository.findById((Long) q.getResultList().get(0)).get();
            return iModelMapper.mapRepositoryToService(beer);
        }
        catch (Exception e){
            throw  new BeerException(e);
        }
    }
    /* It will return a beer based on the id */
    @Override
    public com.punkapi.service.model.Beer getSingleBeer(Integer id) throws BeerException {
       try
       {
           Beer beer = beerRepository.findById(Long.valueOf(id)).get();
           com.punkapi.service.model.Beer mappedBeer = iModelMapper.mapRepositoryToService(beer);
           return mappedBeer;
       }
       catch (Exception e){
           throw  new BeerException("No beer found that matches the ID "+ id,e);
       }
    }
}
