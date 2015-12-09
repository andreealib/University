package com.Universities.web.Controller;

import com.Universities.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by andreealibotean on 11/27/2015.
 */
@Controller
public class LinkNavigation {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {

        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexPage() {

        return new ModelAndView("home");
    }


    @RequestMapping(value = "/sec/moderation", method = RequestMethod.GET)
    public ModelAndView moderatorPage() {
        ModelAndView modelAndView = new ModelAndView("moderation");
        modelAndView.addObject("username", userService.getLoggedUser());
        return modelAndView;
    }


    @RequestMapping(value = "/admin/first", method = RequestMethod.GET)
    public ModelAndView firstAdminPage() {
        ModelAndView modelAndView = new ModelAndView("admin-first");
        modelAndView.addObject("username", userService.getLoggedUser());
        return modelAndView;
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        return model;

    }
}
