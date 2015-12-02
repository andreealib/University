package com.Universities.web.Controller;

import com.Universities.web.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class DeleteCourseController {

    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "/courses/delete/{idCourse:.+}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("idCourse") Integer idCourse) {

        courseFacade.deleteCourse(idCourse);

        return "redirect:/admin/courses/page=1";
    }
}
