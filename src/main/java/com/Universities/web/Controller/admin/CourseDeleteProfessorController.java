package com.Universities.web.Controller.admin;

import com.Universities.web.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by andreealibotean on 11/20/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class CourseDeleteProfessorController {

    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "/courses/{idCourse:.+}/deleteProf/{idProfessor:.+}", method = RequestMethod.GET)
    public String deleteProfessorFromCourse(@PathVariable("idCourse") Integer idCourse, @PathVariable("idProfessor") Integer idProfessor) {

        courseFacade.deleteProfessorFromCourse(idCourse, idProfessor);

        return "redirect:/admin/courses/" + idCourse;
    }
}
