package com.Universities.web.services;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.converter.CourseConverter;
import com.Universities.web.converter.ProfessorConverter;
import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void addProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorConverter.convertProfessorDTOToProfessor(professorDTO);
        professorDAO.addProfessor(professor);
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

}
