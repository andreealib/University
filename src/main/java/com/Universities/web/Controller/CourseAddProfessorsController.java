package com.Universities.web.Controller;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.facade.ProfessorFacade;
import com.Universities.web.facade.StudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by andreealibotean on 11/19/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class CourseAddProfessorsController {

    @Autowired
    public CourseFacade courseFacade;

    @Autowired
    public ProfessorFacade professorFacade;

    @RequestMapping(value = "/courses/{idCourse:.+}/addProfessors", method = RequestMethod.GET)
    public ModelAndView setupAddProfessors(@PathVariable("idCourse") Integer idCourse) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseAddProfessors");

        CourseDTO courseDTO = courseFacade.viewCourse(idCourse);

        List<ProfessorDTO> professors = professorFacade.getLstProfessors();
        List<ProfessorDTO> registeredProfessors = courseFacade.listProfessorsForCourse(idCourse);
        professors.removeAll(registeredProfessors);

        modelAndView.addObject("courseDTO", courseDTO);
        modelAndView.addObject("registeredProfessors", registeredProfessors);
        modelAndView.addObject("professors", professors);

        return modelAndView;
    }

    @RequestMapping(value = "/courses/{idCourse:.+}/addProfessors", method = RequestMethod.POST)
    public String submitAddProfessors(@ModelAttribute("courseDTO") CourseDTO courseDTO, @PathVariable("idCourse") Integer idCourse) {

        Integer id = idCourse;
        courseFacade.addProfessorsForCourse(courseDTO);

        return "redirect:/admin/courses/" + String.valueOf(id);
    }
}
