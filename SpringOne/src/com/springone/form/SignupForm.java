/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.form;

import com.innovaturelabs.spring.validator.constraint.SpringAssert;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author nirmal
 */
@SpringAssert(value = "password == password2", subPath = "password2")
public class SignupForm {

    @Pattern(regexp = "^[A-Za-z0-9]+$")
    @Length(min = 6)
    private String userName;
    @Length(min = 6, max = 18)
    private String password;
    @NotEmpty()
    private String password2;
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @AssertTrue
    private boolean accept;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}