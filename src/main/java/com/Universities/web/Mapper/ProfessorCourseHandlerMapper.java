package com.Universities.web.Mapper;

import com.Universities.web.Model.ProfessorCourseHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public class ProfessorCourseHandlerMapper implements RowMapper<ProfessorCourseHandler> {
    public ProfessorCourseHandler mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProfessorCourseHandler professorCourseHandler = new ProfessorCourseHandler();
        professorCourseHandler.setIdcourse(rs.getInt("idcourse"));
        professorCourseHandler.setIdprofessor(rs.getInt("idprofessor"));

        return professorCourseHandler;
    }

}
