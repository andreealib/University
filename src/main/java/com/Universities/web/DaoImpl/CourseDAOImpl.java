package com.Universities.web.DaoImpl;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Mapper.CourseRowMapper;
import com.Universities.web.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lei Florin on 01.10.2015.
 */
public class CourseDAOImpl extends JdbcDaoSupport implements CourseDAO {

    @Autowired
    public CourseDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * Method to insert a new entry in "courses" table.
     * @param course Course object which will be inserted.
     */
    public void insert(Course course) {
        String SQL = "INSERT INTO courses(idfaculty, name, professorName) VALUE (?, ?, ?)";
        Object[] object = new Object[] {course.getIdfaculty(), course.getName(), course.getProfessorName()};

        getJdbcTemplate().update(SQL, object);
    }

    /**
     * Method to update an entry from "courses" table based on "idcourse" param.
     * @param course Course object which will be updated.
     * @param idcourse id of Course object.
     */
    public void update(Course course, int idcourse) {
        String SQL = "UPDATE courses set name=?, professorName=? WHERE idcourse=?";
        Object[] object = new Object[] {course.getName(), course.getProfessorName(), idcourse};

        getJdbcTemplate().update(SQL, object);
    }

    /**
     * Method to delete an entry from "courses" table based on "idcourse" param.
     * @param idcourse id of Course object which will be deleted.
     */
    public void delete(int idcourse) {
        String SQL = "DELETE FROM courses WHERE idcourse=?";
        getJdbcTemplate().update(SQL, new Object[]{idcourse});
    }

    /**
     * Method to find a entry from "courses" table based on "idcourse" param.
     * @param idcourse id of Course object which will be searched.
     * @return Course object.
     */
    public Course findByCourseId(int idcourse) {

        String SQL = "SELECT c.*, f.idfaculty, f.name AS facultyName FROM courses c " +
                "INNER JOIN faculties f ON c.idfaculty=f.idfaculty WHERE c.idcourse = ?";

        Course course = (Course) getJdbcTemplate().queryForObject(SQL, new Object[]{idcourse}, new CourseRowMapper());

        return course;
    }

    /**
     * Method to find all entries from "courses" table which belongs to certain entry from "faculties" table.
     * @param idfaculty id of faculty.
     * @return List<Course> list objects.
     */
    public List<Course> findAllCoursesBelongsToFaculty(int idfaculty) {
        String SQL = "SELECT * FROM courses WHERE idfaculty=?";
        List<Course> courseList = new ArrayList<Course>();
        List<Map<String, Object>> rowResult = getJdbcTemplate().queryForList(SQL, idfaculty);
        for (Map<String, Object> row : rowResult) {
            Course course = new Course();
            course.setIdcourse((Long) row.get("idcourse"));
            course.setIdfaculty((Long) row.get("idfaculty"));
            course.setName((String) row.get("name"));
            course.setProfessorName((String) row.get("professorName"));
            courseList.add(course);
        }
        return courseList;
    }

    /**
     * Method to find all entries from "courses" table.
     * @return List<Course> list objects.
     */
    public List<Course> getallCourses() {
        String SQL = "SELECT c.idcourse, c.name, c.professorName, f.idfaculty, " +
                     "f.name AS facultyName FROM courses c INNER JOIN faculties f " +
                     "ON c.idfaculty=f.idfaculty ORDER BY c.name;";

        List<Course> courseList = getJdbcTemplate().query(SQL, new CourseRowMapper());

        return courseList;
    }
}
