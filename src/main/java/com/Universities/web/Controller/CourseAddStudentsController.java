package com.Universities.web.Controller;

import com.Universities.web.data.Course;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.facade.StudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CourseAddStudentsController {

    @Autowired
    public CourseFacade courseFacade;

    @Autowired
    public StudentFacade studentFacade;

    @RequestMapping(value = "/courses/{idCourse:.+}/addStudents", method = RequestMethod.GET)
    public ModelAndView setupAddStudents(@PathVariable("idCourse") Integer idCourse) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseAddStudents");

        CourseDTO courseDTO = courseFacade.viewCourse(idCourse);

        List<StudentDTO> students = studentFacade.getLstStudents();
        List<StudentDTO> registeredStudents = courseFacade.listStudentsForCourse(idCourse);
        students.removeAll(registeredStudents);

        modelAndView.addObject("courseDTO", courseDTO);
        modelAndView.addObject("registeredStudents", registeredStudents);
        modelAndView.addObject("students", students);

        return modelAndView;
    }

    @RequestMapping(value = "/courses/{idCourse:.+}/addStudents", method = RequestMethod.POST)
    public String submitAddStudents(@ModelAttribute("courseDTO") CourseDTO courseDTO, @PathVariable("idCourse") Integer idCourse) {

        Integer id = idCourse;

        courseFacade.addStudentsForCourse(courseDTO);

        return "redirect:/courses/" + String.valueOf(id);
    }

}
