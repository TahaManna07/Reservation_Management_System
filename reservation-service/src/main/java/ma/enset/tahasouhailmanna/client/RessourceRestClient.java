package ma.enset.tahasouhailmanna.client;

import ma.enset.tahasouhailmanna.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "resource-service", url = "http://localhost:8081/api/resources") // URL du microservice Ressource

public interface RessourceRestClient {
    @GetMapping("/{id}")
    Resource getRessourceById(@PathVariable("id") Long id);
}
