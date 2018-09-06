/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.dao;

import com.springone.entity.UserSns;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nirmal
 */
@Repository
@Transactional
public class UserSnsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public UserSns getUserSns(String email) {
        return (UserSns) sessionFactory.getCurrentSession()
                .createQuery("from UserSns s join fetch s.user where s.id.snsId=:snsid and s.id.snsType=1")
                .setString("snsid", email)
                .uniqueResult();
    }
}
