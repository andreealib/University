package com.Universities.web.Controller;

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

        return new ModelAndView("moderation");
    }


    @RequestMapping(value = "/admin/first", method = RequestMethod.GET)
    public ModelAndView firstAdminPage() {

        return new ModelAndView("admin-first");
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        return model;

    }
}
