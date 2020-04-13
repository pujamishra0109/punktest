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
public class BeerRepositoryImplTest
{

}
