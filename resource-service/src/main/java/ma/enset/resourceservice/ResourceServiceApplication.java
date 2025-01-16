package ma.enset.resourceservice;

import ma.enset.resourceservice.entities.Resource;
import ma.enset.resourceservice.enums.TypeMaterial;
import ma.enset.resourceservice.repositories.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ResourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ResourceRepository resourceRepository){
        return args -> {
            Resource resource1= Resource.builder()
                    .name("Ressource 1 ")
                    .type(TypeMaterial.MATERIEL_AUDIO_VUSUEL)
                    .build();
            Resource resource2= Resource.builder()
                    .name("Ressource 2 ")
                    .type(TypeMaterial.MATERIEL_INF0)
                    .build();

            Resource resource3= Resource.builder()
                    .name("Ressource  ")
                    .type(TypeMaterial.MATERIEL_AUDIO_VUSUEL)
                    .build();

            resourceRepository.save(resource1);
            resourceRepository.save(resource2);
            resourceRepository.save(resource3);



        };
    }

}
