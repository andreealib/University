package com.Universities.web.Mapper;

import com.Universities.web.Model.Faculty;
import com.Universities.web.Model.Professor;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public class ProfessorRowMapper implements RowMapper<Professor> {

    public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Professor professor = new Professor();
        Faculty faculty = new Faculty();

        professor.setIdProfessor(rs.getInt("idprofessor"));
        professor.setIdFaculty(rs.getInt("idfaculty"));
        professor.setName(rs.getString("name"));
        professor.setBirthDate(rs.getString("birthDate"));
        professor.setSex(rs.getString("sex"));
        professor.setCNP(rs.getString("CNP"));

        faculty.setIdfaculty(rs.getInt("idfaculty"));
        faculty.setName(rs.getString("facultyName"));
        faculty.setCity(rs.getString("city"));

        professor.setFaculty(faculty);

        return professor;

    }
}
