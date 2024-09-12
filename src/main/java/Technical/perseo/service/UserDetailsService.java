package Technical.perseo.service;

import Technical.perseo.model.Cart;
import Technical.perseo.model.UserDetails;
import Technical.perseo.repository.ICartRepocitory;
import Technical.perseo.repository.IUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    IUserDetailsRepository iUserDetailsRepository;

    public List<UserDetails> getAllByUserId(Long user_id) {
        return iUserDetailsRepository.findByUserId(user_id);
    }
    public List<UserDetails> getAllUserDetails() {
        return (List<UserDetails>) iUserDetailsRepository.findAll();
    }
    public UserDetails getById(Long id) {
        return iUserDetailsRepository.findById(id).orElseThrow();
    }
    public void deleteUserDetails(Long id) {
        iUserDetailsRepository.deleteById(id);
    }
    public UserDetails updateUserDetails(Long id, UserDetails userDetails) {
        userDetails.setId(id);
        return iUserDetailsRepository.save(userDetails);
    }
    public UserDetails createUserDetails(UserDetails userDetails) {
        return iUserDetailsRepository.save(userDetails);
    }
}
