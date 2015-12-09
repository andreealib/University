package com.Universities.web.Controller.admin;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.facade.ProfessorFacade;
import com.Universities.web.services.ProfessorService;
import com.Universities.web.services.UserService;
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
public class ProfessorsController {

    @Autowired
    public ProfessorFacade professorFacade;

    @Autowired
    UserService userService;



    @RequestMapping(value = "/professors/page={page}", method = RequestMethod.GET)
    public String getAllProfessors(@PathVariable("page") String page, Model model) {


        Integer pageNumber = Integer.parseInt(page);
        List<ProfessorDTO> profList = professorFacade.getLstProfessorsPerPage(pageNumber);
        model.addAttribute("numberOfPages", professorFacade.getNoOfPages());
        model.addAttribute("professors", profList);
        model.addAttribute("username",userService.getLoggedUser());
        return "admin/professors";
    }

    @RequestMapping(value = "/professors/{idProfessor:.+}", method = RequestMethod.GET)
    public String viewProfessor(Model model, @PathVariable("idProfessor") Integer idProfessor) {
        ProfessorDTO professor = professorFacade.viewProfessor(idProfessor);
        model.addAttribute("professor", professor);
        model.addAttribute("teachingCourses", professorFacade.listCoursesForProfessor(idProfessor));
        model.addAttribute("username",userService.getLoggedUser());
        return "admin/professorView";

    }

}
