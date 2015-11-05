package com.Universities.web.Mapper;

import com.Universities.web.Model.Course;
import com.Universities.web.Model.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lei Florin on 01.10.2015.
 */
public class CourseRowMapper implements RowMapper<Course> {
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

        Course course = new Course();
        Faculty faculty = new Faculty();

        course.setIdcourse(rs.getInt("idcourse"));
        course.setIdfaculty(rs.getInt("idfaculty"));
        course.setName(rs.getString("name"));
        course.setProfessorName(rs.getString("professorName"));

        faculty.setIdfaculty(rs.getInt("idfaculty"));
        faculty.setName(rs.getString("facultyName"));

        course.setFaculty(faculty);
        return course;
    }
}
