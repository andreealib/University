package com.Universities.web.services;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.converter.CourseConverter;
import com.Universities.web.converter.IntegerToCourse;
import com.Universities.web.converter.ProfessorConverter;
import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class ProfessorService {

    @Autowired
    public ProfessorDAO professorDAO;

    @Autowired
    public CourseDAO courseDAO;

    @Autowired
    public ProfessorConverter professorConverter;

    @Autowired
    public CourseConverter courseConverter;

    @Autowired
    IntegerToCourse integerToCourse;




    public ProfessorDTO getProfessorById(Integer idProfessor) {

        Professor professor = professorDAO.getProfessorById(idProfessor);
        ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(professorDAO.getProfessorById(idProfessor));
        return professorDTO;

    }

    public List<ProfessorDTO> getLstProfessors() {

        List<Professor> lstProfessors = professorDAO.getLstProfessors();

        List<ProfessorDTO> professorDTOs = new ArrayList<ProfessorDTO>();

        for (Professor p : lstProfessors) {
            ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(p);
            professorDTOs.add(professorDTO);
        }

        return professorDTOs;


    }

    public boolean addProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorConverter.convertProfessorDTOToProfessor(professorDTO);
       return  professorDAO.addProfessor(professor);
    }

    public void updateProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorConverter.convertProfessorDTOToProfessor(professorDTO);
        professorDAO.updateProfessor(professor);
    }

    public String deleteProfessor(Integer idProfessor) {

        if (professorDAO.deleteProfessor(idProfessor) == true) {
            return "The professor has been deleted.";
        } else {
            return "There was a problem in deleting the professor.";
        }

    }

    public List<CourseDTO> listCoursesForProfessor(Integer idProfessor) {
        List<Course> courses = professorDAO.listCoursesForProfessor(idProfessor);
        List<CourseDTO> teachingCourses = new ArrayList<CourseDTO>();

        for (Course c : courses) {
            teachingCourses.add(courseConverter.convertCourseToDTO(c));
        }

        return teachingCourses;
    }





//        Iterator<CourseDTO> iterator=teachingCourses.iterator();
//        while(iterator.hasNext()){
//
//            if(iterator.next().getIdCourse()==idCourse){
//                teachingCourses.remove(iterator.next());
//            }
//        }

//        ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(professorDAO.getProfessorById(idProfessor));
//
//
//        List<Course> courses = new ArrayList<Course>();
//
//        for (CourseDTO cdto : teachingCourses) {
//            courses.add(courseConverter.convertCourseDTOToCourse(cdto));
//        }
//
//        Course deletedCourse = courseDAO.getCourseById(idCourse);
//        courses.remove(deletedCourse);
//
//
//        Professor professor = professorDAO.getProfessorById(idProfessor);
//        professor.setCourses(courses);
//
//        professorDAO.updateProfessor(professor);

//       Professor professor=professorDAO.getProfessorById(idProfessor);
//        ProfessorDTO professorDTO=professorConverter.convertProfessorToProfessorDTO(professor);
//        Set<Integer> coursesDTO=professorDTO.getCoursesIds();
//        coursesDTO.remove(idCourse);
//        professorDTO.setCoursesIds(coursesDTO);
//
//
//
//        Course course=integerToCourse.convert(idCourse);
//        CourseDTO courseDTO=courseConverter.convertCourseToDTO(course);
//        Set<Integer> professorsDTO=courseDTO.getProfessorsIds();
//        professorsDTO.remove(idProfessor);
//        courseDTO.setProfessorsIds(professorsDTO);
//
//        Professor professorToUpdate=professorConverter.convertProfessorDTOToProfessor(professorDTO);
//        professorToUpdate.getCourses().remove(course);
//
//        Course courseToUpdate=courseConverter.convertCourseDTOToCourse(courseDTO);
//        courseToUpdate.getProfessors().remove(professor);
//
//
//
//        professorDAO.deleteCourseForProfessor(professorToUpdate);
//        courseDAO.deleteProfessorForCourse(courseToUpdate);*/



}
