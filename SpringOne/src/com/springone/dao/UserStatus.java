/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.dao;

/**
 *
 * @author nirmal
 */
public enum UserStatus {

    NEW((byte) 0),
    ACTIVE((byte) 1),
    BLOCKED((byte) 2);

    public final byte value;

    private UserStatus(byte value) {
        this.value = value;
    }

    public static UserStatus valueOf(byte value) {
        for (UserStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid User Status value");
    }
}
