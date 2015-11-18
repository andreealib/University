package com.Universities.web.services;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.Dao.StudentDAO;
import com.Universities.web.converter.CourseConverter;
import com.Universities.web.converter.ProfessorConverter;
import com.Universities.web.converter.StudentConverter;
import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.data.Student;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class StudentService {

    @Autowired
    public StudentDAO studentDAO;

    @Autowired
    public CourseDAO courseDAO;

    @Autowired
    public StudentConverter studentConverter;

    @Autowired
    public CourseConverter courseConverter;


    public StudentDTO getStudentById(Integer idStudent) {

        Student student = studentDAO.getStudentById(idStudent);
        StudentDTO studentDTO = studentConverter.convertStudentToStudentDTO(studentDAO.getStudentById(idStudent));
        return studentDTO;

    }

    public List<StudentDTO> getLstStudents() {

        List<Student> lstStudents = studentDAO.getLstStudents();

        List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();

        for (Student p : lstStudents) {
            StudentDTO studentDTO = studentConverter.convertStudentToStudentDTO(p);
            studentDTOs.add(studentDTO);
        }

        return studentDTOs;


    }

    public void addStudent(StudentDTO studentDTO)
    {
        Student student = studentConverter.convertStudentDTOToStudent(studentDTO);
        studentDAO.addStudent(student);
    }

    public void updateStudent(StudentDTO studentDTO) {
        Student student = studentConverter.convertStudentDTOToStudent(studentDTO);
        studentDAO.updateStudent(student);
    }

    public String deleteStudent(Integer idStudent) {

        if(studentDAO.deleteStudent(idStudent)==true)
        {
            return "The student has been deleted.";
        }
        else{
            return "There was a problem in deleting the student.";
        }

    }

    public List<CourseDTO> listCoursesForStudent(Integer idStudent) {
        List<Course> courses = studentDAO.listCoursesForStudent(idStudent);
        List<CourseDTO> attendingCourses = new ArrayList<CourseDTO>();

        for (Course c : courses) {
            attendingCourses.add(courseConverter.convertCourseToDTO(c));
        }

        return attendingCourses;
    }


}
