package uz.pdp.jonibek.ussd_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.Payment;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    boolean findAllBySimCard_Client_FullName(String fullName);
}
