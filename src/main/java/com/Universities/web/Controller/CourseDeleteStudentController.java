package com.Universities.web.Controller;

import com.Universities.web.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andreealibotean on 11/20/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class CourseDeleteStudentController {

    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "/courses/{idCourse:.+}/deleteStud/{idStudent:.+}", method = RequestMethod.GET)
    public String deleteStudentFromCourse(@PathVariable("idCourse") Integer idCourse, @PathVariable("idStudent") Integer idStudent) {

        courseFacade.deleteStudentFromCourse(idCourse, idStudent);

        return "redirect:/admin/courses/" + idCourse;
    }
}

