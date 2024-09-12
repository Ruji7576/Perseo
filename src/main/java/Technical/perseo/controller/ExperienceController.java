package Technical.perseo.controller;

import Technical.perseo.model.Cart;
import Technical.perseo.model.Experience;
import Technical.perseo.service.CartService;
import Technical.perseo.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping(path = "/getById/{id}")
    public Experience getById(@PathVariable Long id) {
        return experienceService.getById(id);
    }
    @GetMapping
    public List<Experience> getAllCarts() {
        return experienceService.getAllExperience();
    }
    @GetMapping(path = "/getAllBy/{user_id}")
    public List<Experience> getAllByUserId(@PathVariable Long user_id) {
        return experienceService.getAllByUserId(user_id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCart(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
    @PutMapping(path = "/update/{id}")
    public Experience updateCart(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }
    @PostMapping(path = "/create")
    public Experience createCourse(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }
}

