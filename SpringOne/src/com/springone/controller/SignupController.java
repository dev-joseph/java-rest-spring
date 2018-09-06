/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.controller;

import com.springone.form.SignupForm;
import com.springone.dao.UserDao;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nirmal
 */
@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("form", new SignupForm());
        return "main/signup";
    }

    @RequestMapping(method = RequestMethod.POST)   
    public String signup(@Valid @ModelAttribute("form") SignupForm form, BindingResult result ) {
        if (result.hasErrors()) {
            return "main/signup";
        }

        userDao.addUser(form);
        return "redirect:/";
    }
   
}
