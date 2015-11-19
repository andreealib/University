package com.Universities.web.Dao;

import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.data.Student;
import com.Universities.web.dto.StudentDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by andreealibotean on 11/17/2015.
 */

@Repository("courseDAO")
@Transactional
public class CourseDAO {

    private static final Logger logger = LoggerFactory.getLogger(CourseDAO.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    public Course getCourseById(Integer idCourse) {
        Session session = getSession();
        String searchQuery = "from Course c where c.idCourse = :idCourse";
        Query query = session.createQuery(searchQuery);
        query.setParameter("idCourse", idCourse);
        Course singleResult = (Course) query.uniqueResult();

        return singleResult;
    }

    public List<Course> getLstCourses() {
        Session session = getSession();
        List<Course> lstCourses = session.createQuery("from Course").list();

        return lstCourses;
    }

    public void addCourse(Course course) {
        Session session = getSession();
        session.save(course);
        logger.info("course saved.");
    }

    public void updateCourse(Course course) {

        Session session = getSession();

        Course course1 = getCourseById(course.getIdCourse());
        course1.setName(course.getName());
        course1.setProfessors(course.getProfessors());
        course1.setStudents(course.getStudents());

        session.saveOrUpdate(course1);


    }

    public boolean deleteCourse(Integer idCourse) {

        Session session = getSession();

        Boolean deleted = false;
        Course course = this.getCourseById(idCourse);
        if (course != null) {
            session.delete(course);
            logger.info("course deleted");
            deleted = true;
        }

        return deleted;

    }

    public List<Student> listStudentsForCourse(Integer idCourse) {
        Session session = getSession();
        String queryString = "select students from Course c where c.idCourse = :idCourse";
        Query query = session.createQuery(queryString);
        query.setParameter("idCourse", idCourse);
        List<Student> listStudents = query.list();

        return listStudents;


    }

    public List<Professor> listProfessorsForCourse(Integer idCourse) {
        Session session = getSession();
        String queryString = "select professors from Course c where c.idCourse = :idCourse";
        Query query = session.createQuery(queryString);
        query.setParameter("idCourse", idCourse);
        List<Professor> listProfessors = query.list();

        return listProfessors;


    }

    public void addStudentsForCourse(Course course) {

        Session session = getSession();
        session.saveOrUpdate(course);

    }

    public void addProfessorsForCourse(Course course) {

        Session session = getSession();
        session.saveOrUpdate(course);

    }


}
