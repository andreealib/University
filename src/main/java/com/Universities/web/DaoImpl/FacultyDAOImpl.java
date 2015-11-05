package com.Universities.web.DaoImpl;

import com.Universities.web.Dao.FacultyDAO;
//import com.Universities.web.Mapper.FacultyDropBoxMapper;
import com.Universities.web.Mapper.FacultyRowMapper;
import com.Universities.web.Model.Faculty;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.util.*;

/**
 * Created by Lei Florin on 18.09.2015.
 */
public class FacultyDAOImpl extends JdbcDaoSupport implements FacultyDAO {

    @Autowired
    public FacultyDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * Method to insert a new entry in "faculties" table.
     * @param faculty Faculty object which will be inserted.
     */
    public void insert(Faculty faculty) {
        String SQL = "INSERT INTO faculties(name, city, info) VALUE (?, ?, ?)";
        Object[] object = new Object[] {faculty.getName(), faculty.getCity(), faculty.getInfo()};

        getJdbcTemplate().update(SQL, object);
    }

    /**
     * Method to update an entry from "faculties" table based on "idfaculty" param.
     * @param faculty Faculty object which will be updated.
     * @param idfaculty id of faculty.
     */
    public void update(Faculty faculty, int idfaculty) {
        String SQL = "UPDATE faculties set name=?, city=?, info=? WHERE idfaculty=?";
        Object[] object = new Object[] {faculty.getName(), faculty.getCity(), faculty.getInfo(), idfaculty};

        getJdbcTemplate().update(SQL, object);
    }

    /**
     * Method to delete an entry from "faculties" table based on "idfaculty" param.
     * @param idfaculty id of faculty which will be deleted.
     */
    public void delete(int idfaculty) {
        String SQL = "DELETE FROM faculties WHERE idfaculty=?";
        getJdbcTemplate().update(SQL, new Object[]{idfaculty});
    }

    /**
     * Method to find a entry from "faculties" table based on "idfacultie" param.
     * @param idfaculty id of Faculty object which will be searched.
     * @return Faculty object.
     */
    public Faculty findByFacultyId(int idfaculty) {
        String SQL = "SELECT * FROM faculties WHERE idfaculty = ?";
        Faculty faculty = (Faculty) getJdbcTemplate().queryForObject(SQL, new Object[] {idfaculty}, new FacultyRowMapper());
        return faculty;
    }

    public List<Faculty> findByFacultyName(String name) {
        String SQL = "SELECT * FROM faculties WHERE name = %?%";
        List<Faculty> facultyList = getJdbcTemplate().query(SQL, new Object[]{name}, new FacultyRowMapper());
        return facultyList;
    }

    public Faculty findByFacultyCity(String city) {
        String SQL = "SELECT * FROM faculties WHERE city = ?";
        Faculty faculty = (Faculty) getJdbcTemplate().queryForObject(SQL, new Object[]{city}, new FacultyRowMapper());
        return faculty;
    }

    /**
     * Method to find all entries from "faculties" table.
     * @return List<Faculty> list objects.
     */
    public List<Faculty> getAllFaculties() {
        String SQL = "SELECT * FROM faculties";
            List<Faculty> faculties = new ArrayList<Faculty>();
            List<Map<String, Object>> rewResults = getJdbcTemplate().queryForList(SQL);
            for(Map<String, Object> row : rewResults) {
                Faculty f = new Faculty();
                f.setIdfaculty((Long) row.get("idfaculty"));
                f.setName((String) row.get("name"));
                f.setCity((String) row.get("city"));
                f.setInfo((String) row.get("info"));
                faculties.add(f);
        }
        return faculties;
    }
}
