package com.Universities.web.services;

import com.Universities.web.Dao.CourseDAO;
import com.Universities.web.Dao.ProfessorDAO;
import com.Universities.web.converter.CourseConverter;
import com.Universities.web.converter.IntegerToCourse;
import com.Universities.web.converter.ProfessorConverter;
import com.Universities.web.data.Course;
import com.Universities.web.data.Professor;
import com.Universities.web.dto.CourseDTO;
import com.Universities.web.dto.ProfessorDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class ProfessorService {

    @Autowired
    public ProfessorDAO professorDAO;

    @Autowired
    public CourseDAO courseDAO;

    @Autowired
    public ProfessorConverter professorConverter;

    @Autowired
    public CourseConverter courseConverter;

    @Autowired
    IntegerToCourse integerToCourse;




    public ProfessorDTO getProfessorById(Integer idProfessor) {

        Professor professor = professorDAO.getProfessorById(idProfessor);
        ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(professorDAO.getProfessorById(idProfessor));
        return professorDTO;

    }

    public List<ProfessorDTO> getLstProfessors() {

        List<Professor> lstProfessors = professorDAO.getLstProfessors();

        List<ProfessorDTO> professorDTOs = new ArrayList<ProfessorDTO>();

        for (Professor p : lstProfessors) {
            ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(p);
            professorDTOs.add(professorDTO);
        }

        return professorDTOs;


    }

    public void addProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorConverter.convertProfessorDTOToProfessor(professorDTO);
        professorDAO.addProfessor(professor);
    }

    public void updateProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorConverter.convertProfessorDTOToProfessor(professorDTO);
        professorDAO.updateProfessor(professor);
    }

    public String deleteProfessor(Integer idProfessor) {

        if (professorDAO.deleteProfessor(idProfessor) == true) {
            return "The professor has been deleted.";
        } else {
            return "There was a problem in deleting the professor.";
        }

    }

    public List<CourseDTO> listCoursesForProfessor(Integer idProfessor) {
        List<Course> courses = professorDAO.listCoursesForProfessor(idProfessor);
        List<CourseDTO> teachingCourses = new ArrayList<CourseDTO>();

        for (Course c : courses) {
            teachingCourses.add(courseConverter.convertCourseToDTO(c));
        }

        return teachingCourses;
    }





//        Iterator<CourseDTO> iterator=teachingCourses.iterator();
//        while(iterator.hasNext()){
//
//            if(iterator.next().getIdCourse()==idCourse){
//                teachingCourses.remove(iterator.next());
//            }
//        }

//        ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(professorDAO.getProfessorById(idProfessor));
//
//
//        List<Course> courses = new ArrayList<Course>();
//
//        for (CourseDTO cdto : teachingCourses) {
//            courses.add(courseConverter.convertCourseDTOToCourse(cdto));
//        }
//
//        Course deletedCourse = courseDAO.getCourseById(idCourse);
//        courses.remove(deletedCourse);
//
//
//        Professor professor = professorDAO.getProfessorById(idProfessor);
//        professor.setCourses(courses);
//
//        professorDAO.updateProfessor(professor);

//       Professor professor=professorDAO.getProfessorById(idProfessor);
//        ProfessorDTO professorDTO=professorConverter.convertProfessorToProfessorDTO(professor);
//        Set<Integer> coursesDTO=professorDTO.getCoursesIds();
//        coursesDTO.remove(idCourse);
//        professorDTO.setCoursesIds(coursesDTO);
//
//
//
//        Course course=integerToCourse.convert(idCourse);
//        CourseDTO courseDTO=courseConverter.convertCourseToDTO(course);
//        Set<Integer> professorsDTO=courseDTO.getProfessorsIds();
//        professorsDTO.remove(idProfessor);
//        courseDTO.setProfessorsIds(professorsDTO);
//
//        Professor professorToUpdate=professorConverter.convertProfessorDTOToProfessor(professorDTO);
//        professorToUpdate.getCourses().remove(course);
//
//        Course courseToUpdate=courseConverter.convertCourseDTOToCourse(courseDTO);
//        courseToUpdate.getProfessors().remove(professor);
//
//
//
//        professorDAO.deleteCourseForProfessor(professorToUpdate);
//        courseDAO.deleteProfessorForCourse(courseToUpdate);*/


    public void professorsPdf(List<ProfessorDTO> professorDTOList) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\andreealibotean\\Desktop\\University\\src\\main\\webapp\\resources\\pdf\\professors.pdf"));
            document.open();

            Paragraph title1 = new Paragraph("List of professors for " + new Date().toString(), FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
            Paragraph title11 = new Paragraph("Professors:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
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
            for (ProfessorDTO c : professorDTOList) {
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


    public Integer getNoOfPages(Integer professorsPerPage) {
        Integer noOfProfessors = professorDAO.getNoOfProfessors();
        Integer noOfPages;
        if (noOfProfessors % professorsPerPage == 0) {
            noOfPages = noOfProfessors / professorsPerPage;
        } else {
            noOfPages = noOfProfessors / professorsPerPage + 1;
        }
        return noOfPages;
    }

    public List<ProfessorDTO> getLstProfessorsPerPage(Integer pageNumber,Integer professorsPerPage){
        List<Professor> professorList=professorDAO.getLstProfessorsPerPage(pageNumber,professorsPerPage);

        List<ProfessorDTO> professorDTOs = new ArrayList<ProfessorDTO>();

        for (Professor cd : professorList) {
            ProfessorDTO professorDTO = professorConverter.convertProfessorToProfessorDTO(cd);
            professorDTOs.add(professorDTO);
        }

        return professorDTOs;


    }



}
