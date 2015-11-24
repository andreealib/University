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
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
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

    public void studentsPdf(List<StudentDTO> studentDTOList) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\andreealibotean\\Desktop\\University\\src\\main\\webapp\\resources\\pdf\\students.pdf"));
            document.open();

            Paragraph title1 = new Paragraph("List of students for " + new Date().toString(), FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
            Paragraph title11 = new Paragraph("Students:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
            Chapter chapter1 = new Chapter(title1, 1);
            chapter1.setNumberDepth(0);
            Section section1 = chapter1.addSection(title11);

            PdfPTable t = new PdfPTable(5);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("No."));
            t.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Name"));
            t.addCell(c2);

            PdfPCell c3 = new PdfPCell(new Phrase("Surname"));
            t.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("Gender"));
            t.addCell(c4);

            PdfPCell c5 = new PdfPCell(new Phrase("CNP"));
            t.addCell(c5);
            int no = 0;
            for (StudentDTO c : studentDTOList) {
                t.addCell(new PdfPCell(new Phrase("" + ++no + ".")));
                t.addCell(new PdfPCell(new Phrase(c.getName())));
                t.addCell(new PdfPCell(new Phrase(c.getSurname())));
                t.addCell(new PdfPCell(new Phrase(c.getGender())));
                t.addCell(new PdfPCell(new Phrase(""+c.getCnp())));
            }

            section1.add(t);
            document.add(chapter1);
            document.close();


        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
