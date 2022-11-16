package com.example.demo.anotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target( {PARAMETER, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldsValueMatch {

    //error message
    public String message() default "Field password and password confirm must match";

    //represents group of constraints
    public Class<?>[] groups() default {};

    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};

}
