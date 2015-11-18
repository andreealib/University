//package com.Universities.web.DaoImpl;
//
//
//import com.Universities.web.Model.StudentsAtCourse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//
//import javax.sql.DataSource;
//import java.util.*;
//
///**
// * Created by Lei Florin on 02.10.2015.
// */
//public class StudentsAtCourseDAOImpl extends JdbcDaoSupport implements StudentsAtCourseDAO {
//
//    @Autowired
//    public StudentsAtCourseDAOImpl(DataSource dataSource) {
//        this.setDataSource(dataSource);
//    }
//
//    /**
//     * Method which search for all Student objects which are assigned to a certain Course object.
//     * @param idcoruse id of Course object.
//     * @return List<StudentsAtCourse> studentsAtCourses
//     */
//    public List<StudentsAtCourse>findAllStudentsFromCourse(int idcoruse) {
//        String SQL = "SELECT sc.idstudent, sc.idcourse FROM students_has_courses sc INNER JOIN " +
//                "courses c ON sc.idcourse=c.idcourse where c.idcourse=?;";
//
//        List<StudentsAtCourse> studentsAtCourses = new ArrayList<StudentsAtCourse>();
//        List<Map<String, Object>> rowResult = getJdbcTemplate().queryForList(SQL, idcoruse);
//
//        for (Map<String, Object> row : rowResult) {
//            StudentsAtCourse studentsAtCourse = new StudentsAtCourse();
//            studentsAtCourse.setIdstudent((Long) row.get("idstudent"));
//            studentsAtCourse.setIdcourse((Long) row.get("idcourse"));
//            studentsAtCourses.add(studentsAtCourse);
//        }
//        return studentsAtCourses;
//    }
//
//    /**
//     * Method which search for all Course objects which are assigned to a certain Student object.
//     * @param idStudent id of Student object.
//     * @return List<StudentsAtCourse> coursesList
//     */
//    public List<StudentsAtCourse> findAllCoursesOfOneStudent(int idStudent) {
//        String SQL = "SELECT sc.idstudent, sc.idfaculty, sc.idcourse FROM students_has_courses sc " +
//                     "INNER JOIN students s ON sc.idstudent=s.idstudent where s.idstudent=?";
//
//        List<StudentsAtCourse> coursesList = new ArrayList<StudentsAtCourse>();
//        List<Map<String, Object>> rowResult = getJdbcTemplate().queryForList(SQL, idStudent);
//
//        for(Map<String, Object> row : rowResult) {
//            StudentsAtCourse studentsAtCourse = new StudentsAtCourse();
//
//            studentsAtCourse.setIdfaculty((Long) row.get("idstudent"));
//            studentsAtCourse.setIdfaculty((Long) row.get("idfaculty"));
//            studentsAtCourse.setIdcourse((Long) row.get("idcourse"));
//
//            coursesList.add(studentsAtCourse);
//        }
//        return coursesList;
//    }
//}
