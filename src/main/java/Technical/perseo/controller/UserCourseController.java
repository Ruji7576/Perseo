package Technical.perseo.controller;

import Technical.perseo.model.UserCourse;
import Technical.perseo.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userCourse")
public class UserCourseController {

    @Autowired
    UserCourseService userCourseService;

    @GetMapping(path = "/getAll")
    public List<UserCourse> getAllUserCourse() {
        return userCourseService.getAllCourses();
    }
    @GetMapping(path = "/getAll/{user_id}")
    public List<UserCourse> getAllUserCourseByUserId(@PathVariable Long user_id) {
        return userCourseService.getAllCoursesByUserId(user_id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        userCourseService.deleteUserCourse(id);
    }

    @PutMapping(path = "/update/{id}")
    public UserCourse deleteCourse(@PathVariable Long id, @RequestBody UserCourse userCourse) {
       return userCourseService.updateUserCourse(id, userCourse);
    }
    @PutMapping(path = "/complete/{user_id}")
    public UserCourse completeCourse(@PathVariable Long user_id, @RequestParam Long course_id) {
        return userCourseService.completeCourse(user_id,course_id);
    }
}
