package com.Universities.web.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class CourseDTO implements Serializable {

    private Integer idCourse;
    private String name;
    private Set<Integer> studentsIds;
    private Set<Integer> professorsIds;


    public Set<Integer> getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(Set<Integer> studentsIds) {
        this.studentsIds = studentsIds;
    }

    public Set<Integer> getProfessorsIds() {
        return professorsIds;
    }

    public void setProfessorsIds(Set<Integer> professorsIds) {
        this.professorsIds = professorsIds;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseDTO courseDTO = (CourseDTO) o;

        return idCourse.equals(courseDTO.idCourse);

    }

    @Override
    public int hashCode() {
        return idCourse.hashCode();
    }
}
