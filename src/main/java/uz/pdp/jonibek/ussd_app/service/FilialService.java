package uz.pdp.jonibek.ussd_app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.jonibek.ussd_app.repository.FilialRepository;
import uz.pdp.jonibek.ussd_app.repository.StaffRepository;

import java.util.*;

@Service
public class FilialService {

    @Autowired
    FilialRepository filialRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    StaffRepository staffRepository;

//    public ApiResponse addFilial(FilialDto filialDto) {
//
//        Staff user = (Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//
//        Filial filial = new Filial();
//        filial.setName(filialDto.getName());
//
//        //shu filialni directori
//        Staff staff = new Staff();
//        staff.setUserName(filialDto.getStaffDto().getUserName());
//        staff.setFullName(filialDto.getStaffDto().getFullName());
//        Set<Role> roleSet = new HashSet<>();
//        Role role = new Role(1, RoleName.ROLE_DIRECTOR);
//        roleSet.add(role);
//        staff.setRoles(roleSet);
//
//        staff.setPosition(filialDto.getStaffDto().getPosition());
//        staff.setFilial(filial);
//        staff.setPassword(passwordEncoder.encode(filialDto.getStaffDto().getPassword()));
//        staffRepository.save(staff);
//        filial.setDirector(staff);
//
//        List<Staff> staffList = new ArrayList<>();
//
//        if (filialDto.getStaffUsernames() != null) {
//            for (String staffUsername : filialDto.getStaffUsernames()) {
//
//                Optional<Staff> optionalStaff = staffRepository.findByUserName(staffUsername);
//                if (!optionalStaff.isPresent()) {
//                    return new ApiResponse("Staff yoqku?", false);
//                }
//                staffList.add(optionalStaff.get());
//            }
//        }
//        filial.setStaffList(staffList);
//        filialRepository.save(filial);
//        return new ApiResponse("Filial added!", true);
//    }

}
