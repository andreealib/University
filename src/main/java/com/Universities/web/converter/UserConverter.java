package com.Universities.web.converter;

;
import com.Universities.web.Dao.RoleDAO;
import com.Universities.web.data.User;
import com.Universities.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 12/8/2015.
 */
@Service
public class UserConverter {

    @Autowired
    RoleDAO roleDAO;

    public User convertUserDTOToUser(UserDTO userDTO){
        User user=new User();
        user.setId(userDTO.getIdUser());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRole(roleDAO.getRole(userDTO.getIdRole()));
        return user;
    }

    public UserDTO convertUserToUserDTO(User user){
        UserDTO userDTO=new UserDTO();
        userDTO.setIdUser(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
