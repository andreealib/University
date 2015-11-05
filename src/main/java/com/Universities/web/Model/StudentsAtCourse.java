package com.Universities.web.Model;

/**
 * Created by Lei Florin on 02.10.2015.
 *
 * <br>StudentsAtCourse model class.
 */
public class StudentsAtCourse {
    private long idstudent;
    private long idfaculty;
    private long idcourse;

    /**
     * Constructors, getters and setters.
     */

    public StudentsAtCourse() {}

    public StudentsAtCourse(long idstudent, long idfaculty, long idcourse) {
        this.idstudent = idstudent;
        this.idfaculty = idfaculty;
        this.idcourse = idcourse;
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

    public long getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(long idcourse) {
        this.idcourse = idcourse;
    }
}
