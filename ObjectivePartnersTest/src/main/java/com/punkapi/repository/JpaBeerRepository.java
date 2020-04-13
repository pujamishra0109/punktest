package com.punkapi.repository;

import com.punkapi.repository.model.Beer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Puja on 11/04/20.
 */

//To access data access layer
@Repository
public interface JpaBeerRepository extends JpaRepository<Beer,Long> {

//    @Query( "SELECT o.id FROM Beer o ORDER BY random()")
//    Beer getRandomBeer();

    List<Beer> findByNameOrDescriptionContainingIgnoreCase(String name,String description, Pageable pageable);

}
