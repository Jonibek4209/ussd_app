package uz.pdp.jonibek.ussd_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.jonibek.ussd_app.entity.Filial;

import java.util.UUID;

@Repository
public interface FilialRepository extends JpaRepository<Filial, UUID> {

}
