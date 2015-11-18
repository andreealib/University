package com.Universities.web.converter;

import com.Universities.web.data.Student;
import com.Universities.web.dto.StudentDTO;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class StudentConverter {

    public StudentDTO convertStudentToStudentDTO(Student student){

        StudentDTO studentDTO=new StudentDTO();

        studentDTO.setIdStudent(student.getIdStudent());
        studentDTO.setName(student.getName());
        studentDTO.setSurname(student.getSurname());
        studentDTO.setGender(student.getGender());
        studentDTO.setCnp(student.getCnp());

        return studentDTO;

    }

    public Student convertStudentDTOToStudent(StudentDTO studentDTO){

        Student student =new Student();

        student.setIdStudent(studentDTO.getIdStudent());
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setGender(studentDTO.getGender());
        student.setCnp(studentDTO.getCnp());

        return student;

    }


}
