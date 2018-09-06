/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.springframework.security.web.WebAttributes.AUTHENTICATION_EXCEPTION;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nirmal
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            HttpServletRequest request,
            Model model
            ) {
        if (null != error) {
            HttpSession session = request.getSession(false); //will return a reference of session if exists otherwise null
            if (null != session) {
                Exception ex = (Exception) session.getAttribute(AUTHENTICATION_EXCEPTION);
                if (null != ex) {
                    model.addAttribute("message", ex.getMessage());
                }
            }
        }
        return "main/login";
    }
}
