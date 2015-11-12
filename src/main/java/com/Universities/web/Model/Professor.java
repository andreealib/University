package com.Universities.web.Model;

import javax.validation.constraints.*;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public class Professor {
    private long idprofessor;
    private long idfaculty;
    private String name;
    private String birthDate;
    private String sex;
    private String CNP;
    private Faculty faculty;

    public Professor() {
    }

    public Professor(long idprofessor, long idfaculty, String name, String birthDate, String sex, String CNP, Faculty faculty) {
        this.idprofessor = idprofessor;
        this.idfaculty = idfaculty;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.CNP = CNP;
        this.faculty = faculty;

    }

    public long getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(long idProfessor) {
        this.idprofessor = idProfessor;
    }

    public long getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(long idFaculty) {
        this.idfaculty = idFaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
