package ma.enset.personservice.clients;

import ma.enset.personservice.dtos.ReservationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "reservation-service", url = "http://localhost:8083/api/reservations")
public interface ReservationFeignClient {

    @GetMapping("/person/{id}")
    List<ReservationResponse> getReservationsByPersonId(@PathVariable("id") Long id);  // Méthode pour obtenir les réservations par ID de personne
}

