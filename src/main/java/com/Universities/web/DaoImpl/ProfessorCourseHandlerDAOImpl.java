package com.Universities.web.DaoImpl;

import com.Universities.web.Dao.ProfessorCourseHandlerDAO;
import com.Universities.web.Model.ProfessorCourseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public class ProfessorCourseHandlerDAOImpl extends JdbcDaoSupport implements ProfessorCourseHandlerDAO {

    @Autowired
    public ProfessorCourseHandlerDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<ProfessorCourseHandler> findAllCoursesForProfessor(int idprofessor) {
        String SQL = "select pch.idprofessor,pch.idfaculty,pch.idcourse from professor_course_handler pch,professors where professors.idprofessor=pch.idprofessor and professors.idprofessor=?";

        List<ProfessorCourseHandler> professorList = new ArrayList<ProfessorCourseHandler>();
        List<Map<String, Object>> rowResult = getJdbcTemplate().queryForList(SQL, idprofessor);
        for (Map<String, Object> row : rowResult) {
            ProfessorCourseHandler professorCourseHandler = new ProfessorCourseHandler();
            professorCourseHandler.setIdfaculty((Long) row.get("idfaculty"));
            professorCourseHandler.setIdprofessor((Long) row.get("idprofessor"));
            professorCourseHandler.setIdcourse((Long) row.get("idcourse"));
            professorList.add(professorCourseHandler);

        }

        return professorList;
    }

    public List<ProfessorCourseHandler> findAllProfessorsForCourse(int idcourse) {
        String SQL = "select pch.idprofessor,pch.idfaculty,pch.idcourse from professor_course_handler pch,courses where courses.idcourse=pch.idcourse and courses.idcourse=?";

        List<ProfessorCourseHandler> courseList = new ArrayList<ProfessorCourseHandler>();
        List<Map<String, Object>> rowResult = getJdbcTemplate().queryForList(SQL, idcourse);
        for (Map<String, Object> row : rowResult) {
            ProfessorCourseHandler professorCourseHandler = new ProfessorCourseHandler();
            professorCourseHandler.setIdfaculty((Long) row.get("idfaculty"));
            professorCourseHandler.setIdprofessor((Long) row.get("idprofessor"));
            professorCourseHandler.setIdcourse((Long) row.get("idcourse"));
            courseList.add(professorCourseHandler);

        }

        return courseList;

    }
}
