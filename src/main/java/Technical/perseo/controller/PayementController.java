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

    @GetMapping(path = "/getAll")
    public List<Payement> getAllPayement() {
        return payementService.getAllPayements();
    }
    @GetMapping(path = "/getAll/{user_id}")
    public List<Payement> getAllByUserId(@PathVariable Long user_id) {
        return payementService.getAllByUserId(user_id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        payementService.deletePayement(id);
    }
    @PutMapping(path = "/update/{id}")
    public Payement updatePayement(@PathVariable Long id, @RequestBody Payement payement) {
        return payementService.updatePayement(id, payement);
    }
}
