/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.dao;

import com.innovaturelabs.spring.util.Pager;
import com.springone.form.SignupForm;
import com.springone.form.UserForm;
import com.springone.entity.User;
import com.springone.entity.UserSns;
import com.springone.entity.UserSnsId;
import com.springone.view.UserView;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nirmal
 */
@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public User getUser(int userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Transactional(readOnly = true)
    public UserView getUserView(int userId) {
        String sql = "select new com.springone.view.UserView("
                + "userId, userName, email, firstName, lastName, imageUrl"
                + ") from User where status=1 and userId=:id";
        return (UserView) sessionFactory.getCurrentSession()
                .createQuery(sql).setInteger("id", userId)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where status=1")
                .list();
    }

    @Transactional(readOnly = true)
    public Pager<UserView> getUsers(String page) {
        Session session = sessionFactory.getCurrentSession();
        int count = ((Long) session.createQuery("select count(*) from User where status=1")
                .uniqueResult()).intValue();
        Pager<UserView> pager = new Pager<>(10, count, page);
        String sql = "select new com.springone.view.UserView("
                + "userId, userName, email, firstName, lastName, imageUrl"
                + ") from User where status=1";
        List<UserView> users = session.createQuery(sql)
                .setFirstResult(pager.getStartIndex())
                .setMaxResults(pager.getPageSize())
                .list();
        pager.setResult(users);
        return pager;
    }

    @Transactional
    public void addUser(SignupForm form) {
        Date date = new Date();
        User user = new User(
                form.getUserName(),
                form.getEmail(),
                form.getFirstName(),
                form.getLastName(),
                UserStatus.ACTIVE.value,
                date,
                date
                );
        UserSns userSns = new UserSns(
                new UserSnsId(form.getEmail(), SnsType.EMAIL.value),
                user,
                form.getUserName(),
                null,
                passwordEncoder.encode(form.getPassword()),
                null,
                date,
                date,
                UserStatus.ACTIVE.value);
        HashSet<UserSns> userSnses = new HashSet<>();
        userSnses.add(userSns);
        user.setUserSnses(userSnses);

        sessionFactory.getCurrentSession().save(user);
    }

    public void updateUser(Integer userId, UserForm form) {
        Session session = sessionFactory.getCurrentSession();
        Date dt = new Date();

        User user = (User) session.load(User.class, userId);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setUpdateDate(dt);

        UserSns userSns = (UserSns) session.load(UserSns.class, new UserSnsId(form.getEmail(), SnsType.EMAIL.value));
        userSns.setSnsSecret(passwordEncoder.encode(form.getPassword()));
        userSns.setUpdateDate(dt);

        session.update(user);
        session.update(userSns);
    }
}
