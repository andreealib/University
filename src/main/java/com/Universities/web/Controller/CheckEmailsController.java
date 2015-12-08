package com.Universities.web.Controller;

import com.Universities.web.dto.EmailDTO;
import com.Universities.web.dto.ReplyDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.facade.StudentFacade;
import com.Universities.web.services.EmailService;
import com.Universities.web.services.ReadingInboxService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Message;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by andreealibotean on 12/7/2015.
 */
@Controller
@RequestMapping(value = "/admin")
public class CheckEmailsController {

    @Autowired
    public ReadingInboxService readingInboxService;

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/emails", method = RequestMethod.GET)
    public String getAllEmails(Model model) {

        model.addAttribute("emails", readingInboxService.readInbox());
        model.addAttribute("readingInboxService", readingInboxService);
        return "checkEmails";
    }

    @RequestMapping(value = "emails/view/{no:.+}",method = RequestMethod.GET)
    public ModelAndView viewMessage(ModelAndView modelAndView,@PathVariable("no")Integer messageNumber){


        Message email = readingInboxService.getEmail(messageNumber);
        modelAndView.addObject("message", email);
        modelAndView.addObject("readingInboxService", readingInboxService);
        modelAndView.setViewName("emailView");
        return modelAndView;
    }


    @RequestMapping(value = "/emails/reply/{from:.+}", method = RequestMethod.GET)
    public String setupEmailForm(@PathVariable("from")String from, Model model) {
        EmailDTO emailDTO = new EmailDTO();
        model.addAttribute("email", emailDTO);
        model.addAttribute("from",from);
        return "email";

    }

    //redirectAttributes used to display error/success mesages after submiting (POST) a form on the returned page
    @RequestMapping(value = "/emails/reply/{from:.+}", method = RequestMethod.POST)
    public String submitEmailForm(@Valid @ModelAttribute("email") ReplyDTO emailDTO, @PathVariable("from")String from, BindingResult result, SessionStatus sessionStatus, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("email");
        if (result.hasErrors()) {

            modelAndView.addObject("email", emailDTO);

            return modelAndView.getViewName();

        }

        try {

            emailService.sendMail("testingmandarine@gmail.com",from, emailDTO.getSubject(), emailDTO.getText());
            modelAndView.addObject("from",from);
            redirectAttributes.addFlashAttribute("msg","The email was sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();

            ModelAndView modelAndView1 = new ModelAndView("email");
            modelAndView.addObject("email", new EmailDTO());
            redirectAttributes.addFlashAttribute("msg","An error occured.Please try again.");
            return modelAndView1.getViewName();

        }

        return "redirect:/admin/emails/reply/"+from;
    }
}
