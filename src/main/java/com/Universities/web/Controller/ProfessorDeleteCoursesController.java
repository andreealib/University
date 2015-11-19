package com.Universities.web.Controller;

import com.Universities.web.facade.CourseFacade;
import com.Universities.web.facade.ProfessorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by andreealibotean on 11/19/2015.
 */
@Controller
public class ProfessorDeleteCoursesController {

    @Autowired
    CourseFacade courseFacade;

    @Autowired
    ProfessorFacade professorFacade;

    @RequestMapping(value = "/professors/{idProfessor:.+}/delete/{idCourse:.+}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("idProfessor") Integer idProfessor, @PathVariable("idCourse") Integer idCourse) {
        //professorFacade.deleteCourseForProfessor(idProfessor, idCourse);
        return "redirect:/professors/" + idProfessor;

    }
}
