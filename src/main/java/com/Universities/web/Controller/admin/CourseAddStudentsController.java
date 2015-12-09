package com.Universities.web.Controller.admin;

import com.Universities.web.data.Course;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.facade.StudentFacade;
import com.Universities.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreealibotean on 11/18/2015.
 */

@Controller
@RequestMapping(value = "/admin")
public class CourseAddStudentsController {

    @Autowired
    public CourseFacade courseFacade;

    @Autowired
    public StudentFacade studentFacade;

    @Autowired
    UserService userService;



    @RequestMapping(value = "/courses/{idCourse:.+}/addStudents", method = RequestMethod.GET)
    public ModelAndView setupAddStudents(@PathVariable("idCourse") Integer idCourse) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/courseAddStudents");

        CourseDTO courseDTO = courseFacade.viewCourse(idCourse);

        List<StudentDTO> students = studentFacade.getLstStudents();
        List<StudentDTO> registeredStudents = courseFacade.listStudentsForCourse(idCourse);
        students.removeAll(registeredStudents);

        modelAndView.addObject("courseDTO", courseDTO);
        modelAndView.addObject("registeredStudents", registeredStudents);
        modelAndView.addObject("students", students);
        modelAndView.addObject("username", userService.getLoggedUser());
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{idCourse:.+}/addStudents", method = RequestMethod.POST)
    public String submitAddStudents(@ModelAttribute("courseDTO") CourseDTO courseDTO, @PathVariable("idCourse") Integer idCourse) {

        Integer id = idCourse;

        courseFacade.addStudentsForCourse(courseDTO);

        return "redirect:/admin/courses/" + String.valueOf(id);
    }

}
