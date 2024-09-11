package Technical.perseo.controller;


import Technical.perseo.model.Course;
import Technical.perseo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CoursesController {
    @Autowired
    CourseService courseService;

    @GetMapping(path = "/getById/{id}")
    public Course getById(@PathVariable Long id) {
    return courseService.getCourseByID(id);
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }
    @PutMapping(path = "/update/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course newCourse) {
        return courseService.updateById(id, newCourse);
    }

    @PostMapping(path = "/create")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
}
