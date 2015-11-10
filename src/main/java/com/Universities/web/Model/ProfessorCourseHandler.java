package com.Universities.web.Model;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public class ProfessorCourseHandler {
    private long idprofessor;
    private long idfaculty;
    private long idcourse;

    public ProfessorCourseHandler() {
    }

    public ProfessorCourseHandler(long idprofessor, long idfaculty, long idcourse) {
        this.idprofessor = idprofessor;
        this.idfaculty = idfaculty;
        this.idcourse = idcourse;
    }

    public long getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(long idprofessor) {
        this.idprofessor = idprofessor;
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
