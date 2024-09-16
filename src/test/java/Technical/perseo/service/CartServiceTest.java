package Technical.perseo.service;

import Technical.perseo.model.Cart;
import Technical.perseo.repository.ICartRepocitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private ICartRepocitory iCartRepocitory;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllByUserId() {
        Long userId = 1L;
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(1L, null, null));
        when(iCartRepocitory.findByUserId(userId)).thenReturn(carts);
        List<Cart> result = cartService.getAllByUserId(userId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
        verify(iCartRepocitory, times(1)).findByUserId(userId);
    }

    @Test
    void getAllCart() {
        // Given
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(1L, null, null));
        carts.add(new Cart(2L, null, null));
        when(iCartRepocitory.findAll()).thenReturn(carts);

        // When
        List<Cart> result = cartService.getAllCart();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        verify(iCartRepocitory, times(1)).findAll();
    }

    @Test
    void getById() {
        // Given
        Long cartId = 1L;
        Cart cart = new Cart(cartId, null, null);
        when(iCartRepocitory.findById(cartId)).thenReturn(Optional.of(cart));

        // When
        Cart result = cartService.getById(cartId);

        // Then
        assertNotNull(result);
        assertEquals(cartId, result.getId());
        verify(iCartRepocitory, times(1)).findById(cartId);
    }

    @Test
    void deleteCart() {
        // Given
        Long cartId = 1L;
        doNothing().when(iCartRepocitory).deleteById(cartId);

        // When
        cartService.deleteCart(cartId);

        // Then
        verify(iCartRepocitory, times(1)).deleteById(cartId);
    }

    @Test
    void updateCart() {
        // Given
        Long cartId = 1L;
        Cart existingCart = new Cart(cartId, null, null);
        Cart updatedCart = new Cart(cartId, null, null);
        when(iCartRepocitory.save(updatedCart)).thenReturn(updatedCart);

        // When
        Cart result = cartService.updateCart(cartId, updatedCart);

        // Then
        assertNotNull(result);
        assertEquals(cartId, result.getId());
        verify(iCartRepocitory, times(1)).save(updatedCart);
    }

    @Test
    void createCart() {
        // Given
        Cart newCart = new Cart(null, null, null);
        when(iCartRepocitory.save(newCart)).thenAnswer(invocation -> {
            Cart cart = invocation.getArgument(0);
            cart.setId(1L); // Simulate an auto-generated ID
            return cart;
        });

        // When
        Cart result = cartService.createCart(newCart);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(iCartRepocitory, times(1)).save(newCart);
    }
}
