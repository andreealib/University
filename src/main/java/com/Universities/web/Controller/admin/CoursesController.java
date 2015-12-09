package com.Universities.web.Controller.admin;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.services.CourseService;
import com.Universities.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
@RequestMapping(value = "/admin")
public class CoursesController {

    @Autowired
    CourseFacade courseFacade;

    @Autowired
    UserService userService;



    /**
     * Viewmodel for all entry from "courses" table
     *
     * @param model
     * @return courses.jsp
     */
    @RequestMapping(value = "/courses/page={page}", method = RequestMethod.GET)
    public String getAllCourses(@PathVariable("page") String page, Model model) {

        Integer pageNumber = Integer.parseInt(page);
        List<CourseDTO> courseList = courseFacade.getLstcoursesPerPage(pageNumber);
        model.addAttribute("username",userService.getLoggedUser());


        model.addAttribute("numberOfPages", courseFacade.getNoOfPages());
        model.addAttribute("courses", courseList);

        return "admin/courses";
    }


    @RequestMapping(value = "/courses/{idCourse:.+}", method = RequestMethod.GET)
    public ModelAndView viewCourse(ModelAndView model, @PathVariable("idCourse") Integer idCourse) {

        CourseDTO course = courseFacade.viewCourse(idCourse);
        model.addObject("course", course);
        model.addObject("registeredStudents", courseFacade.listStudentsForCourse(idCourse));
        model.addObject("registeredProfessors", courseFacade.listProfessorsForCourse(idCourse));
        model.addObject("username",userService.getLoggedUser());
        model.setViewName("admin/courseView");
        return model;

    }

}
