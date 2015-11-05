package com.Universities.web.Controller;

import java.util.List;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.FacultyDAO;
import com.Universities.web.Model.Course;
import com.Universities.web.Model.Faculty;
import com.Universities.web.Validator.FacultyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lei Florin on 21.09.2015.
 */

@Controller
public class FacultyController {
    private FacultyDAO facultyDAO;
    private FacultyValidator facultyValidator;
    private CourseDAO courseDAO;

    @Autowired
    public FacultyController(FacultyDAO facultyDAO, FacultyValidator facultyValidator, CourseDAO courseDAO) {
        this.facultyDAO = facultyDAO;
        this.facultyValidator = facultyValidator;
        this.courseDAO = courseDAO;
    }

    /**
     * Viewmodel for all entry from "faculties" table.
     * @param model
     * @return faculties.jsp
     */
    @RequestMapping(value = { "/faculties" }, method = RequestMethod.GET)
    public String getAllFaculties(Model model) {
        List<Faculty> faculties = facultyDAO.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "faculties";
    }

    /**
     * Viewmodel for each entry of "faculties" table in detail;
     * @param idfaculy the id of faculty which will be displayed in detail.
     * @return facultyView.jsp
     */
    @RequestMapping(value = "/faculties/{idfaculty:.+}", method = RequestMethod.GET)
    public ModelAndView facultyView(@PathVariable("idfaculty") int idfaculy) {

        List<Course> courseList = courseDAO.findAllCoursesBelongsToFaculty(idfaculy);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("facultyView");
        Faculty faculty = facultyDAO.findByFacultyId(idfaculy);
        modelAndView.addObject("faculty", faculty);
        modelAndView.addObject(courseList);

        return modelAndView;

    }

    /**
     * Viewmodel to edit an entry from "faculties" table based on idfaculty param.
     * @param idfaculty the id of faculty which will be edited.
     * @return editFacultyView
     */
    @RequestMapping(value = "/faculties/edit/{idfaculty:.+}", method = RequestMethod.GET)
    public ModelAndView setupFacultyEdit(@PathVariable("idfaculty") int idfaculty) {

        ModelAndView editFacultyView = new ModelAndView();
        editFacultyView.setViewName("facultyEdit");
        Faculty faculty = facultyDAO.findByFacultyId(idfaculty);
        editFacultyView.addObject("faculty", faculty);

        return editFacultyView;
    }

    /**
     * Method which updates an entry from "faculties" table based based on "idfaculty" param.
     * @param faculty
     * @param facultyNo
     * @return "redirect:/universities/faculties" - faculties list page.
     */
    @RequestMapping(value = "/faculties/edit/{idfaculty:.+}", method = RequestMethod.POST)
    public String submitFacultyEdit( @ModelAttribute("faculty") Faculty faculty, @PathVariable("idfaculty") int facultyNo) {

        facultyDAO.update(faculty, facultyNo);
        return "redirect:/universities/faculties";
    }

    /**
     * Method which deletes an entry from "faculties" table based on "idfacylty" param.
     * @param idfaculty
     * @return
     */
    @RequestMapping(value = "/faculties/delete/{idfaculty:.+}", method = RequestMethod.GET)
    public String submitFacultyDelete( @PathVariable("idfaculty") int idfaculty) {

        facultyDAO.delete(idfaculty);
        return "redirect:/universities/faculties";

    }

    /**
     * Viewmodel to set up the form to insert a new entry in "faculties" table.
     * @param model
     * @return facultyForm.jsp
     */
    @RequestMapping(value = "/facultyForm", method = RequestMethod.GET)
    public String setupFacultyForm(Model model) {
        Faculty faculty = new Faculty();
        model.addAttribute("faculty", faculty);
        return "facultyForm";
    }

    /**
     * Viewmodel which  insert a new entry in "faculties" table,
     * and also check the fields for empty field or whitespace.
     * @param faculty
     * @param result
     * @param status
     * @return "redirect:faculties" - faculties list page
     */
    @RequestMapping(value = "/facultyForm", method = RequestMethod.POST)
    public String submitFacultyForm(@ModelAttribute("faculty")Faculty faculty, BindingResult result, SessionStatus status) {
        facultyValidator.validate(faculty, result);

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("facultyForm");
            modelAndView.addObject("faculty", faculty);
            return modelAndView.getViewName();
        }
        facultyDAO.insert(faculty);
        return "redirect:faculties";
    }



    @RequestMapping(value = "/faculties/search", method = RequestMethod.GET)
    public String searchFaculty(@RequestParam("searchString") String pSearchTerm, Model model) {

        List<Faculty> faculty = facultyDAO.findByFacultyName(pSearchTerm);
        model.addAttribute("faculties", faculty);

        return "listFaculties";

    }
}
