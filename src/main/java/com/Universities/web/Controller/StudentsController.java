package com.Universities.web.Controller;

import com.Universities.web.data.Student;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.ProfessorFacade;
import com.Universities.web.facade.StudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StudentsController {

    @Autowired
    public StudentFacade studentFacade;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllStudents(Model model) {

        List<StudentDTO> studentList = studentFacade.getLstStudents();
        model.addAttribute("students", studentList);

        return "students";
    }

    @RequestMapping(value="/students/{idStudent:.+}",method = RequestMethod.GET)
    public String viewStudent(Model model, @PathVariable("idStudent") Integer idStudent){
        StudentDTO student=studentFacade.viewStudent(idStudent);
        model.addAttribute("student",student);
        model.addAttribute("attendedCourses",studentFacade.listCoursesForStudent(idStudent));

        return "studentView";

    }
}
