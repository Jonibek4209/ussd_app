package uz.pdp.jonibek.ussd_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsByPassportNumber(String passportNumber);

    Optional<Client> findByPassportNumber(String number);

}
