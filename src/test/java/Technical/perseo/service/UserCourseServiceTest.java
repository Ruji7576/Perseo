package Technical.perseo.service;

import Technical.perseo.model.Course;
import Technical.perseo.model.User;
import Technical.perseo.model.UserCourse;
import Technical.perseo.repository.IUserCourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class UserCourseServiceTest {

    @InjectMocks
    private UserCourseService userCourseService;

    @Mock
    private IUserCourseRepository iUserCourseRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCourses() {
    }

    @Test
    void getAllCoursesByUserId() {
    }

    @Test
    void deleteUserCourse() {
    }

    @Test
    void updateUserCourse() {
    }

    @Test
    void completeCourseTrue() {
        User user = new User(1L, "Ivan", null, null, null, null, null, null, null, null);
        Course course = new Course(1L, "IT", "none", null, 100, null, 100, null, null, null, null);
        Course secondCourse = new Course(2L, "Digital", "none", null, 200, null, 200, null, null, null, null);
        UserCourse userCourse = new UserCourse(1L, false, user, course);
        UserCourse secondUserCourse = new UserCourse(2L, false, user, secondCourse);
        List<UserCourse> userCourses = List.of(userCourse, secondUserCourse);

        when(iUserCourseRepository.findByUserId(1L)).thenReturn(userCourses);
        when(iUserCourseRepository.save(any(UserCourse.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserCourse result = userCourseService.completeCourse(1L, 1L);

        assertNotNull(result);
        assertTrue(result.isCompleted());

        assertEquals("IT", result.getCourse().getName());
        assertEquals(1L, result.getCourse().getId());

        verify(iUserCourseRepository, times(1)).findByUserId(1L);
        verify(iUserCourseRepository, times(1)).save(result);
    }
    @Test
    void completeCourseFalse() {
        User user = new User(1L, "Ivan", null, null, null, null, null, null, null, null);
        Course course = new Course(1L, "IT", "none", null, 100, null, 100, null, null, null, null);
        Course secondCourse = new Course(2L, "Digital", "none", null, 200, null, 200, null, null, null, null);
        UserCourse userCourse = new UserCourse(1L, true, user, course);
        UserCourse secondUserCourse = new UserCourse(2L, true, user, secondCourse);
        List<UserCourse> userCourses = List.of(userCourse, secondUserCourse);

        when(iUserCourseRepository.findByUserId(1L)).thenReturn(userCourses);
        when(iUserCourseRepository.save(any(UserCourse.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserCourse result = userCourseService.completeCourse(1L, 1L);

        assertNotNull(result);
        assertFalse(result.isCompleted());

        assertEquals("IT", result.getCourse().getName());
        assertEquals(1L, result.getCourse().getId());

        verify(iUserCourseRepository, times(1)).findByUserId(1L);
        verify(iUserCourseRepository, times(1)).save(result);
    }
}