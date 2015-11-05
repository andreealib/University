package com.Universities.web.Mapper;

import com.Universities.web.Model.StudentsAtCourse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lei Florin on 02.10.2015.
 */
public class StudentsAtCourseRowMapper implements RowMapper<StudentsAtCourse> {
    public StudentsAtCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentsAtCourse studentsAtCourse = new StudentsAtCourse();

        studentsAtCourse.setIdstudent(rs.getInt("idstudent"));
        studentsAtCourse.setIdfaculty(rs.getInt("idfaculty"));
        studentsAtCourse.setIdcourse(rs.getInt("idcourse"));

        return studentsAtCourse;
    }
}
