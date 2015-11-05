package com.Universities.web.Dao;

import com.Universities.web.Model.Student;

import java.util.List;

/**
 * Created by Lei Florin on 28.09.2015.
 */
public interface StudentDAO {

    /**
     * Method to insert a new entry in "students" table.
     * @param student Student object which will be inserted.
     */
    void insert(Student student);

    /**
     * Method to update an entry from "students" table based on "idstudent" param.
     * @param student Student object which will be updated.
     * @param idstudent id of Student object.
     */
    void update(Student student, int idstudent);

    /**
     * Method to delete an entry from "students" table based on "idstudent" param.
     * @param idstudent id of Student object which will be deleted.
     */
    void delete(int idstudent);

    /**
     * Method to find a entry from "students" table based on "idstudent" param.
     * @param idstudent id of Student object which will be searched.
     * @return Student object.
     */
    Student findbyStudentId(int idstudent);

    /**
     *
     * @param name
     * @return
     */
    Student findByFacultyName(String name);

    /**
     *
     * @param city
     * @return
     */
    Student findByFacultyCity(String city);

    /**
     * Method to find all entries from "students" table.
     * @return List<Student> list objects.
     */
    List<Student> getAllStudents();
}
