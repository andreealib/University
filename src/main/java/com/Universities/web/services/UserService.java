package com.Universities.web.services;

import com.Universities.web.Dao.UserDAO;
import com.Universities.web.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andreealibotean on 11/27/2015.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUser(String login) {

        return userDAO.getUser(login);
    }
}
