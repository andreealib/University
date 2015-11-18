//package com.Universities.web.DaoImpl;
//
//import com.Universities.web.Dao.StudentDAO;
//import com.Universities.web.Mapper.StudentRowMapper;
//import com.Universities.web.Model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//
//import javax.sql.DataSource;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Lei Florin on 28.09.2015.
// */
//public class StudentDAOImpl extends JdbcDaoSupport implements StudentDAO {
//
//    @Autowired
//    public StudentDAOImpl(DataSource dataSource) {
//        this.setDataSource(dataSource);
//    }
//
//    /**
//     * Method to insert a new entry in "students" table.
//     * @param student Student object which will be inserted.
//     */
//    public void insert(Student student) {
//        String SQL = "INSERT INTO students (idfaculty, name, surname, birthDate, sex, CNP) VALUE ( ?, ?, ?, ?, ?, ?)";
//        Object[] object = new Object[] {student.getIdfaculty(), student.getName(), student.getSurname(),
//                                        student.getBirth_date(), student.getSex(), student.getCNP()};
//
//        getJdbcTemplate().update(SQL, object);
//    }
//
//    /**
//     * Method to update an entry from "students" table based on "idstudent" param.
//     * @param student Student object which will be updated.
//     * @param idstudent id of Student object.
//     */
//    public void update(Student student, int idstudent) {
//        String SQL = "UPDATE students set name=?, surname=?, birthDate=?, sex=?, CNP=? WHERE idstudent=?";
//        Object[] object = new Object[] {student.getName(), student.getSurname(),
//                                        student.getBirth_date(), student.getSex(), student.getCNP(), idstudent};
//
//        getJdbcTemplate().update(SQL, object);
//    }
//
//    /**
//     * Method to delete an entry from "students" table based on "idstudent" param.
//     * @param idstudent id of Student object which will be deleted.
//     */
//    public void delete(int idstudent) {
//        String SQL = "DELETE FROM students WHERE idstudent=?";
//        getJdbcTemplate().update(SQL, new Object[]{idstudent});
//    }
//
//    /**
//     * Method to find a entry from "students" table based on "idstudent" param.
//     * @param idstudent id of Student object which will be searched.
//     * @return Student object.
//     */
//    public Student findbyStudentId(int idstudent) {
//        String SQL = "SELECT s.*, f.idfaculty, f.name as facultyName, f.city FROM " +
//                     "students s INNER JOIN faculties f on s.idfaculty = f.idfaculty  where s.idstudent = ?";
//
//        Student student = (Student) getJdbcTemplate().queryForObject(SQL, new Object[]{idstudent}, new StudentRowMapper());
//        return student;
//    }
//
//    public Student findByFacultyName(String name) {
//        return null;
//    }
//
//    public Student findByFacultyCity(String city) {
//        return null;
//    }
//
//    /**
//     * Method to find all entries from "students" table.
//     * @return List<Student> list objects.
//     */
//    public List<Student> getAllStudents() {
//        String SQL = "SELECT s.idstudent, s.name, s.surname, s.birthDate, s.sex, s.cnp, " +
//                     "f.idfaculty , f.name AS facultyName, f.city FROM students s INNER JOIN " +
//                     "faculties f on s.idfaculty=f.idfaculty";
//
//
//        StudentRowMapper studentRowMapper = new StudentRowMapper();
//        List<Student> studentList = getJdbcTemplate().query(SQL, studentRowMapper);
//
//        return studentList;
//    }
//}
