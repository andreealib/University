package com.Universities.web.Dao;

import com.Universities.web.data.User;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreealibotean on 11/27/2015.
 */
@Repository("userDAO")
@Transactional
public class UserDAO {

    @Autowired
    private  org.springframework.orm.hibernate3.HibernateTemplate hibernateTemplate;

    private Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    public User getUser(String login) {
        Session session = getSession();
        List<User> userList = new ArrayList<User>();
        String searchQuery = "from User u where u.login = :login";
        Query query = session.createQuery(searchQuery);
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }

    public void addUser(User user){
        Session session=getSession();
        session.saveOrUpdate(user);
    }

    public boolean checkUsernameDuplicate(String login){
        Session session=getSession();
        String searchQuery="from User u where u.login =:login";
        Query query=session.createQuery(searchQuery);
        query.setParameter("login",login);
        if(query.uniqueResult()!=null){
            return true;
        }
        else{
            return false;
        }
    }

}
