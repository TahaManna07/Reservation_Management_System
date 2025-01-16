package ma.enset.resourceservice.services;


import ma.enset.resourceservice.entities.Resource;
import ma.enset.resourceservice.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RessourceService {

    private final ResourceRepository ressourceRepository;

    public RessourceService(ResourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    public Resource saveRessource(Resource ressource) {
        return ressourceRepository.save(ressource);
    }

    public List<Resource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    public Optional<Resource> getRessourceById(Long id) {
        return ressourceRepository.findById(id);
    }
}
