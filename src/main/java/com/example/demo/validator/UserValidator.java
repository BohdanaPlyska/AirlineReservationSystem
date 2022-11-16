package com.example.demo.validator;

import com.example.demo.constants.ValidationConstants;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.example.demo.constants.ValidationConstants.*;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserRequest user = (UserRequest) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidationConstants.VALIDATION_FIELD_EMAIL, NOT_EMPTY);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidationConstants.VALIDATION_FIELD_EMAIL, NOT_EMPTY);
        if (user.getEmail().length() < MIN_EMAIL_FIELD_VALUE || user.getEmail().length() > MAX_FIELD_VALUE) {
            errors.rejectValue(ValidationConstants.VALIDATION_FIELD_EMAIL, "Email should have between 4 and 32 characters");
        }
        if (!userService.findUserByEmail(user).isEmpty()) {
            errors.rejectValue(ValidationConstants.VALIDATION_FIELD_EMAIL, "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidationConstants.VALIDATION_FIELD_PASSWORD, NOT_EMPTY);
        if (user.getPassword().length() < MIN_PASSWORD_FIELD_VALUE || user.getPassword().length() > MAX_FIELD_VALUE) {
            errors.rejectValue(ValidationConstants.VALIDATION_FIELD_PASSWORD, "size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue(ValidationConstants.VALIDATION_FIELD_PASSWORD_CONFIRM, "diff.userForm.passwordConfirm");
        }
    }

}
