package com.Universities.web.Controller;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.facade.ProfessorFacade;
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
public class ProfessorsController {

    @Autowired
    public ProfessorFacade professorFacade;


    @RequestMapping(value = "/professors", method = RequestMethod.GET)
    public String getAllProfessors(Model model) {

        List<ProfessorDTO> professorList = professorFacade.getLstProfessors();
        model.addAttribute("professors", professorList);

        return "professors";
    }

    @RequestMapping(value="/professors/{idProfessor:.+}",method = RequestMethod.GET)
    public String viewProfessor(Model model, @PathVariable("idProfessor") Integer idProfessor){
        ProfessorDTO professor=professorFacade.viewProfessor(idProfessor);
        model.addAttribute("professor",professor);
        model.addAttribute("teachingCourses",professorFacade.listCoursesForProfessor(idProfessor));

        return "professorView";

    }

}
