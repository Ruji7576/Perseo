package Technical.perseo.service;

import Technical.perseo.model.Cart;
import Technical.perseo.model.Course;
import Technical.perseo.model.Payement;
import Technical.perseo.model.UserDetails;
import Technical.perseo.repository.ICartRepocitory;
import Technical.perseo.repository.IPayementRepository;
import Technical.perseo.repository.IUserDetailsRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PayementService {

    @Autowired
    IPayementRepository iPayementRepository;

    @Autowired
    IUserDetailsRepository iUserDetailsRepository;

    @Autowired
    ICartRepocitory iCartRepocitory;

    @Autowired
    UserDetails userDetails;

    private class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }


    public List<Payement> buyCourse(Long user_id, Payement payement) {
        ArrayList<Payement> checksList = new ArrayList<>();
        Optional<UserDetails> optionalUserData = iUserDetailsRepository.findById(user_id);
        int userMoney = optionalUserData.get().getMoney();
        List<Cart> carts = iCartRepocitory.findByUserId(user_id);
        int sum = 0;

        for (Cart cart : carts) {
            sum += cart.getCourse().getCost();
        }

        if (userMoney >= sum) {
            for (Cart cart : carts) {
                Course course = cart.getCourse();
                payement.setCourse(course);
                checksList.add(payement);
                iPayementRepository.save(payement);
            }
            iCartRepocitory.deleteByUserId(user_id);
            return checksList;
        } else {
            throw new InsufficientFundsException("Insufficient funds for user id: " + user_id);
        }
    }
}
