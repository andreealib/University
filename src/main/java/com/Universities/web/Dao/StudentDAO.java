package com.Universities.web.Dao;


import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.data.Student;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lei Florin on 28.09.2015.
 */
@Repository("studentDAO")
@Transactional
public class StudentDAO {

    private static final Logger logger = LoggerFactory.getLogger(StudentDAO.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }

    public Student getStudentById(Integer idStudent) {
        Session session = getSession();
        String searchQuery = "from Student s where s.idStudent = :idStudent";
        Query query = session.createQuery(searchQuery);
        query.setParameter("idStudent", idStudent);

        Student singleResult = (Student) query.uniqueResult();
        return singleResult;
    }

    public List<Student> getLstStudents() {
        Session session = getSession();
        List<Student> lstStudents = session.createQuery("from Student").list();
        return lstStudents;
    }

    public void addStudent(Student student) throws ConstraintViolationException {

        Session session = getSession();
        session.save(student);
        logger.info("student added.");

    }

    public void updateStudent(Student student) throws DataIntegrityViolationException {

        Session session = getSession();

        Student student1 = getStudentById(student.getIdStudent());

        student1.setName(student.getName());
        student1.setSurname(student.getSurname());
        student1.setCnp(student.getCnp());
        student1.setGender(student.getGender());
        student1.setCourses(student.getCourses());

        session.saveOrUpdate(student1);


    }

    public boolean deleteStudent(Integer idStudent) {

        Session session = getSession();
        boolean deleted = false;
        Student student = this.getStudentById(idStudent);
        if (student != null) {
            session.delete(student);

            //deleteing the linked courses connected to this student
            for(Course course:student.getCourses()){
                course.getStudents().remove(student);
            }

            deleted = true;
            logger.info("student deleted.");
        }

        return deleted;
    }

    public List<Course> listCoursesForStudent(Integer idStudent) {

        Session session = getSession();
        String queryString = "select courses from Student s where s.idStudent = :idStudent";
        Query query = session.createQuery(queryString);
        query.setParameter("idStudent", idStudent);
        List<Course> courses = query.list();

        return courses;
    }

    public void saveOrUpdate(Student student){
        Session session=getSession();
        session.saveOrUpdate(student);
    }


    public Integer getNoOfStudents(){
        org.hibernate.Session session=getSession();
        String queryString="select count(*) from Student";
        Query query=session.createQuery(queryString);
        Long singleResult=(Long) query.uniqueResult();
        Integer noOfStudents=singleResult.intValue();
        logger.info("no. of students is:"+noOfStudents);
        return noOfStudents;
    }

    public List<Student> getLstStudentsPerPage(Integer pageNumber, Integer studentsPerPage){
        int start=studentsPerPage*(pageNumber-1);
        org.hibernate.Session session=getSession();
        String queryString="from Student s order by s.idStudent";
        Query query=session.createQuery(queryString);
        query.setFirstResult(start);
        query.setMaxResults(studentsPerPage);

        List<Student> studentList=query.list();
        return studentList;

    }


}
