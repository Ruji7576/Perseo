package Technical.perseo.repository;

import Technical.perseo.model.Payement;
import Technical.perseo.model.UserCourse;
import org.springframework.data.repository.CrudRepository;

public interface IUserCourseRepository extends CrudRepository<UserCourse, Long> {
}
