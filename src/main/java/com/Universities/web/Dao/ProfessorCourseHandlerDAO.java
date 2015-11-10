package com.Universities.web.Dao;

import com.Universities.web.Model.ProfessorCourseHandler;

import java.util.List;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public interface ProfessorCourseHandlerDAO {
    List<ProfessorCourseHandler> findAllCoursesForProfessor(int idprofessor);

    List<ProfessorCourseHandler> findAllProfessorsForCourse(int idcourse);

    void insert(ProfessorCourseHandler professorCourseHandler);
}
