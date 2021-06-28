package uz.pdp.jonibek.ussd_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.SimCard;

import java.util.Optional;
import java.util.UUID;

public interface SimcardRepository extends JpaRepository<SimCard, UUID> {

    Optional<SimCard> findByCodeAndNumber(String code, String number);

    Optional<SimCard> findBySimCardNumber(String simcardNumber);


}
