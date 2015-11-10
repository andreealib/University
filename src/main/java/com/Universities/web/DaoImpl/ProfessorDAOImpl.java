package com.Universities.web.DaoImpl;

import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.Mapper.ProfessorRowMapper;
import com.Universities.web.Model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by andreealibotean on 11/9/2015.
 */

public class ProfessorDAOImpl extends JdbcDaoSupport implements ProfessorDAO {
    @Autowired
    public ProfessorDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public void insert(Professor professor) {
        String SQL = "insert into professors (idprofessor,idfaculty,name,birthDate,sex,CNP) value(?,?,?,?,?,?) ";
        Object[] object = new Object[]{professor.getIdprofessor(), professor.getIdfaculty(), professor.getName(), professor.getBirthDate(), professor.getSex(), professor.getCNP()};
        getJdbcTemplate().update(SQL, object);
    }

    public void update(Professor professor, int idprofessor) {
        String SQL = "update professors set name=?, birthDate=?, sex=?, CNP=? where idprofessor=?";
        Object[] object = new Object[]{professor.getName(), professor.getBirthDate(), professor.getSex(), professor.getCNP(), idprofessor};
        getJdbcTemplate().update(SQL, object);

    }

    public void delete(int idprofessor) {
        String SQL = "delete from professors where idprofessor=?";
        getJdbcTemplate().update(SQL, new Object[]{idprofessor});
    }

    public List<Professor> getAllProfessors() {
        String SQL = "select professors.idprofessor,professors.idfaculty,professors.name,professors.birthDate,professors.sex,professors.CNP," +
                "faculties.idfaculty,faculties.name as facultyName,faculties.city from professors,faculties where professors.idfaculty=faculties.idfaculty";

        ProfessorRowMapper professorRowMapper = new ProfessorRowMapper();
        List<Professor> professorList = getJdbcTemplate().query(SQL, professorRowMapper);

        return professorList;
    }

    public Professor findByProfessorId(int idprofessor) {
        String SQL = "select professors.*,faculties.idfaculty,faculties.name as facultyName,faculties.city from professors,faculties " +
                "where professors.idfaculty=faculties.idfaculty and professors.idprofessor=?";
        Professor professor = (Professor) getJdbcTemplate().queryForObject(SQL, new Object[]{idprofessor}, new ProfessorRowMapper());
        return professor;
    }
}
