package Technical.perseo.service;

import Technical.perseo.model.Course;
import Technical.perseo.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepository iCourseRepository;

    public Course getCourseByID(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    public List<Course> getAllCourses() {
        return (List<Course>) iCourseRepository.findAll();
    }

    public void deleteById(Long id) {
        iCourseRepository.deleteById(id);
    }

    public Course updateById(Long id, Course newCourse) {
        newCourse.setId(id);
       return iCourseRepository.save(newCourse);
    }

    public Course createCourse(Course course) {
        return iCourseRepository.save(course);
    }
}
