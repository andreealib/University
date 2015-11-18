package com.Universities.web.converter;

import com.Universities.web.data.Course;
import com.Universities.web.dto.CourseDTO;
import org.springframework.stereotype.Service;

/**
 * Created by andreealibotean on 11/17/2015.
 */
@Service
public class CourseConverter {

    public CourseDTO convertCourseToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setIdCourse(course.getIdCourse());
        courseDTO.setName(course.getName());

        return courseDTO;

    }

    public Course convertCourseDTOToCourse(CourseDTO courseDTO){
        Course course =new Course();

        course.setIdCourse(courseDTO.getIdCourse());
        course.setName(courseDTO.getName());

        return course;
    }
}
