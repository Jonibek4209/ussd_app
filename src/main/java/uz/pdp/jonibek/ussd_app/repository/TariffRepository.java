package uz.pdp.jonibek.ussd_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.Tariff;

import java.util.UUID;

public interface TariffRepository extends JpaRepository<Tariff, UUID> {
    
}
