package com.Universities.web.Validator;


import com.Universities.web.dto.StudentDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Lei Florin on 28.09.2015.
 */
@Component
public class StudentValidator implements Validator{
    public boolean supports(Class<?> clazz) {
        return StudentDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "name is mandatory.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required.surname", "surname is mandatory.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "required.gender", "gender is mandatory.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cnp", "required.cnp", "cnp is mandatory.");
    }
}
