package uz.pdp.jonibek.ussd_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.UssdCode;

import java.util.UUID;

public interface USSDRepository extends JpaRepository<UssdCode, UUID> {


}
