package com.Universities.web.Validator;

import com.Universities.web.Model.Faculty;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Lei Florin on 26.09.2015.
 */
@Component
public class FacultyValidator implements Validator{
    public boolean supports(Class<?> clazz) {
        return Faculty.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "name is mandatory!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "required.city", "city is mandatory!");
    }
}
