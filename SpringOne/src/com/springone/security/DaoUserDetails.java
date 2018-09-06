/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.security;

import com.springone.entity.User;
import com.springone.entity.UserSns;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author nirmal
 */
public class DaoUserDetails implements UserDetails {

    private static final SimpleGrantedAuthority ROLE_USER = new SimpleGrantedAuthority("ROLE_USER");

    private String password;
    private User user;
    private ArrayList<GrantedAuthority> authorities;

    public DaoUserDetails(UserSns userSns) {
        password = userSns.getSnsSecret();
        user = userSns.getUser();
        authorities = new ArrayList<>();
        authorities.add(ROLE_USER);
    }

    public Integer getUserId() {
        return user.getUserId();
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getStatus() != 2;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() != 0;
    }
}
