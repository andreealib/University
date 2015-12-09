package com.Universities.web.Controller.moderator;

import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.StudentFacade;
import com.Universities.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by andreealibotean on 12/3/2015.
 */
@Controller
public class ModerStudentsController {
    @Autowired
    public StudentFacade studentFacade;

    @Autowired
    UserService userService;



    @RequestMapping(value = "/students/page={page}", method = RequestMethod.GET)
    public String getAllStudents(@PathVariable("page") String page, Model model) {

        Integer pageNumber = Integer.parseInt(page);
        List<StudentDTO> studList = studentFacade.getLstStudentsPerPage(pageNumber);
        model.addAttribute("numberOfPages", studentFacade.getNoOfPages());
        model.addAttribute("students", studList);
        model.addAttribute("username", userService.getLoggedUser());
        return "moder/students";
    }

    @RequestMapping(value = "/students/{idStudent:.+}", method = RequestMethod.GET)
    public String viewStudent(Model model, @PathVariable("idStudent") Integer idStudent) {
        StudentDTO student = studentFacade.viewStudent(idStudent);
        model.addAttribute("student", student);
        model.addAttribute("attendedCourses", studentFacade.listCoursesForStudent(idStudent));
        model.addAttribute("username", userService.getLoggedUser());
        return "moder/studentView";

    }
}
