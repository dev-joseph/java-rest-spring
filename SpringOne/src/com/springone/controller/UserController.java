/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.controller;

import com.innovaturelabs.spring.exception.PageNotFoundException;
import com.innovaturelabs.spring.util.Pager;
import com.springone.form.UserForm;
import com.springone.dao.UserDao;
import com.springone.view.UserView;
import com.springone.security.AuthHelper;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nirmal
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/home")
    public String home(
            Model model,
            @RequestParam(value = "page", required = false) String page
            ) {

        model.addAttribute("me", AuthHelper.getCurrentUser());
        model.addAttribute("pager", userDao.getUsers(page));
        return "user/home";
    }

    @RequestMapping("/home.json")
    public String homeJson(
            Model model,
            @RequestParam(value = "page", required = false) String page
            ) {

        Pager<UserView> pager = userDao.getUsers(page);
        model.addAttribute("users", pager.getResult());
        model.addAttribute("count", pager.getNumItems());
        model.addAttribute("page", pager.getCurrentPage());
        model.addAttribute("lastPage", pager.getLastPage());
        return "jsonView";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", userDao.getUserView(AuthHelper.getCurrentUserId()));
        return "user/profile";
    }

    @RequestMapping("/profile.json")
    public String profileJson(Model model) {
        model.addAttribute("user", userDao.getUserView(AuthHelper.getCurrentUserId()));
        return "jsonView";
    }

    @RequestMapping("/profile/{id}")
    public String profile(
            Model model,
            @PathVariable("id") int id
            ) {

        UserView user = userDao.getUserView(id);
        if (null == user) {
            throw new PageNotFoundException("User not found");
        }
        model.addAttribute("user", user);
        return "user/profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        UserForm form = new UserForm(userDao.getUser(AuthHelper.getCurrentUserId()));
        model.addAttribute("form", form);
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(
            @Valid @ModelAttribute("form") UserForm form,
            BindingResult result) {

        if (result.hasErrors()) {
            return "user/edit";
        }

        userDao.updateUser(AuthHelper.getCurrentUserId(), form);
        return "redirect:/user/profile";
    }
}
