package com.Universities.web.Controller;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.FacultyDAO;
import com.Universities.web.Dao.StudentDAO;
import com.Universities.web.Model.Course;
import com.Universities.web.Model.Faculty;
import com.Universities.web.Model.Student;
import com.Universities.web.Model.StudentsAtCourse;
import com.Universities.web.Dao.StudentsAtCourseDAO;
import com.Universities.web.Validator.CourseValidator;
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
import java.util.List;

/**
 * Created by Lei Florin on 01.10.2015.
 */

@Controller
public class CourseController {
    private CourseDAO courseDAO;
    private CourseValidator courseValidator;
    private FacultyDAO facultyDAO;
    private StudentsAtCourseDAO studentsAtCourseDAO;
    private StudentDAO studentDAO;

    @Autowired
    public CourseController(CourseDAO courseDAO, CourseValidator courseValidator,
                            FacultyDAO facultyDAO, StudentsAtCourseDAO studentsAtCourseDAO,
                            StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.courseValidator = courseValidator;
        this.facultyDAO = facultyDAO;
        this.studentsAtCourseDAO = studentsAtCourseDAO;
        this.studentDAO = studentDAO;
    }

    /**
     * Viewmodel for all entry from "courses" table
     * @param model
     * @return courses.jsp
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String getAllCourses(Model model) {

        List<Course> courseList = courseDAO.getallCourses();
        model.addAttribute("courses", courseList);
        return "courses";
    }

    /**
     * Viewmodel for each entry of "courses" table in detail;
     * @param model
     * @param idcourse the id of course which will be displayed in detail.
     * @return courseView.jsp
     */
    @RequestMapping(value = "/courses/{idcourse:.+}", method = RequestMethod.GET)
    public String courseView(Model model, @PathVariable("idcourse") int idcourse) {

        Course course = courseDAO.findByCourseId(idcourse);

        List<StudentsAtCourse> studentsAtCourses = studentsAtCourseDAO.findAllStudentsFromCourse(idcourse);
        List<Student> studentList = new ArrayList<Student>();

        for(StudentsAtCourse studentsAtCourse : studentsAtCourses) {
            Student student = studentDAO.findbyStudentId((int) studentsAtCourse.getIdstudent());
            studentList.add(student);
        }

        Faculty faculty = facultyDAO.findByFacultyId((int) course.getIdfaculty());
        model.addAttribute("courseView");
        model.addAttribute(course);
        model.addAttribute(faculty);
        model.addAttribute(studentList);

        return "courseView";
    }

    /**
     * Viewmodel to edit an entry from "courses" table based on "idcourse" param.
     * @param idcourse the id of course which will be edited.
     * @return editCoursesView
     */
    @RequestMapping(value = "/courses/edit/{idcourse:.+}", method = RequestMethod.GET)
    public ModelAndView setupCourseEdit(@PathVariable("idcourse") int idcourse) {

        ModelAndView editCoursesView = new ModelAndView();
        editCoursesView.setViewName("courseEdit");
        Course course = courseDAO.findByCourseId(idcourse);
        Faculty faculty = facultyDAO.findByFacultyId((int) course.getIdfaculty());
        editCoursesView.addObject(faculty);
        editCoursesView.addObject("course", course);

        return editCoursesView;
    }

    /**
     * Method which updates an entry from "courses" table based based on "idcourse" param.
     * @param course
     * @param courseNo
     * @return "redirect:/universities/courses" - courses list page.
     */
    @RequestMapping(value = "/courses/edit/{idcourse:.+}", method = RequestMethod.POST)
    public String submitCourseEdit( @ModelAttribute("course") Course course, @PathVariable("idcourse") int courseNo) {

        courseDAO.update(course, courseNo);
        return "redirect:/universities/courses";
    }

    /**
     * Method which deletes an entry from "courses" table based on "idcourse" param.
     * @param idcourse
     * @return "redirect:/universities/courses" - courses list page.
     */
    @RequestMapping(value = "/courses/delete/{idcourse:.+}", method = RequestMethod.GET)
    public String submitCourseDelete( @PathVariable("idcourse") int idcourse) {

        courseDAO.delete(idcourse);
        return "redirect:/universities/courses";

    }

    /**
     * Viewmodel to set up the form to insert a new entry in "courses" table.
     * @param model
     * @return courseForm.jsp
     */
    @RequestMapping(value = "/courseForm", method = RequestMethod.GET)
    public String setupCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        dropDownFaculties(model);
        return "courseForm";
    }

    /**
     * Viewmodel which  insert a new entry in "courses" table,
     * and also check the fields for empty field or whitespace.
     * @param course
     * @param result
     * @param status
     * @return "redirect:courses" - courses list page
     */
    @RequestMapping(value = "/courseForm", method = RequestMethod.POST)
    public String submitStudentForm(@ModelAttribute("course")Course course, BindingResult result, SessionStatus status) {
        courseValidator.validate(course, result);
        List<Faculty> facultyList = facultyDAO.getAllFaculties();

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("courseForm");
            modelAndView.addObject("course", course);
            modelAndView.addObject("faculties", facultyList);
            return modelAndView.getViewName();
        }

        courseDAO.insert(course);
        return "redirect:courses";
    }

    /**
     * Method which maps all the faculties.
     * Used this method to make the drop-down list
     * @param model
     */
    private void dropDownFaculties(Model model) {
        List<Faculty> facultyList = facultyDAO.getAllFaculties();
        model.addAttribute("faculties", facultyList);
    }
}
