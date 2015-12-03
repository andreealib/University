package com.Universities.web.Controller.admin;

import com.Universities.web.Validator.CourseValidator;
import com.Universities.web.data.Course;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AddOrUpdateCourseController {

    @Autowired
    CourseFacade coursefacade;

    @Autowired
    CourseValidator courseValidator;

    @RequestMapping(value = "/courseForm", method = RequestMethod.GET)
    public String setupCourseForm(Model model) {
        CourseDTO course = new CourseDTO();
        model.addAttribute("course", course);
        return "admin/courseForm";

    }

    @RequestMapping(value = "/courseForm", method = RequestMethod.POST)
    public String submitCourseForm(@Valid @ModelAttribute("course") CourseDTO course, BindingResult result, SessionStatus sessionStatus) {

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("admin/courseForm");
            modelAndView.addObject("course", course);
            return modelAndView.getViewName();
        }

        coursefacade.addCourse(course);
        return "redirect:/admin/courses/page=1";


    }

    @RequestMapping(value = "/courses/edit/{idCourse:.+}", method = RequestMethod.GET)
    public ModelAndView setupCourseEdit(@PathVariable("idCourse") Integer idCourse) {
        ModelAndView modelAndView = new ModelAndView("admin/courseEdit");
        CourseDTO course = coursefacade.viewCourse(idCourse);
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping(value = "/courses/edit/{idCourse:.+}", method = RequestMethod.POST)
    public String submitCourseEdit(@Valid @ModelAttribute("course") CourseDTO courseDTO, BindingResult result) {

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("admin/courseEdit");
            CourseDTO course = coursefacade.viewCourse(courseDTO.getIdCourse());
            modelAndView.addObject("course", course);
            return modelAndView.getViewName();
        }


        coursefacade.updateCourse(courseDTO);
        return "redirect:/admin/courses/" + courseDTO.getIdCourse();


    }


}
