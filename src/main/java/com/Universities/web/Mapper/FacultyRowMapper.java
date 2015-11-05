package com.Universities.web.Mapper;

import com.Universities.web.Model.Course;
import com.Universities.web.Model.Faculty;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lei Florin on 21.09.2015.
 */
public class FacultyRowMapper implements RowMapper<Faculty> {
    public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setIdfaculty(rs.getLong("idfaculty"));
        faculty.setName(rs.getString("name"));
        faculty.setCity(rs.getString("city"));
        faculty.setInfo(rs.getString("info"));
        return faculty;
    }
}
