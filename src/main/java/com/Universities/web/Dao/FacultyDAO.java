package com.Universities.web.Dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.Universities.web.Model.Faculty;;

/**
 * Created by Lei Florin on 18.09.2015.
 */
public interface FacultyDAO {

    /**
     * Method to insert a new entry in "faculties" table.
     * @param faculty Faculty object which will be inserted.
     */
    void insert(Faculty faculty);

    /**
     * Method to update an entry from "faculties" table based on "idfaculty" param.
     * @param faculty Faculty object which will be updated.
     * @param idfaculty id of faculty.
     */
    void update(Faculty faculty, int idfaculty);

    /**
     * Method to delete an entry from "faculties" table based on "idfaculty" param.
     * @param idfaculty id of faculty which will be deleted.
     */
    void delete(int idfaculty);

    /**
     * Method to find a entry from "faculties" table based on "idfacultie" param.
     * @param idfaculty id of Faculty object which will be searched.
     * @return Faculty object.
     */
    Faculty findByFacultyId(int idfaculty);

    /**
     *
     * @param name
     * @return
     */
    List<Faculty> findByFacultyName(String name);

    /**
     *
     * @param city
     * @return
     */
    Faculty findByFacultyCity(String city);

    /**
     * Method to find all entries from "faculties" table.
     * @return List<Faculty> list objects.
     */
    List<Faculty> getAllFaculties();
}
