package Technical.perseo.repository;

import Technical.perseo.model.Experience;
import Technical.perseo.model.Payement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IExperienceRepository extends CrudRepository<Experience, Long> {
    List<Experience> findByUserId(Long userId);
}
