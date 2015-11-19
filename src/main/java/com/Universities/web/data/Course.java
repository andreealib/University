package com.Universities.web.data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Entity
@Table(name="course")
public class Course implements Serializable {

    @Id
    @Column(name = "idCourse")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCourse;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="course_has_student",joinColumns = @JoinColumn(name="course_idCourse"),inverseJoinColumns = @JoinColumn(name= "student_idStudent"))
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="professor_has_course",joinColumns = @JoinColumn(name="course_idCourse"),inverseJoinColumns = @JoinColumn(name="professor_idProfessor"))
    private Set<Professor> professors;

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
}
