package Technical.perseo.controller;

import Technical.perseo.model.Payement;
import Technical.perseo.service.PayementService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payement")
public class PayementController {

    @Autowired
    PayementService payementService;

    @PostMapping(path = "/buy/{user_id}")
    public List<Payement> buyCourse(@PathVariable Long user_id, @RequestBody Payement payement) {
        return payementService.buyCourse(user_id,payement);
    }
}
