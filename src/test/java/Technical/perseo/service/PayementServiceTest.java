package Technical.perseo.service;

import Technical.perseo.model.*;
import Technical.perseo.repository.ICartRepocitory;
import Technical.perseo.repository.IPayementRepository;
import Technical.perseo.repository.IUserDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PayementServiceTest {

    @InjectMocks
    private PayementService payementService;

    @Mock
    private IPayementRepository iPayementRepository;

    @Mock
    private IUserDetailsRepository iUserDetailsRepository;

    @Mock
    private ICartRepocitory iCartRepocitory;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buyCourse() {
        User user = new User(1L, "ivan432", null, null, null, null, null, null, null, null);
        UserDetails userDetails = new UserDetails(1L, "Ivan", "Shevchenko", "USA", null, 600, null);
        Course course = new Course(1L, "Digital", "none", "Master", 320, "IT", 100, null, null, null, null);
        Course secondCourse = new Course(1L, "ID", "none", "Beginner", 320, "IT", 120, null, null, null, null);
        Cart cart = new Cart(1L, user, course);
        Cart cart1 = new Cart(1L, user, secondCourse);

        List<UserDetails> userDetailsList = List.of(userDetails);
        List<Cart> carts = List.of(cart, cart1);

        when(iUserDetailsRepository.findByUserId(1L)).thenReturn(userDetailsList);
        when(iCartRepocitory.findByUserId(1L)).thenReturn(carts);
        when(iPayementRepository.save(any(Payement.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Payement initialPayement = new Payement(1L, 0, null, null, null, null);
        List<Payement> result = payementService.buyCourse(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getSum());
        assertEquals(course, result.get(0).getCourse());
        assertEquals(380, userDetails.getMoney());

        verify(iUserDetailsRepository, times(1)).findByUserId(1L);
        verify(iCartRepocitory, times(1)).findByUserId(1L);
        verify(iPayementRepository, times(2)).save(any(Payement.class));
        verify(iCartRepocitory, times(1)).deleteByUserId(1L);
        verify(iUserDetailsRepository, times(1)).save(userDetails);
    }

    @Test
    void getAllByUserId() {
    }

    @Test
    void getAllPayements() {
    }

    @Test
    void deletePayement() {
    }

    @Test
    void updatePayement() {
    }
}