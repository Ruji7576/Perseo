package Technical.perseo.repository;

import Technical.perseo.model.Course;
import Technical.perseo.model.UserCourse;
import Technical.perseo.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDetailsRepository extends CrudRepository<UserDetails, Long> {
    List<UserDetails> findByUserId(Long userId);
}
