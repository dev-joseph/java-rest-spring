/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.dao;

/**
 * Enumeration for different SNS Types.
 *
 * <p>Avaliable types are:</p>
 * <ul>
 *   <li><code>EMAIL</code></li>
 *   <li><code>TWITTER</code></li>
 *   <li><code>FACEBOOK</code></li>
 *   <li><code>LINKEDIN</code></li>
 *   <li><code>GOOGLE</code></li>
 *   <li><code>YAHOO</code></li>
 * </ul>
 *
 * @author nirmal
 */
public enum SnsType {

    /**
     * EMAIL: 1
     */
    EMAIL((byte) 1),
    /**
     * TWITTER: 2
     */
    TWITTER((byte) 2),
    /**
     * FACEBOOK: 3
     */
    FACEBOOK((byte) 3),
    /**
     * LINKEDIN: 4
     */
    LINKEDIN((byte) 4),
    /**
     * GOOGLE: 5
     */
    GOOGLE((byte) 5),
    /**
     * YAHOO: 6
     */
    YAHOO((byte) 6);

    /**
     * Value of the SNS Type - used in database.
     */
    public final byte value;

    private SnsType(byte type) {
        this.value = type;
    }

    /**
     * Get the SNS Type corresponding to a value.
     *
     * @param value
     * @return SNS Type
     */
    public static SnsType valueOf(byte value) {
        for (SnsType sns : values()) {
            if (sns.value == value) {
                return sns;
            }
        }
        throw new IllegalArgumentException("Invalid SNS Type value.");
    }
}
