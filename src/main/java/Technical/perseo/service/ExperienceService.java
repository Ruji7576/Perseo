package Technical.perseo.service;

import Technical.perseo.model.Cart;
import Technical.perseo.model.Experience;
import Technical.perseo.repository.IExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    IExperienceRepository iExperienceRepository;

    public List<Experience> getAllByUserId(Long user_id) {
        return iExperienceRepository.findByUserId(user_id);
    }
    public List<Experience> getAllExperience() {
        return (List<Experience>) iExperienceRepository.findAll();
    }
    public Experience getById(Long id) {
        return iExperienceRepository.findById(id).orElseThrow();
    }
    public void deleteExperience(Long id) {
        iExperienceRepository.deleteById(id);
    }
    public Experience updateExperience(Long id, Experience newExperience) {
        newExperience.setId(id);
        return iExperienceRepository.save(newExperience);
    }
    public Experience createExperience(Experience experience) {
        return iExperienceRepository.save(experience);
    }
}
