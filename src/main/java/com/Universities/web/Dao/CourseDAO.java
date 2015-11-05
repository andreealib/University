package com.Universities.web.Dao;

import com.Universities.web.Model.Course;

import java.util.List;

/**
 * Created by Lei Florin on 01.10.2015.
 */
public interface CourseDAO {

    /**
     * Method to insert a new entry in "courses" table.
     * @param course Course object which will be inserted.
     */
    void insert(Course course);

    /**
     * Method to update an entry from "courses" table based on "idcourse" param.
     * @param course Course object which will be updated.
     * @param idcourse id of Course object.
     */
    void update(Course course, int idcourse);

    /**
     * Method to delete an entry from "courses" table based on "idcourse" param.
     * @param idcourse id of Course object which will be deleted.
     */
    void delete(int idcourse);

    /**
     * Method to find a entry from "courses" table based on "idcourse" param.
     * @param idcourse id of Course object which will be searched.
     * @return Course object.
     */
    Course findByCourseId(int idcourse);

    /**
     * Method to find all entries from "courses" table which belongs to certain entry from "faculties" table.
     * @param idfaculty id of faculty.
     * @return List<Course> list objects.
     */
    List<Course> findAllCoursesBelongsToFaculty(int idfaculty);

    /**
     * Method to find all entries from "courses" table.
     * @return List<Course> list objects.
     */
    List<Course> getallCourses();
}