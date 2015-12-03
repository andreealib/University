package com.Universities.web.Controller.admin;

import com.Universities.web.data.Student;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.ProfessorFacade;
import com.Universities.web.facade.StudentFacade;
import com.Universities.web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class StudentsController {

    @Autowired
    public StudentFacade studentFacade;

    @RequestMapping(value = "/students/page={page}", method = RequestMethod.GET)
    public String getAllStudents(@PathVariable("page") String page, Model model) {

        Integer pageNumber = Integer.parseInt(page);
        List<StudentDTO> studList = studentFacade.getLstStudentsPerPage(pageNumber);
        model.addAttribute("numberOfPages", studentFacade.getNoOfPages());
        model.addAttribute("students", studList);

        return "students";
    }

    @RequestMapping(value = "/students/{idStudent:.+}", method = RequestMethod.GET)
    public String viewStudent(Model model, @PathVariable("idStudent") Integer idStudent) {
        StudentDTO student = studentFacade.viewStudent(idStudent);
        model.addAttribute("student", student);
        model.addAttribute("attendedCourses", studentFacade.listCoursesForStudent(idStudent));

        return "studentView";

    }
}
