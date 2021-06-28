package uz.pdp.jonibek.ussd_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.pdp.jonibek.ussd_app.entity.*;


import uz.pdp.jonibek.ussd_app.entity.enums.RoleName;
import uz.pdp.jonibek.ussd_app.entity.enums.ServiceType;
import uz.pdp.jonibek.ussd_app.payload.ApiResponse;
import uz.pdp.jonibek.ussd_app.payload.EntertainingServiceDTO;
import uz.pdp.jonibek.ussd_app.repository.EntertainingServiceRepository;
import uz.pdp.jonibek.ussd_app.repository.ServiceCategoryRepository;
import uz.pdp.jonibek.ussd_app.repository.StaffRepository;

import javax.management.relation.Role;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class EntertainingServiceService {
    @Autowired
    EntertainingServiceRepository entertainingServiceRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    StaffRepository staffRepository;

    public ApiResponse addEnterService(EntertainingServiceDTO entertainingServiceDTO) {
        Staff staff = (Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<Staff> optionalStaff = staffRepository.findById(staff.getId());
        if (!optionalStaff.isPresent()) return new ApiResponse("User is not found", false);
        Staff currentStaff = optionalStaff.get();

        if (currentStaff.getRoles().contains(new Role(2, RoleName.ROLE_MANAGER))
                || currentStaff.getRoles().contains(new Role(1, RoleName.ROLE_DIRECTOR))) {
            if (entertainingServiceRepository.existsByName(entertainingServiceDTO.getName()))
                return new ApiResponse("E.S. is already exist", false);

            EntertainingService entertainingService = new EntertainingService();

            entertainingService.setName(entertainingServiceDTO.getName());
            entertainingService.setPrice(entertainingServiceDTO.getPrice());

            switch (entertainingServiceDTO.getServiceTypeNumber()) {
                case 1:
                    entertainingService.setServiceType(ServiceType.OVOZLI);
                    break;
                case 2:
                    entertainingService.setServiceType(ServiceType.MB);
                    break;
                case 3:
                    entertainingService.setServiceType(ServiceType.SMS);
                    break;
                default:
                    return new ApiResponse("Bunaqa TYPE yo'q,",false);
            }

            Optional<ServiceCategory> optionalServiceCategory = serviceCategoryRepository.findById(entertainingServiceDTO.getServiceCategoryId());
            if (!optionalServiceCategory.isPresent()) return new ApiResponse("Service category Id is not found", false);

            entertainingService.setServiceCategory(optionalServiceCategory.get());
            entertainingService.setExpireDate(new Timestamp(System.currentTimeMillis()+60*60*1000*24*7));

            entertainingServiceRepository.save(entertainingService);
            return new ApiResponse("Entertaining Service is added successfully", true);
        }
        return new ApiResponse("You haven't got permission to add USSD CODE", false);
    }
}
