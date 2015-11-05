package com.Universities.web.Validator;

import com.Universities.web.Model.Course;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Lei Florin on 01.10.2015.
 */

@Component
public class CourseValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Course.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idfaculty", "required.idfaculty", "Faculty is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "professorName", "required.professorName", "Professor name is mandatory");
    }
}
