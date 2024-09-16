package Technical.perseo.controller;

import Technical.perseo.model.Cart;
import Technical.perseo.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

class CartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartController)
                .build();
        objectMapper = new ObjectMapper();
    }

    // ... (інші тести залишаються без змін)

    @Test
    void testUpdateCart() throws Exception {
        Long id = 1L;
        Cart newCart = new Cart();
        newCart.setId(id);
        // Додайте інші необхідні поля до newCart

        when(cartService.updateCart(eq(id), any(Cart.class))).thenReturn(newCart);

        mockMvc.perform(put("/api/cart/update/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCart)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id));

        verify(cartService, times(1)).updateCart(eq(id), any(Cart.class));
    }

    @Test
    void testCreateCart() throws Exception {
        Cart newCart = new Cart();
        newCart.setId(1L);
        // Додайте інші необхідні поля до newCart

        when(cartService.createCart(any(Cart.class))).thenReturn(newCart);

        mockMvc.perform(post("/api/cart/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCart)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L));

        verify(cartService, times(1)).createCart(any(Cart.class));
    }
}