package com.Universities.web.Dao;

import com.Universities.web.Model.StudentsAtCourse;

import java.util.List;

/**
 * Created by Lei Florin on 02.10.2015.
 */
public interface StudentsAtCourseDAO {

    /**
     * Method which search for all Student objects which are assigned to a certain Course object.
     * @param idcoruse id of Course object.
     * @return List<StudentsAtCourse> studentsAtCourses
     */
    List<StudentsAtCourse> findAllStudentsFromCourse(int idcoruse);

    /**
     * Method which search for all Course objects which are assigned to a certain Student object.
     * @param idStudent id of Student object.
     * @return List<StudentsAtCourse> coursesList
     */
    List<StudentsAtCourse> findAllCoursesOfOneStudent(int idStudent);

}
