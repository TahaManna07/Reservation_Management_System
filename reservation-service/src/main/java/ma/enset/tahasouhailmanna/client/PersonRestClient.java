package ma.enset.tahasouhailmanna.client;

import ma.enset.tahasouhailmanna.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Définir le client Feign pour interagir avec le service des personnes
@FeignClient(name = "person-service", url = "http://localhost:8082/persons")  // Assurez-vous que l'URL est correcte pour votre service
public interface PersonRestClient {

    // Récupérer les détails d'une personne par son ID
    @GetMapping("/{id}")
    Person getPersonById(@PathVariable Long id);
}
