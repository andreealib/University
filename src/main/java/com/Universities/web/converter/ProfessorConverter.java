package com.Universities.web.converter;

import com.Universities.web.data.Professor;
import com.Universities.web.dto.ProfessorDTO;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class ProfessorConverter {

    public ProfessorDTO convertProfessorToProfessorDTO(Professor professor){

        ProfessorDTO professorDTO=new ProfessorDTO();

        professorDTO.setIdProfessor(professor.getIdProfessor());
        professorDTO.setName(professor.getName());
        professorDTO.setSurname(professor.getSurname());
        professorDTO.setGender(professor.getGender());
        professorDTO.setCnp(professor.getCnp());

        return professorDTO;

    }

    public Professor convertProfessorDTOToProfessor(ProfessorDTO professorDTO){

        Professor professor =new Professor();

        professor.setIdProfessor(professorDTO.getIdProfessor());
        professor.setName(professorDTO.getName());
        professor.setSurname(professorDTO.getSurname());
        professor.setGender(professorDTO.getGender());
        professor.setCnp(professorDTO.getCnp());

        return professor;

    }
}
