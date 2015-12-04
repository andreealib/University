package com.Universities.web.Controller;

import com.Universities.web.dto.EmailDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.services.EmailService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by andreealibotean on 12/3/2015.
 */
@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String setupEmailForm(Model model) {
        EmailDTO emailDTO = new EmailDTO();
        model.addAttribute("email", emailDTO);
        return "/email";

    }

    //redirectAttributes used to display error/success mesages after submiting (POST) a form on the returned page
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String submitEmailForm(@Valid @ModelAttribute("email") EmailDTO emailDTO, BindingResult result, SessionStatus sessionStatus, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("email");
        if (result.hasErrors()) {

            modelAndView.addObject("email", emailDTO);

            return modelAndView.getViewName();

        }

        try {

            emailService.sendMail("andreea.libotean31@gmail.com", emailDTO.getEmail(), emailDTO.getSubject(), emailDTO.getText());
            redirectAttributes.addFlashAttribute("msg","The email was sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();

            ModelAndView modelAndView1 = new ModelAndView("email");
            modelAndView.addObject("email", new EmailDTO());
            redirectAttributes.addFlashAttribute("msg","An error occured.Please try again.");
            return modelAndView1.getViewName();

        }

        return "redirect:/email";
    }


}
