package com.Universities.web.services;

import com.Universities.web.Dao.UserDAO;
import com.Universities.web.converter.UserConverter;
import com.Universities.web.data.User;
import com.Universities.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    UserConverter userConverter;

    public User getUser(String login) {

        return userDAO.getUser(login);
    }

    public void addUser(UserDTO userDTO){
        User user=userConverter.convertUserDTOToUser(userDTO);
        userDAO.addUser(user);

    }

    public boolean checkUsernameDuplicate(UserDTO userDTO){
        return userDAO.checkUsernameDuplicate(userDTO.getLogin());
    }

    public String getLoggedUser(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
