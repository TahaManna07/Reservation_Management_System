package ma.enset.tahasouhailmanna.repositories;

import ma.enset.tahasouhailmanna.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByPersonId(Long personId);  // Assurez-vous que la colonne "personId" existe dans la table "reservations"

}
