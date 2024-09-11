package Technical.perseo.service;

import Technical.perseo.model.Cart;
import Technical.perseo.repository.ICartRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    ICartRepocitory iCartRepocitory;

    public List<Cart> getAllByUserId(Long user_id) {
        return iCartRepocitory.findByUserId(user_id);
    }
    public List<Cart> getAllCart() {
        return (List<Cart>) iCartRepocitory.findAll();
    }
    public Cart getById(Long id) {
        return iCartRepocitory.findById(id).orElseThrow();
    }
    public void deleteCart(Long id) {
        iCartRepocitory.deleteById(id);
    }
    public Cart updateCart(Long id, Cart newCart) {
        newCart.setId(id);
        return iCartRepocitory.save(newCart);
    }
    public Cart createCart(Cart cart) {
        return iCartRepocitory.save(cart);
    }

}
