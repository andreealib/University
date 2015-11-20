package com.Universities.web.Controller;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Lei Florin on 01.10.2015.
 */

@Controller
public class CoursesController {

    @Autowired
    CourseFacade courseFacade;


    /**
     * Viewmodel for all entry from "courses" table
     *
     * @param model
     * @return courses.jsp
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String getAllCourses(Model model) {

        List<CourseDTO> courseList = courseFacade.getLstcourses();
        model.addAttribute("courses", courseList);

        return "courses";
    }

    @RequestMapping(value = "/courses/{idCourse:.+}", method = RequestMethod.GET)
    public ModelAndView viewCourse(ModelAndView model, @PathVariable("idCourse") Integer idCourse) {

        CourseDTO course = courseFacade.viewCourse(idCourse);
        model.addObject("course", course);
        model.addObject("registeredStudents", courseFacade.listStudentsForCourse(idCourse));
        model.addObject("registeredProfessors", courseFacade.listProfessorsForCourse(idCourse));
        model.setViewName("courseView");
        return model;

    }

}
