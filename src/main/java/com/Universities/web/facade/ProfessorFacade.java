package com.Universities.web.facade;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.services.CourseService;
import com.Universities.web.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Service
public class ProfessorFacade {


    @Autowired
    ProfessorService professorService;


    public List<ProfessorDTO> getLstProfessors() {

        return professorService.getLstProfessors();
    }

    public void addProfessor(ProfessorDTO professorDTO) {

        professorService.addProfessor(professorDTO);
    }

    public ProfessorDTO viewProfessor(Integer idProfessor) {


        return professorService.getProfessorById(idProfessor);
    }

    public void updateProfessor(ProfessorDTO professorDTO) {

        professorService.updateProfessor(professorDTO);
    }

    public String deleteProfessor(Integer idProfessor) {

        return professorService.deleteProfessor(idProfessor);
    }

    public List<CourseDTO> listCoursesForProfessor(Integer idProfessor){
        return professorService.listCoursesForProfessor(idProfessor);
    }
}
