package com.punkapi.validators;

import com.punkapi.exceptions.BeerValidationException;

/**
 * Created by Puja on 12/04/20.
 */
public interface IBeerValidator {

    public void    validateParams(String params,String queryParam) throws BeerValidationException;
}
