package Technical.perseo.controller;


import Technical.perseo.model.Cart;
import Technical.perseo.model.Course;
import Technical.perseo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping(path = "/getById/{id}")
    public Cart getById(@PathVariable Long id) {
    return cartService.getById(id);
    }
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCart();
    }

    @GetMapping(path = "/getAllBy/{user_id}")
    public List<Cart> getAllByUserId(@PathVariable Long user_id) {
        return cartService.getAllByUserId(user_id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
    @PutMapping(path = "/update/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart newCourse) {
        return cartService.updateCart(id, newCourse);
    }

    @PostMapping(path = "/create")
    public Cart createCourse(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }
}
