package com.Universities.web.facade;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.Universities.web.dto.StudentDTO;
import com.Universities.web.services.ProfessorService;
import com.Universities.web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andreealibotean on 11/18/2015.
 */
@Service
public class StudentFacade {

    @Autowired
    StudentService studentService;


    public List<StudentDTO> getLstStudents() {

        return studentService.getLstStudents();
    }

    public void addStudent(StudentDTO studentDTO) {

        studentService.addStudent(studentDTO);
    }

    public StudentDTO viewStudent(Integer idStudent) {


        return studentService.getStudentById(idStudent);
    }

    public void updateStudent(StudentDTO studentDTO) {

        studentService.updateStudent(studentDTO);
    }

    public String deleteStudent(Integer idStudent) {

        return studentService.deleteStudent(idStudent);
    }

    public List<CourseDTO> listCoursesForStudent(Integer idStudent){
        return studentService.listCoursesForStudent(idStudent);
    }

    public void studentsPdf(List<StudentDTO> studentDTOList){
        studentService.studentsPdf(studentDTOList);

    }
}
