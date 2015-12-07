package com.Universities.web.Controller;

import com.Universities.web.dto.ContactDTO;
import com.Universities.web.dto.EmailDTO;
import com.Universities.web.services.ContactService;
import com.Universities.web.services.EmailService;
import com.Universities.web.services.ReadingInboxService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by andreealibotean on 12/7/2015.
 */
@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    @Autowired
    ReadingInboxService readingInboxService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String setupEmailForm(Model model) {
        ContactDTO contactDTO = new ContactDTO();
        model.addAttribute("email", contactDTO);
        return "/contact";

    }

    //redirectAttributes used to display error/success mesages after submiting (POST) a form on the returned page
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String submitEmailForm(@Valid @ModelAttribute("email") ContactDTO contactDTO, BindingResult result, SessionStatus sessionStatus, final RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("contact");
        if (result.hasErrors()) {

            modelAndView.addObject("contact", contactDTO);

            return modelAndView.getViewName();

        }

        try {

            contactService.sendContactEmail(contactDTO.getFrom(),contactDTO.getSubject(),contactDTO.getMessage());
            redirectAttributes.addFlashAttribute("msg","The email was sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();

            ModelAndView modelAndView1 = new ModelAndView("contact");
            modelAndView.addObject("contact", new ContactDTO());
            redirectAttributes.addFlashAttribute("msg","An error occured.Please try again.");
            return modelAndView1.getViewName();

        }
        readingInboxService.readInbox();

        return "redirect:/contact";
    }
}
