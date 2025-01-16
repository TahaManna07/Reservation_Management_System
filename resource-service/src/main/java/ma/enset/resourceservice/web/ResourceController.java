package ma.enset.resourceservice.web;

import ma.enset.resourceservice.entities.Resource;
import ma.enset.resourceservice.repositories.ResourceRepository;
import ma.enset.resourceservice.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private RessourceService resourceService;
    @Autowired
    private ResourceRepository resourceRepository;

    @PostMapping("/resources/add")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.saveRessource(resource);
    }

    @GetMapping("/resources")
    public List<Resource> allResources(){
        return resourceRepository.findAll();
    }
    @GetMapping("/resources/{id}")
    Resource getRessourceById(@PathVariable("id") Long id){
        return resourceRepository.findById(id).orElse(null);

    }


}