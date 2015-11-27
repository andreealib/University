package com.Universities.web.services;

import com.Universities.web.Dao.RoleDAO;
import com.Universities.web.data.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 11/27/2015.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role getRole(int id){
        return roleDAO.getRole(id);
    }
}


