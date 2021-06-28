package uz.pdp.jonibek.ussd_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.jonibek.ussd_app.entity.ServiceCategory;

@RepositoryRestResource(path = "/serviceCategory")
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Integer> {
}
