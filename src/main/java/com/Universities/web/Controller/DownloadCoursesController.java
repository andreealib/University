package com.Universities.web.Controller;

import com.Universities.web.dto.CourseDTO;
import com.Universities.web.facade.CourseFacade;
import com.Universities.web.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by andreealibotean on 11/24/2015.
 */
@Controller
public class DownloadCoursesController {

    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "/coursesPdf", method = RequestMethod.GET)
    public void donwloadCoursesPdf(HttpServletResponse response) throws IOException {

        //generate courses.pdf
        List<CourseDTO> courseDTOs = courseFacade.getLstcourses();
        courseFacade.coursesPdf(courseDTOs);

        //access the pdf and render it to user
        File file = new File("C:\\Users\\andreealibotean\\Desktop\\University\\src\\main\\webapp\\resources\\pdf\\courses.pdf");

        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        FileCopyUtils.copy(inputStream, response.getOutputStream());


    }

}
