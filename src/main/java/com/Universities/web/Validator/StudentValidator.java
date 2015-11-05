package com.Universities.web.Validator;

import com.Universities.web.Model.Student;
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
        return Student.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idfaculty", "required.idfaculty", "Faculty is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required.surname", "Surname is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth_date", "required.birth_date", "Birth date is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "required.sex", "Sex is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CNP", "required.CNP", "CNP is mandatory");
    }
}
