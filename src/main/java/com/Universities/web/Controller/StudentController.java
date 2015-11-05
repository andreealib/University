package com.Universities.web.Controller;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.FacultyDAO;
import com.Universities.web.Dao.StudentDAO;
import com.Universities.web.Dao.StudentsAtCourseDAO;
import com.Universities.web.Model.Course;
import com.Universities.web.Model.Faculty;
import com.Universities.web.Model.Student;
import com.Universities.web.Model.StudentsAtCourse;
import com.Universities.web.Validator.StudentValidator;
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
 * Created by Lei Florin on 28.09.2015.
 */

@Controller
public class StudentController {
    private StudentDAO studentDAO;
    private StudentValidator studentValidator;
    private FacultyDAO facultyDAO;
    private StudentsAtCourseDAO studentsAtCourseDAO;
    private CourseDAO courseDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO, StudentValidator studentValidator,
                             FacultyDAO facultyDAO, StudentsAtCourseDAO studentsAtCourseDAO,
                             CourseDAO courseDAO) {
        this.studentDAO = studentDAO;
        this.studentValidator = studentValidator;
        this.facultyDAO = facultyDAO;
        this.studentsAtCourseDAO = studentsAtCourseDAO;
        this.courseDAO = courseDAO;
    }

    /**
     * Viewmodel for all entry from "students" table
     * @param model
     * @return students.jsp
     */
    @RequestMapping(value = { "/students" }, method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        List<Student> students = studentDAO.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    /**
     * Viewmodel for each entry of "students" table in detail;
     * @param idstudent the id of student which will be displayed in detail.
     * @return studentView.jsp
     */
    @RequestMapping(value = "/students/{idstudent:.+}", method = RequestMethod.GET)
    public ModelAndView studentView(@PathVariable("idstudent") int idstudent) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentView");

        Student student = studentDAO.findbyStudentId(idstudent);
        modelAndView.addObject("student", student);

        List<StudentsAtCourse> coursesOfOneStudent = studentsAtCourseDAO.findAllCoursesOfOneStudent(idstudent);
        List<Course> courseList = new ArrayList<Course>();

        for (StudentsAtCourse studentsAtCourse : coursesOfOneStudent) {
            Course course = courseDAO.findByCourseId((int) studentsAtCourse.getIdcourse());
            courseList.add(course);
        }
        modelAndView.addObject(courseList);

        return modelAndView;

    }

    /**
     * Viewmodel to edit an entry from "students" table based on "idstudent" param.
     * @param idstudent the id of student which will be edited.
     * @return
     */
    @RequestMapping(value = "/students/edit/{idsutdent:.+}", method = RequestMethod.GET)
    public ModelAndView setupStudentEdit(@PathVariable("idsutdent") int idstudent) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentEdit");
        Student student = studentDAO.findbyStudentId(idstudent);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    /**
     * Method which updates an entry from "students" table based based on "idstudent" param.
     * @param student
     * @param studentNo
     * @return "redirect:/universities/students" - students list page.
     */
    @RequestMapping(value = "/students/edit/{idsutdent:.+}", method = RequestMethod.POST)
    public String submitStudentEdit( @ModelAttribute("student") Student student, @PathVariable("idsutdent") int studentNo) {

        studentDAO.update(student, studentNo);
        return "redirect:/universities/students";
    }

    /**
     *  Method which deletes an entry from "students" table based on "idstudent" param.
     * @param idsutdent
     * @return "redirect:/universities/students" - students list page.
     */
    @RequestMapping(value = "/students/delete/{idsutdent:.+}", method = RequestMethod.GET)
    public String submitStudentDelete( @PathVariable("idsutdent") int idsutdent) {

        studentDAO.delete(idsutdent);
        return "redirect:/universities/students";

    }

    /**
     * Viewmodel to set up the form to insert a new entry in "students" table.
     * @param model
     * @return studentForm.jsp
     */
    @RequestMapping(value = "/studentForm", method = RequestMethod.GET)
    public String setupStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        dropDownFaculties(model);    //   <---------   !!!!!!!!!!!!!!!
        return "studentForm";
    }

    /**
     * Viewmodel which  insert a new entry in "students" table,
     * and also check the fields for empty field or whitespace.
     * @param student
     * @param result
     * @param status
     * @return
     */
    @RequestMapping(value = "/studentForm", method = RequestMethod.POST)
    public String submitStudentForm(@ModelAttribute("student")Student student, BindingResult result, SessionStatus status) {
        studentValidator.validate(student, result);

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("studentForm");
            modelAndView.addObject("student", student);
            return modelAndView.getViewName();
        }
        studentDAO.insert(student);
        return "redirect:students";
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
