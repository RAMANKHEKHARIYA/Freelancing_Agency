package com.agency.validator;

import com.agency.exception.MyException;

public class InputValidator {
    public void validateId(Long id) throws MyException {
        if(id <=0l){
            throw new MyException("Id is invalid");
        }
    }
}
