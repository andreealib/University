package com.Universities.web.Dao;

import com.Universities.web.Model.Professor;

import java.util.List;

/**
 * Created by andreealibotean on 11/9/2015.
 */
public interface ProfessorDAO {
    void insert(Professor professor);

    void update(Professor professor, int idprofessor);

    void delete(int idprofessor);

    List<Professor> getAllProfessors();

    Professor findByProfessorId(int idprofessor);
}
