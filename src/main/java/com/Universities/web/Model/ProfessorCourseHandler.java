package com.Universities.web.Model;

import java.util.List;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public class ProfessorCourseHandler {
    private long idprofessor;
    private long idcourse;
    private long[] idcourses;

    public ProfessorCourseHandler() {
    }

    public ProfessorCourseHandler(long idprofessor, long idcourse, long idcourses[]) {
        this.idprofessor = idprofessor;
        this.idcourse = idcourse;
        this.idcourses = idcourses;
    }

    public long getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(long idprofessor) {
        this.idprofessor = idprofessor;
    }

    public long getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(long idcourse) {
        this.idcourse = idcourse;
    }

    public long[] getIdcourses() {
        return idcourses;
    }

    public void setIdcourses(long[] idcourses) {
        this.idcourses = idcourses;
    }
}
