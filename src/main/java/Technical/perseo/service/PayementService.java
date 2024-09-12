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

import java.time.LocalDateTime;
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

    private class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }


    public List<Payement> buyCourse(Long user_id, Payement payement) {
        ArrayList<Payement> checksList = new ArrayList<>();
        List<UserDetails> userDetailsList = iUserDetailsRepository.findByUserId(user_id);

        UserDetails userData = userDetailsList.get(0);
        int userMoney = userData.getMoney();
        List<Cart> carts = iCartRepocitory.findByUserId(user_id);
        int sum = 0;

        for (Cart cart : carts) {
            sum += cart.getCourse().getCost();
        }

        if (userMoney >= sum) {
            for (Cart cart : carts) {
                Course course = cart.getCourse();
                Payement newPayement = new Payement(null, course.getCost(), "completed", LocalDateTime.now(), userData.getUser(), course);
                checksList.add(newPayement);
                iPayementRepository.save(newPayement);
            }
            iCartRepocitory.deleteByUserId(user_id);
            userMoney -= sum;
            userData.setMoney(userMoney);
            iUserDetailsRepository.save(userData);
            return checksList;
        } else {
            throw new InsufficientFundsException("You don't have enough money : " + user_id);
        }
    }


    public List<Payement> getAllByUserId(Long user_id) {
        return iPayementRepository.findByUserId(user_id);
    }
    public List<Payement> getAllPayements() {
        return (List<Payement>) iPayementRepository.findAll();
    }

    public void deletePayement(Long id) {
        iPayementRepository.deleteById(id);
    }
    public Payement updatePayement(Long id, Payement payement) {
        payement.setId(id);
        return iPayementRepository.save(payement);
    }
}
