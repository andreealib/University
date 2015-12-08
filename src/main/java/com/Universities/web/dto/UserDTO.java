package com.Universities.web.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by andreealibotean on 12/8/2015.
 */
public class UserDTO {

    private Integer idUser;

    @Size(min = 2,message = "Username must be larger than 2.")
    @NotBlank(message = "Cannot be empty.")
    @Pattern(regexp = "^(?!\\s*$|\\s).*$",message = "Cannot begin with spaces.")
    private String login;

    @Size(min=6,message = "Password must be at least 6 characters long.")
    @NotBlank(message = "Cannot be empty.")
    @Pattern(regexp = "^(?!\\s*$|\\s).*$",message = "Cannot begin with spaces.")
    private String password;

    private Integer idRole;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (getIdUser() != null ? !getIdUser().equals(userDTO.getIdUser()) : userDTO.getIdUser() != null) return false;
        return !(getLogin() != null ? !getLogin().equals(userDTO.getLogin()) : userDTO.getLogin() != null);

    }

    @Override
    public int hashCode() {
        int result = getIdUser() != null ? getIdUser().hashCode() : 0;
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        return result;
    }
}
