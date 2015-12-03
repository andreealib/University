package com.Universities.web.Controller.admin;

import com.Universities.web.Validator.CourseValidator;
import com.Universities.web.Validator.ProfessorValidator;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.facade.ProfessorFacade;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class AddOrUpdateProfessorController {

    @Autowired
    ProfessorFacade professorfacade;

    @Autowired
    ProfessorValidator professorValidator;

    @RequestMapping(value = "/professorForm", method = RequestMethod.GET)
    public String setupProfessorForm(Model model) {
        ProfessorDTO professor = new ProfessorDTO();
        model.addAttribute("professor", professor);
        return "professorForm";

    }

    @RequestMapping(value = "/professorForm", method = RequestMethod.POST)
    public String submitProfessorForm(@Valid @ModelAttribute("professor") ProfessorDTO professor, BindingResult result, SessionStatus sessionStatus) {
        ModelAndView modelAndView = new ModelAndView("professorForm");

        if (result.hasErrors()) {
            modelAndView.addObject("professor", professor);
            return modelAndView.getViewName();
        }

        try {
            professorfacade.addProfessor(professor);

        } catch (ConstraintViolationException e) {
            e.printStackTrace();

            ModelAndView modelAndView1 = new ModelAndView("professorFormException");
            modelAndView.addObject("professor", new ProfessorDTO());

            return modelAndView1.getViewName();

        }

        return "redirect:/admin/professors/page=1";


    }

    @RequestMapping(value = "/professors/edit/{idProfessor:.+}", method = RequestMethod.GET)
    public ModelAndView setupProfessorEdit(@PathVariable("idProfessor") Integer idProfessor) {
        ModelAndView modelAndView = new ModelAndView("professorEdit");
        ProfessorDTO professor = professorfacade.viewProfessor(idProfessor);
        modelAndView.addObject("professor", professor);
        return modelAndView;
    }

    @RequestMapping(value = "/professors/edit/{idProfessor:.+}", method = RequestMethod.POST)
    public String submitProfessorEdit(@Valid @ModelAttribute("professor") ProfessorDTO professor, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("professorEdit");

        if (result.hasErrors()) {
            ProfessorDTO professord = professorfacade.viewProfessor(professor.getIdProfessor());
            modelAndView.addObject("professor", professord);
            return modelAndView.getViewName();
        }
        try {
            professorfacade.updateProfessor(professor);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            ModelAndView modelAndView1 = new ModelAndView("professorEditException");
            ProfessorDTO professor1 = professorfacade.viewProfessor(professor.getIdProfessor());
            modelAndView1.addObject("professor", professor1);
            return modelAndView1.getViewName();

        }


        return "redirect:/admin/professors/" + professor.getIdProfessor();


    }
}
