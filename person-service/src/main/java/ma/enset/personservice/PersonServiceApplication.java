package ma.enset.personservice;

import ma.enset.personservice.entities.Person;
import ma.enset.personservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PersonServiceApplication {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }

    // CommandLineRunner pour insérer des données de personnes dans la base de données au démarrage
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Person person1 = Person.builder()
                    .phone("0655")
                    .firstName("taha")
                    .lastName("manna")
                    .email("@gmail.com")
                    .build();
            Person person2 = Person.builder()
                    .phone("0655")
                    .firstName("souhail")
                    .lastName("manna")
                    .email("@gmail.com")
                    .build();
            // Ajouter quelques personnes dans la base de donnéesPerson person1 = new Person("John", "Doe", "john.doe@example.com", "1234567890");

            // Sauvegarder les personnes dans la base de données
            personRepository.save(person1);
            personRepository.save(person2);

            System.out.println("Personnes ajoutées à la base de données");
        };
    }
}
