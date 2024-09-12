package Technical.perseo.service;

import Technical.perseo.model.Course;
import Technical.perseo.model.UserCourse;
import Technical.perseo.repository.IUserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserCourseService {

    @Autowired
    IUserCourseRepository iUserCourseRepository;

    public List<UserCourse> getAllCourses() {
        return (List<UserCourse>) iUserCourseRepository.findAll();
    }
    public List<UserCourse> getAllCoursesByUserId(Long user_id) {
        return iUserCourseRepository.findByUserId(user_id);
    }
    public void deleteUserCourse(Long id) {
        iUserCourseRepository.deleteById(id);
    }
    public UserCourse updateUserCourse(Long id, UserCourse userCourse) {
        userCourse.setId(id);
        return iUserCourseRepository.save(userCourse);
    }
    public UserCourse completeCourse(Long user_id, Long course_id) {
        List<UserCourse> userCourses = iUserCourseRepository.findByUserId(user_id);
        for (UserCourse userCourse : userCourses) {
            if(userCourse.getCourse().getId().equals(course_id)) {
                if(userCourse.isCompleted()) {
                    userCourse.setCompleted(false);
                    return iUserCourseRepository.save(userCourse);
                } else {
                    userCourse.setCompleted(true);
                    return iUserCourseRepository.save(userCourse);
                }
            }
        }
        throw new NoSuchElementException("Course with ID " + course_id + " not found for user with ID " + user_id);
    }
}
