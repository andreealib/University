package com.Universities.web.Controller;

import com.Universities.web.facade.StudentFacade;
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
public class DeleteStudentController {

    @Autowired
    public StudentFacade studentFacade;

    @RequestMapping(value = "students/delete/{idStudent:.+}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("idStudent") Integer idStudent) {
        studentFacade.deleteStudent(idStudent);
        return "redirect:/admin/students/page=1";
    }
}
