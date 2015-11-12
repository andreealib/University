package com.Universities.web.Controller;

import com.Universities.web.Dao.*;
import com.Universities.web.Model.Course;
import com.Universities.web.Model.Professor;
import com.Universities.web.Model.ProfessorCourseHandler;
import com.Universities.web.Validator.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by andreealibotean on 11/10/2015.
 */
@Controller
public class ProfessorCourseHandlerController {
    private ProfessorDAO professorDAO;
    private CourseDAO courseDAO;
    private FacultyDAO facultyDAO;
    private ProfessorCourseHandlerDAO professorCourseHandlerDAO;
    //private List<CourseDAO> selectedCourses=null;

    @Autowired
    public ProfessorCourseHandlerController(ProfessorDAO professorDAO, CourseDAO courseDAO, FacultyDAO facultyDAO, ProfessorCourseHandlerDAO professorCourseHandlerDAO) {
        this.professorDAO = professorDAO;
        this.courseDAO = courseDAO;
        this.facultyDAO = facultyDAO;
        this.professorCourseHandlerDAO = professorCourseHandlerDAO;

    }

    @RequestMapping(value = "professors/addCourses/{idprofessor:.+}", method = RequestMethod.GET)
    public ModelAndView setupAddCourses(@PathVariable("idprofessor") int idprofessor) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("professorAddCourses");

        Professor professor = professorDAO.findByProfessorId(idprofessor);

        List<Course> allCourses = courseDAO.getallCourses();
        List<Course> coursesNotIncluded = new ArrayList<Course>();

        List<ProfessorCourseHandler> coursesOfProfessor = professorCourseHandlerDAO.findAllCoursesForProfessor(idprofessor);
        List<Course> courseList = new ArrayList<Course>();

        for (ProfessorCourseHandler professorCourseHandler : coursesOfProfessor) {
            Course course = courseDAO.findByCourseId((int) (professorCourseHandler.getIdcourse()));
            courseList.add(course);
        }

        allCourses.removeAll(courseList);

        modelAndView.addObject("professorCourseHandler", new ProfessorCourseHandler());
        modelAndView.addObject("professor", professor);
        modelAndView.addObject("allCourses", allCourses);

        System.out.println(coursesNotIncluded);

        modelAndView.addObject(courseList);

        return modelAndView;

    }

    @RequestMapping(value = "professors/addCourses/{idprofessor:.+}", method = RequestMethod.POST)
    public String submitAddCourses(@PathVariable("idprofessor") int idprofessor, @ModelAttribute("professorCourseHandler") ProfessorCourseHandler professorCourseHandler, BindingResult result, SessionStatus status) {
        ModelAndView modelAndView = new ModelAndView();
        Professor professor = professorDAO.findByProfessorId(idprofessor);
        professorCourseHandlerDAO.insert(professorCourseHandler);

        return "redirect:/universities/professors/" + String.valueOf(idprofessor);

    }


}
