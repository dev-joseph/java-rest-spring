/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.view;

/**
 *
 * @author nirmal
 */
public class UserView {

    private Integer userId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String imageUrl;

    public UserView(Integer userId, String userName, String email, String firstName, String lastName, String imageUrl) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
