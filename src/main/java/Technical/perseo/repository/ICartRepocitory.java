package Technical.perseo.repository;

import Technical.perseo.model.Cart;
import Technical.perseo.model.Course;
import Technical.perseo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICartRepocitory extends CrudRepository<Cart, Long> {
    List<Cart> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
