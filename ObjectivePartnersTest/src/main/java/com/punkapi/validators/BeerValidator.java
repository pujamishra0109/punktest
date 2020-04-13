package com.punkapi.validators;

import com.punkapi.exceptions.BeerException;
import com.punkapi.exceptions.BeerValidationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Puja on 12/04/20.
 */
@Component
public class BeerValidator implements  IBeerValidator {

    @Override
    public void validateParams(String param,String queryParam) throws BeerValidationException {
                int params=0;
            try {
                if(Objects.isNull(param))
                    throw new BeerValidationException(new NullPointerException("Query parameter cannot be null"),param);
                 params = Integer.parseInt(param);

                 if(params<=0)
                    throw new BeerValidationException(new IllegalArgumentException("Invalid query param "+ params),param);
            }
            catch (NumberFormatException e) {

                BeerValidationException beerValidationException=new BeerValidationException(queryParam+" should be a positive integer. Entered valus is ",e,param);
                throw beerValidationException;
                }

            catch (BeerValidationException e)
            {
             BeerValidationException beerValidationException=new BeerValidationException(queryParam+" should be a positive integer. Entered value is ",e.getCause(),e.getParam());
             throw beerValidationException;
            }


    }
}
