package com.Universities.web.Model;

/**
 * Created by Lei Florin on 01.10.2015.
 *
 * <br>Course model class.
 */
public class Course {

    private long idcourse;
    private long idfaculty;
    private String name;
    private String professorName;
    private Faculty faculty;


    /**
     * Constructors, getters and setters.
     */

    public Course() {  }

    public Course(long idcourse, long idfaculty, String name, String professorName, Faculty faculty) {
        this.idcourse = idcourse;
        this.idfaculty = idfaculty;
        this.name = name;
        this.professorName = professorName;
        this.faculty = faculty;
    }

    public long getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(long idcourse) {
        this.idcourse = idcourse;
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

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
