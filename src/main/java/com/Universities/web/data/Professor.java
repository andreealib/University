package com.Universities.web.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */

@Entity
@Table(name="professor")
public class Professor implements Serializable {

    @Id
    @Column(name = "idProfessor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfessor;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "cnp",unique = true)
    private Long cnp;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "professors",targetEntity = Course.class,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Course> courses;

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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
