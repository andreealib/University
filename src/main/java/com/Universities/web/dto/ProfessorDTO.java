package com.Universities.web.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class ProfessorDTO implements Serializable {
    private Integer idProfessor;

    @Size(min = 2, message = "Size name must be larger than 2.")
    @NotBlank(message = "Cannot be empty.")
    @Pattern(regexp = "^(?!\\s*$|\\s).*$",message = "Cannot begin with spaces.")

    private String name;

    @Size(min = 2, message = "Size surname must be larger than 2.")
    @NotBlank(message = "Cannot be empty.")
    @Pattern(regexp = "^(?!\\s*$|\\s).*$",message = "Cannot begin with spaces.")
    private String surname;

    @Pattern(regexp = "^[M|F|m|f]", message = "Gender must be: M,F,m or f and consists of only 1 character.")
    private String gender;

    @NotNull(message = "Cannot be empty.")
    @Range(min = 1000000000000L,max = 9999999999999L,message = "Must consist of 13-digit number and cannot start with 0.")
    private Long cnp;

    private Set<Integer> coursesIds;


    public Set<Integer> getCoursesIds() {
        return coursesIds;
    }

    public void setCoursesIds(Set<Integer> coursesIds) {
        this.coursesIds = coursesIds;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfessorDTO that = (ProfessorDTO) o;

        if (getIdProfessor() != null ? !getIdProfessor().equals(that.getIdProfessor()) : that.getIdProfessor() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(that.getSurname()) : that.getSurname() != null) return false;
        if (getGender() != null ? !getGender().equals(that.getGender()) : that.getGender() != null) return false;
        return !(getCnp() != null ? !getCnp().equals(that.getCnp()) : that.getCnp() != null);

    }

    @Override
    public int hashCode() {
        int result = getIdProfessor() != null ? getIdProfessor().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getCnp() != null ? getCnp().hashCode() : 0);
        return result;
    }
}
