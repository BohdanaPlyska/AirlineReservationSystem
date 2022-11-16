package com.example.demo.anotations;


import com.example.demo.request.UserRequest;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, UserRequest> {

    @Override
    public boolean isValid(UserRequest user, ConstraintValidatorContext constraintValidatorContext) {
        //validation for matcher passwords
        try {
            return user.getPassword().equals(user.getPasswordConfirm());
        }catch (Exception ex) {
            log.error("Exception" + ex);
            return false;
        }

    }

}
