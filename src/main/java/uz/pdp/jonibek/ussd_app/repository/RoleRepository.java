package uz.pdp.jonibek.ussd_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.jonibek.ussd_app.entity.enums.RoleName;

import javax.management.relation.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);
}
