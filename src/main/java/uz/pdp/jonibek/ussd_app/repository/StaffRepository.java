package uz.pdp.jonibek.ussd_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.Staff;

import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {
    Optional<Staff> findByUserName(String username);

    boolean existsByUserName(String username);
}
