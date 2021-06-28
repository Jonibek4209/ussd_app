package uz.pdp.jonibek.ussd_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.EntertainingService;

import java.util.UUID;

public interface EntertainingServiceRepository extends JpaRepository<EntertainingService, UUID> {
    boolean existsByName(String name);
}
