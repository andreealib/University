package com.Universities.web.Controller;

import com.Universities.web.Validator.ProfessorValidator;
import com.Universities.web.Validator.StudentValidator;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.ProfessorFacade;
import com.Universities.web.facade.StudentFacade;
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

import javax.validation.Valid;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Controller
public class AddOrUpdateStudentController {


    @Autowired
    StudentFacade studentfacade;

    @Autowired
    StudentValidator studentValidator;

    @RequestMapping(value = "/studentForm", method = RequestMethod.GET)
    public String setupStudentForm(Model model) {
        StudentDTO student = new StudentDTO();
        model.addAttribute("student", student);
        return "studentForm";

    }

    @RequestMapping(value = "/studentForm", method = RequestMethod.POST)
    public String submitStudentForm(@Valid @ModelAttribute("student") StudentDTO student, BindingResult result, SessionStatus sessionStatus) {
        //studentValidator.validate(student, result);

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("studentForm");
            modelAndView.addObject("student", student);
            return modelAndView.getViewName();
        }

        studentfacade.addStudent(student);
        return "redirect:students";


    }

    @RequestMapping(value = "/students/edit/{idStudent:.+}", method = RequestMethod.GET)
    public ModelAndView setupStudentEdit(@PathVariable("idStudent") Integer idStudent) {
        ModelAndView modelAndView = new ModelAndView("studentEdit");
        StudentDTO student = studentfacade.viewStudent(idStudent);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/students/edit/{idStudent:.+}", method = RequestMethod.POST)
    public String submitStudentEdit(@Valid @ModelAttribute("student") StudentDTO student,BindingResult result) {

        if(result.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("studentEdit");
            StudentDTO studentd = studentfacade.viewStudent(student.getIdStudent());
            modelAndView.addObject("student", studentd);
            return modelAndView.getViewName();
        }

        studentfacade.updateStudent(student);

        return "redirect:/students";


    }

}
