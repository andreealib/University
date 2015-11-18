package com.Universities.web.Controller;

import com.Universities.web.Validator.CourseValidator;
import com.Universities.web.Validator.ProfessorValidator;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.facade.ProfessorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Controller
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
    public String submitProfessorForm(@ModelAttribute("professor") ProfessorDTO professor, BindingResult result, SessionStatus sessionStatus) {
        professorValidator.validate(professor, result);

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("professorForm");
            modelAndView.addObject("professor", professor);
            return modelAndView.getViewName();
        }

        professorfacade.addProfessor(professor);
        return "redirect:professors";


    }

    @RequestMapping(value = "/professors/edit/{idProfessor:.+}", method = RequestMethod.GET)
    public ModelAndView setupProfessorEdit(@PathVariable("idProfessor") Integer idProfessor) {
        ModelAndView modelAndView = new ModelAndView("professorEdit");
        ProfessorDTO professor = professorfacade.viewProfessor(idProfessor);
        modelAndView.addObject("professor", professor);
        return modelAndView;
    }

    @RequestMapping(value = "/professors/edit/{idProfessor:.+}", method = RequestMethod.POST)
    public String submitProfessorEdit(@ModelAttribute("professor") ProfessorDTO professor) {
        professorfacade.updateProfessor(professor);

        return "redirect:/professors";


    }
}
