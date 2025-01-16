package ma.enset.tahasouhailmanna.services;

import ma.enset.tahasouhailmanna.client.PersonRestClient;
import ma.enset.tahasouhailmanna.entities.Reservation;
import ma.enset.tahasouhailmanna.repositories.ReservationRepository;
import ma.enset.tahasouhailmanna.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;  // Repository pour gérer les réservations

    @Autowired
    private PersonRestClient personClient;  // Client Feign pour obtenir les informations de la personne

    public Reservation getReservationWithPerson(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null) {
            Person person = personClient.getPersonById(reservation.getPersonId());  // Appel au microservice Person
            reservation.setPerson(person);  // Ajouter les détails de la personne à la réservation
        }
        return reservation;
    }
}
