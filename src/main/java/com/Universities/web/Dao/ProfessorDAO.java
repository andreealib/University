package com.Universities.web.Dao;


import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.data.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andreealibotean on 11/9/2015.
 */
@Repository("professorDAO")
@Transactional
public class ProfessorDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProfessorDAO.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    public Professor getProfessorById(Integer idProfessor) {
        Session session = getSession();
        String searchQuery = "from Professor p where p.idProfessor = :idProfessor";
        Query query = session.createQuery(searchQuery);
        query.setParameter("idProfessor", idProfessor);

        Professor singleResult = (Professor) query.uniqueResult();
        return singleResult;
    }

    public List<Professor> getLstProfessors() {
        Session session = getSession();
        List<Professor> lstProfessors = session.createQuery("from Professor").list();
        return lstProfessors;
    }

    public void addProfessor(Professor professor) {

        Session session = getSession();
        session.save(professor);
        logger.info("professor added");

    }

    public void updateProfessor(Professor professor) {

        Session session = getSession();

        Professor professor1 = getProfessorById(professor.getIdProfessor());

        professor1.setName(professor.getName());
        professor1.setSurname(professor.getSurname());
        professor1.setCnp(professor.getCnp());
        professor1.setGender(professor.getGender());
        professor1.setCourses(professor.getCourses());

        session.saveOrUpdate(professor1);


    }

    public boolean deleteProfessor(Integer idProfessor) {

        Session session = getSession();
        boolean deleted = false;
        Professor professor = this.getProfessorById(idProfessor);
        if (professor != null) {
            session.delete(professor);

            //deleteing the linked courses connected to this professor
            for(Course course:professor.getCourses()){
                course.getProfessors().remove(professor);
            }

            deleted = true;
        }

        return deleted;
    }

    public List<Course> listCoursesForProfessor(Integer idProfessor) {
        Session session = getSession();
        String queryString = "select courses from Professor p where p.idProfessor = :idProfessor";
        Query query = session.createQuery(queryString);
        query.setParameter("idProfessor", idProfessor);
        List<Course> courses = query.list();
        return courses;
    }

    public void saveOrUpdate(Professor professor){
        Session session=getSession();
        session.saveOrUpdate(professor);
    }


}
