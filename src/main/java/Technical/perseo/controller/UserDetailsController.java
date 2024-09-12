package Technical.perseo.controller;

import Technical.perseo.model.Cart;
import Technical.perseo.model.UserDetails;
import Technical.perseo.service.CartService;
import Technical.perseo.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping(path = "/getById/{id}")
    public UserDetails getById(@PathVariable Long id) {
        return userDetailsService.getById(id);
    }
    @GetMapping
    public List<UserDetails> getAllUserDetails() {
        return userDetailsService.getAllUserDetails();
    }

    @GetMapping(path = "/getAllBy/{user_id}")
    public List<UserDetails> getAllByUserId(@PathVariable Long user_id) {
        return userDetailsService.getAllByUserId(user_id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteUserDetails(@PathVariable Long id) {
        userDetailsService.deleteUserDetails(id);
    }
    @PutMapping(path = "/update/{id}")
    public UserDetails updateUserDetails(@PathVariable Long id, @RequestBody UserDetails updateCart) {
        return userDetailsService.updateUserDetails(id, updateCart);
    }

    @PostMapping(path = "/create")
    public UserDetails createUserDetails(@RequestBody UserDetails updateCart) {
        return userDetailsService.createUserDetails(updateCart);
    }
}
