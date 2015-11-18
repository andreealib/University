package com.Universities.web.dto;

import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
public class CourseDTO {

    private Integer idCourse;
    private String name;
    private Set<StudentDTO> students;
    private Set<ProfessorDTO> professors;


    public Set<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentDTO> students) {
        this.students = students;
    }

    public Set<ProfessorDTO> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<ProfessorDTO> professors) {
        this.professors = professors;
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

        if (idCourse != null ? !idCourse.equals(courseDTO.idCourse) : courseDTO.idCourse != null) return false;
        if (name != null ? !name.equals(courseDTO.name) : courseDTO.name != null) return false;
        if (students != null ? !students.equals(courseDTO.students) : courseDTO.students != null) return false;
        return !(professors != null ? !professors.equals(courseDTO.professors) : courseDTO.professors != null);

    }

    @Override
    public int hashCode() {
        int result = idCourse != null ? idCourse.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (professors != null ? professors.hashCode() : 0);
        return result;
    }
}
