package uz.pdp.jonibek.ussd_app.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.pdp.jonibek.ussd_app.entity.*;
import uz.pdp.jonibek.ussd_app.entity.enums.RoleName;
import uz.pdp.jonibek.ussd_app.payload.ApiResponse;
import uz.pdp.jonibek.ussd_app.payload.UssdCodeDTO;
import uz.pdp.jonibek.ussd_app.repository.StaffRepository;
import uz.pdp.jonibek.ussd_app.repository.USSDRepository;

import java.util.Optional;

@Service
public class UssdCodeService {
    @Autowired
    USSDRepository ussdRepository;

    @Autowired
    StaffRepository staffRepository;

    public ApiResponse addUssd(UssdCodeDTO ussdCodeDTO){
        Staff staff = (Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<Staff> optionalStaff = staffRepository.findById(staff.getId());
        if (!optionalStaff.isPresent()) return new ApiResponse("User is not found", false);
        Staff currentStaff = optionalStaff.get();

        if (currentStaff.getRoles().contains(new Role(2, RoleName.ROLE_MANAGER))
                ||currentStaff.getRoles().contains(new Role(1,RoleName.ROLE_DIRECTOR))){
            UssdCode ussdCode= new UssdCode();
            ussdCode.setCode(ussdCodeDTO.getCode());
            ussdCode.setDescription(ussdCodeDTO.getDescription());
            ussdRepository.save(ussdCode);
            return new ApiResponse("UssdCode is added successfully", true);
        }
        return new ApiResponse("You haven't got permission to add USSD CODE", false);

    }

}
