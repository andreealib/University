package com.Universities.web.dto;

import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class ProfessorDTO {
    private Integer idProfessor;
    private String name;
    private String surname;
    private String gender;
    private Long cnp;
    private Set<CourseDTO> courses;


    public Set<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseDTO> courses) {
        this.courses = courses;
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

        if (idProfessor != null ? !idProfessor.equals(that.idProfessor) : that.idProfessor != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (cnp != null ? !cnp.equals(that.cnp) : that.cnp != null) return false;
        return !(courses != null ? !courses.equals(that.courses) : that.courses != null);

    }

    @Override
    public int hashCode() {
        int result = idProfessor != null ? idProfessor.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (cnp != null ? cnp.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        return result;
    }
}
