/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.security;

import com.springone.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author nirmal
 */
public class AuthHelper {

    private AuthHelper() {
    }

    private static DaoUserDetails getPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null == auth) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (!(principal instanceof DaoUserDetails)) {
            return null;
        }
        return ((DaoUserDetails) principal);
    }

    public static User getCurrentUser() {
        DaoUserDetails principal = getPrincipal();
        if (null == principal) {
            return null;
        }
        return principal.getUser();
    }

    public static Integer getCurrentUserId() {
        DaoUserDetails principal = getPrincipal();
        if (null == principal) {
            return null;
        }
        return principal.getUserId();
    }
}
