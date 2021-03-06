package uz.pdp.jonibek.ussd_app.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.pdp.jonibek.ussd_app.entity.*;


import uz.pdp.jonibek.ussd_app.entity.enums.RoleName;
import uz.pdp.jonibek.ussd_app.payload.ApiResponse;
import uz.pdp.jonibek.ussd_app.payload.PaymentDto;
import uz.pdp.jonibek.ussd_app.repository.PaymentRepository;
import uz.pdp.jonibek.ussd_app.repository.SimcardRepository;
import uz.pdp.jonibek.ussd_app.repository.StaffRepository;

import java.util.Optional;


@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    SimcardRepository simcardRepository;
    @Autowired
    StaffRepository staffRepository;

    public ApiResponse addPayment(PaymentDto paymentDto) {
        Optional<SimCard> byId = simcardRepository.findById(paymentDto.getSimCardID());
        if (!byId.isPresent()) {
            return new ApiResponse("uxladiz. yo'q nomerga pul tawladingiz ))", false);
        }
        SimCard simCard = byId.get();

        Payment payment = new Payment();
        payment.setPayerId(payment.getPayerId());
        payment.setPayerName(payment.getPayerName());
        payment.setPayType(payment.getPayType());

        payment.setAmount(payment.getAmount());
        simCard.setBalance(simCard.getBalance() + payment.getAmount());
        payment.setSimCard(simCard);
        simcardRepository.save(simCard);
        paymentRepository.save(payment);


        

        return new ApiResponse("to'lov qabbul qilindi", true, payment);
    }

    public ApiResponse getPayment() {
        Staff staff = (Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Staff> optionalStaff = staffRepository.findById(staff.getId());

        if (!optionalStaff.isPresent()) return new ApiResponse("User is not found", false);
        Staff currentStaff = optionalStaff.get();

        if (currentStaff.getRoles().contains(new Role(4, RoleName.ROLE_CLIENT))) {

            return new ApiResponse("mana to'lovlaringiz",true,
                    paymentRepository.findAllBySimCard_Client_FullName(staff.getFullName()));




        }
        else{
            return new ApiResponse("mana to'lovlaringiz",true,
                    paymentRepository.findAll());
        }
    }
}
