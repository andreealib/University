package com.Universities.web.Controller;

import com.Universities.web.facade.ProfessorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Controller
public class DeleteProfessorController {

    @Autowired
    ProfessorFacade professorFacade;

    @RequestMapping(value = "/professors/delete/{idProfessor:.+}", method = RequestMethod.GET)
    public String deleteProfessor(@PathVariable("idProfessor") Integer idProfessor) {

        professorFacade.deleteProfessor(idProfessor);
        return "redirect:/professors";
    }
}
