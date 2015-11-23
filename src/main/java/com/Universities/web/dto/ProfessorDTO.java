package com.Universities.web.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class ProfessorDTO implements Serializable{
    private Integer idProfessor;
    private String name;
    private String surname;
    private String gender;
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
