package com.Universities.web.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class CourseDTO implements Serializable {

    private Integer idCourse;

    @Size(min = 2,message = "Size name must be larger than 2.")
    @NotBlank(message = "Cannot be empty.")
    @Pattern(regexp = "^(?!\\s*$|\\s).*$",message = "Cannot begin with spaces.")
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

        return !(getIdCourse() != null ? !getIdCourse().equals(courseDTO.getIdCourse()) : courseDTO.getIdCourse() != null);

    }

    @Override
    public int hashCode() {
        return getIdCourse() != null ? getIdCourse().hashCode() : 0;
    }
}
