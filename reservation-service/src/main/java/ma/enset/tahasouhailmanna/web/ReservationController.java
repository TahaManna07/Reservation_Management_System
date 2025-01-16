package ma.enset.tahasouhailmanna.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.enset.tahasouhailmanna.client.PersonRestClient;
import ma.enset.tahasouhailmanna.client.RessourceRestClient;
import ma.enset.tahasouhailmanna.entities.Reservation;
import ma.enset.tahasouhailmanna.model.Person;
import ma.enset.tahasouhailmanna.model.Resource;
import ma.enset.tahasouhailmanna.repositories.ReservationRepository;
import ma.enset.tahasouhailmanna.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationRepository reservationRepository;

    private PersonRestClient personClient;
    private ReservationService reservationService;
    private PersonRestClient personRestClient;
    private RessourceRestClient ressourceRestClient;



//    @GetMapping
//    public List<Reservation> getAllReservationsWithPersons() {
//        List<Reservation> reservations = reservationRepository.findAll();
//
//        // Récupérer la Person associée à chaque réservation
//        for (Reservation reservation : reservations) {
//            if (reservation.getPerson() == null && reservation.getPersonId() != null) {
//                Person person = personRestClient.getPersonById(reservation.getPersonId());
//                reservation.setPerson(person); // Assigner la personne à la réservation
//            }
//        }
//
//        return reservations;
//    }
@GetMapping
public List<Reservation> getAllReservationsWithPersonsAndRessources() {
    List<Reservation> reservations = reservationRepository.findAll();

    // Pour chaque réservation, récupérez la personne et la ressource associées
    for (Reservation reservation : reservations) {
        if (reservation.getPersonId() != null) {
            Person person = personRestClient.getPersonById(reservation.getPersonId());
            reservation.setPerson(person);
        }
        if (reservation.getRessourceId() != null) {
            Resource ressource = ressourceRestClient.getRessourceById(reservation.getRessourceId());
            reservation.setRessource(ressource);
        }
    }

    return reservations;
}

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservationWithPerson(id);
    }

}
