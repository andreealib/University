package com.Universities.web.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class StudentDTO implements Serializable{

    private Integer idStudent;
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

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
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

        StudentDTO that = (StudentDTO) o;

        if (!idStudent.equals(that.idStudent)) return false;
        return cnp.equals(that.cnp);

    }

    @Override
    public int hashCode() {
        int result = idStudent.hashCode();
        result = 31 * result + cnp.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "gender='" + gender + '\'' +
                ", idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cnp=" + cnp +
                '}';
    }
}
