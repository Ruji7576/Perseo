package Technical.perseo.repository;

import Technical.perseo.model.Payement;
import Technical.perseo.model.UserCourse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserCourseRepository extends CrudRepository<UserCourse, Long> {
    List<UserCourse> findByUserId(Long userId);
}
