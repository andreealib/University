package com.Universities.web.facade;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class CourseFacade {

    @Autowired
    CourseService courseService;


    public List<CourseDTO> getLstcourses() {

        return courseService.getLstCourses();
    }

    public void addCourse(CourseDTO courseDTO) {

        courseService.addCourse(courseDTO);
    }

    public CourseDTO viewCourse(Integer idCourse) {


        return courseService.getCourseById(idCourse);
    }

    public void updateCourse(CourseDTO courseDTO) {

        courseService.updateCourse(courseDTO);
    }

    public String deleteCourse(Integer idCourse) {

        return courseService.deleteCourse(idCourse);
    }

    public List<StudentDTO> listStudentsForCourse(Integer idCourse) {

        return courseService.listStudentsForCourse(idCourse);
    }

    public List<ProfessorDTO> listProfessorsForCourse(Integer idCourse) {

        return courseService.listProfessorsForCourse(idCourse);
    }

    public void addStudentsForCourse(CourseDTO courseDTO) {
        courseService.addStudentsForCourse(courseDTO);
    }

    public void addProfessorsForCourse(CourseDTO courseDTO) {
        courseService.addProfessorsForCourse(courseDTO);
    }

    public void deleteStudentFromCourse(Integer idCourse, Integer idStudent) {
        courseService.deleteStudentFromCourse(idCourse, idStudent);
    }

    public void deleteProfessorFromCourse(Integer idCourse, Integer idProfessor) {
        courseService.deleteProfessorFromCourse(idCourse, idProfessor);
    }

}
