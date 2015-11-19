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

        if (!idProfessor.equals(that.idProfessor)) return false;
        return !(cnp != null ? !cnp.equals(that.cnp) : that.cnp != null);

    }

    @Override
    public int hashCode() {
        int result = idProfessor.hashCode();
        result = 31 * result + (cnp != null ? cnp.hashCode() : 0);
        return result;
    }
}
