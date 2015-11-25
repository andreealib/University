package com.Universities.web.converter;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 11/19/2015.
 */
@Service
public class IntegerToCourse implements Converter<Integer, Course> {

    @Autowired
    CourseDAO courseDAO;

    public Course convert(Integer source) {

        return courseDAO.getCourseById(source);
    }
}
