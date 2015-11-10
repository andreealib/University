package com.Universities.web.Controller;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.FacultyDAO;
import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.Dao.StudentDAO;
import com.Universities.web.Model.Professor;
import com.Universities.web.Model.ProfessorCourseHandler;
import com.Universities.web.Validator.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by andreealibotean on 11/9/2015.
 */
@Controller
public class ProfessorController {
    private ProfessorDAO professorDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private FacultyDAO facultyDAO;
    private ProfessorValidator professorValidator;
    private ProfessorCourseHandler professorCourseHandler;

    @Autowired
    public ProfessorController(ProfessorDAO professorDAO, StudentDAO studentDAO, CourseDAO courseDAO, FacultyDAO facultyDAO, ProfessorValidator professorValidator, ProfessorCourseHandler professorCourseHandler) {
        this.professorDAO = professorDAO;
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.facultyDAO = facultyDAO;
        this.professorValidator = professorValidator;
        this.professorCourseHandler = professorCourseHandler;


}

    @RequestMapping(value = {"/professors"}, method = RequestMethod.GET)
    public String getAllProfessors(Model model) {
        List<Professor> professors = professorDAO.getAllProfessors();
        model.addAttribute("professors", professors);
        return "professors";
    }

    @RequestMapping(value = "/professors/{idprofessor:.+}", method = RequestMethod.GET)
    public ModelAndView professorView(@PathVariable("idprofessor") int idprofessor) {
        return null;
    }


}
