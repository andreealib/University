package com.Universities.web.services;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.converter.*;
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
import com.itextpdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    CourseConverter courseConverter;

    @Autowired
    StudentConverter studentConverter;

    @Autowired
    ProfessorConverter professorConverter;

    @Autowired
    IntegerToStudent integerToStudent;

    @Autowired
    IntegerToProfessor integerToProfessor;


    public CourseDTO getCourseById(Integer idCourse) {

        Course course = courseDAO.getCourseById(idCourse);
        CourseDTO courseDTO = courseConverter.convertCourseToDTO(course);
        return courseDTO;

    }

    public List<CourseDTO> getLstCourses() {

        List<Course> lstCourses = courseDAO.getLstCourses();

        List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();

        for (Course cd : lstCourses) {
            CourseDTO courseDTO = courseConverter.convertCourseToDTO(cd);
            courseDTOs.add(courseDTO);
        }

        return courseDTOs;


    }

    public void addCourse(CourseDTO courseDTO) {
        Course course = courseConverter.convertCourseDTOToCourse(courseDTO);
        courseDAO.addCourse(course);
    }

    public void updateCourse(CourseDTO courseDTO) {

        Course course = courseConverter.convertCourseDTOToCourse(courseDTO);
        courseDAO.updateCourse(course);
    }

    public String deleteCourse(Integer idCourse) {

        if (courseDAO.deleteCourse(idCourse) == true) {
            return "The course has been deleted.";
        } else {
            return "There was a problem in deleting the course.";
        }

    }

    public List<StudentDTO> listStudentsForCourse(Integer idCourse) {

        List<Student> listStudents = courseDAO.listStudentsForCourse(idCourse);
        List<StudentDTO> registeredStudents = new ArrayList<StudentDTO>();

        for (Student s : listStudents) {
            registeredStudents.add(studentConverter.convertStudentToStudentDTO(s));
        }

        return registeredStudents;
    }


    public List<ProfessorDTO> listProfessorsForCourse(Integer idCourse) {

        List<Professor> listProfessors = courseDAO.listProfessorsForCourse(idCourse);
        List<ProfessorDTO> registeredProfessors = new ArrayList<ProfessorDTO>();

        for (Professor p : listProfessors) {
            registeredProfessors.add(professorConverter.convertProfessorToProfessorDTO(p));
        }

        return registeredProfessors;
    }

    public void addStudentsForCourse(CourseDTO courseDTO) {


        Set<Integer> studentsIds = courseDTO.getStudentsIds();


        Course course = courseDAO.getCourseById(courseDTO.getIdCourse());


        Set<Student> students = new HashSet<Student>();
        for (Integer s : studentsIds) {


            students.add(integerToStudent.convert(s));
        }
        course.getStudents().addAll(students);

        courseDAO.addStudentsForCourse(course);


    }


    public void addProfessorsForCourse(CourseDTO courseDTO) {


        Set<Integer> professorsIds = courseDTO.getProfessorsIds();

        Course course = courseDAO.getCourseById(courseDTO.getIdCourse());

        Set<Professor> professors = new HashSet<Professor>();
        for (Integer p : professorsIds) {

            professors.add(integerToProfessor.convert(p));
        }
        course.getProfessors().addAll(professors);

        courseDAO.addProfessorsForCourse(course);

    }


    public void deleteStudentFromCourse(Integer idCourse, Integer idStudent) {
        courseDAO.deleteStudentFromCourse(idCourse, idStudent);

    }

    public void deleteProfessorFromCourse(Integer idCourse, Integer idProfessor) {
        courseDAO.deleteProfessorFromCourse(idCourse, idProfessor);

    }

    public void coursesPdf(List<CourseDTO> courseDTOList) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\andreealibotean\\Desktop\\University\\src\\main\\webapp\\resources\\pdf\\courses.pdf"));
            document.open();

            Paragraph title1 = new Paragraph("List of courses for " + new Date().toString(), FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
            Paragraph title11 = new Paragraph("Courses:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
            Chapter chapter1 = new Chapter(title1, 1);
            chapter1.setNumberDepth(0);
            Section section1 = chapter1.addSection(title11);

            PdfPTable t = new PdfPTable(2);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("No."));
            t.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Name"));
            t.addCell(c2);


            int no = 0;
            for (CourseDTO c : courseDTOList) {
                t.addCell(new PdfPCell(new Phrase("" + ++no + ".")));
                t.addCell(new PdfPCell(new Phrase(c.getName())));
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

    public Integer getNoOfPages(Integer coursesPerPage) {
        Integer noOfCourses = courseDAO.getNoOfCourses();
        Integer noOfPages;
        if (noOfCourses % coursesPerPage == 0) {
            noOfPages = noOfCourses / coursesPerPage;
        } else {
            noOfPages = noOfCourses / coursesPerPage + 1;
        }
        return noOfPages;
    }

    public List<CourseDTO> getLstCoursesPerPage(Integer pageNumber, Integer coursesPerPage) {
        List<Course> courseList = courseDAO.getLstCoursesPerPage(pageNumber, coursesPerPage);

        List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();

        for (Course cd : courseList) {
            CourseDTO courseDTO = courseConverter.convertCourseToDTO(cd);
            courseDTOs.add(courseDTO);
        }

        return courseDTOs;


    }


}
