package ma.enset.tahasouhailmanna;

import ma.enset.tahasouhailmanna.client.PersonRestClient;
import ma.enset.tahasouhailmanna.client.RessourceRestClient;
import ma.enset.tahasouhailmanna.entities.Reservation;
import ma.enset.tahasouhailmanna.model.Person;
import ma.enset.tahasouhailmanna.model.Resource;
import ma.enset.tahasouhailmanna.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableFeignClients

public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ReservationRepository reservationRepository,
                                               PersonRestClient personRestClient,
                                               RessourceRestClient ressourceRestClient) {
        return args -> {

            Long personId = 1L;
            Long personId1 = 2L;

            Long ressourceId = 1L; // ID de la ressource
            Long ressourceId1 = 2L; // ID de la ressource


            Person person = personRestClient.getPersonById(personId);
            Person person1 = personRestClient.getPersonById(personId1);
            Resource ressource = ressourceRestClient.getRessourceById(ressourceId);
            Resource ressource1 = ressourceRestClient.getRessourceById(ressourceId1);

            System.out.println("*****************************");
            System.out.println("voici : "+person);
            System.out.println("voici : "+person1);
            System.out.println("*****************************");


            // Si la personne existe, créez la réservation
            if (person != null && person1 !=null) {
                // Créer une réservation en utilisant l'ID de la personne
                Reservation reservation = new Reservation();
                reservation.setName("Réservation de salle A");
                reservation.setContext("Réunion d'équipe");
                reservation.setDate(LocalDateTime.now().plusDays(1));
                reservation.setDuration(2); // 2 heures
                reservation.setPersonId(person.getId());
                reservation.setRessourceId(ressource.getId());

                Reservation reservation1 = new Reservation();
                reservation1.setName("Réservation de salle B");
                reservation1.setContext("Réunion B");
                reservation1.setDate(LocalDateTime.now().plusDays(1));
                reservation1.setDuration(1); // 1 heure
                reservation1.setPersonId(person1.getId());
                reservation1.setRessourceId(ressource1.getId());

                // Enregistrer la réservation
                reservationRepository.save(reservation);
                reservationRepository.save(reservation1);


                // Log pour confirmer
                System.out.println("Réservation ajoutée avec succès pour la personne " + person.getFirstName());
            } else {
                System.out.println("Personne non trouvée pour l'ID " + personId);
            }
        };
    }




}
