package com.Universities.web.converter;

import com.Universities.web.Dao.StudentDAO;
import com.Universities.web.data.Student;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by andreealibotean on 11/19/2015.
 */
@Service
public class IntegerToStudent implements Converter<Integer, Student> {

    @Autowired
    StudentDAO studentDAO;

    public Student convert(Integer source) {

        return studentDAO.getStudentById(source);
    }
}
