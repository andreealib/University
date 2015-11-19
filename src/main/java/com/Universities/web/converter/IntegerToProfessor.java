package com.Universities.web.converter;

import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.data.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 11/19/2015.
 */
@Service
public class IntegerToProfessor implements Converter<Integer, Professor> {

    @Autowired
    ProfessorDAO professorDAO;

    public Professor convert(Integer source) {
        return professorDAO.getProfessorById(source);
    }
}
