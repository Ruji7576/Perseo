package Technical.perseo.repository;

import Technical.perseo.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByUserId(Long userId);
}
