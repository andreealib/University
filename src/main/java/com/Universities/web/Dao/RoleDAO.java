package com.Universities.web.Dao;

import com.Universities.web.data.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by andreealibotean on 11/27/2015.
 */
@Repository("roleDAO")
public class RoleDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    public Role getRole(int id) {
        Session session = getSession();
        String searchQuery = "from Role r where r.id = :id";
        Query query = session.createQuery(searchQuery);
        query.setParameter("id", id);
        Role singleResult = (Role) query.uniqueResult();

        return singleResult;
    }
}
