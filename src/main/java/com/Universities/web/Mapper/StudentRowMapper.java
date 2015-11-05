package com.Universities.web.Mapper;

import com.Universities.web.Model.Faculty;
import com.Universities.web.Model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lei Florin on 28.09.2015.
 */
public class StudentRowMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();
        Faculty faculty = new Faculty();

        student.setIdstudent(rs.getInt("idstudent"));
        student.setIdfaculty(rs.getInt("idfaculty"));
        student.setName(rs.getString("name"));
        student.setSurname(rs.getString("surname"));
        student.setBirth_date(rs.getString("birthDate"));
        student.setSex(rs.getString("sex"));
        student.setCNP(rs.getString("CNP"));

        faculty.setIdfaculty(rs.getInt("idfaculty"));
        faculty.setName(rs.getString("facultyName"));
        faculty.setCity(rs.getString("city"));

        student.setFaculty(faculty);
        return student;
    }
}
