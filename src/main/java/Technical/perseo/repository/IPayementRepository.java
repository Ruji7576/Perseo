package Technical.perseo.repository;

import Technical.perseo.model.Course;
import Technical.perseo.model.Payement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPayementRepository extends CrudRepository<Payement, Long> {
    List<Payement> findByUserId(Long userId);
}
