package com.Universities.web.Model;

/**
 * Created by Lei Florin on 28.09.2015.
 *
 * <br>Student model class.
 */
public class Student {
    private long idstudent;
    private long idfaculty;
    private String name;
    private String surname;
    private String birth_date;
    private String sex;
    private String CNP;
    private Faculty faculty;

    /**
     * Constructors, getters and setters.
     */

    public Student() {}

    public Student(long idstudent, long idfaculty, String name, String surname, String birth_date, String sex, String CNP, Faculty faculty) {
        this.idstudent = idstudent;
        this.idfaculty = idfaculty;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.sex = sex;
        this.CNP = CNP;
        this.faculty = faculty;
    }

    public long getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(long idstudent) {
        this.idstudent = idstudent;
    }

    public long getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(long idfaculty) {
        this.idfaculty = idfaculty;
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

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
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

