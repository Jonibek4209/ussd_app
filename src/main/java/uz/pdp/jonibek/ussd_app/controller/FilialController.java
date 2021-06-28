package uz.pdp.jonibek.ussd_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.jonibek.ussd_app.service.FilialService;

@RestController
@RequestMapping("/api/filial")
public class FilialController {
    @Autowired
    FilialService filialService;

    //filial qo'shish
//    @PreAuthorize(value = "hasAnyRole('ROLE_MANAGER')")
//    @PostMapping
//    public HttpEntity<?> addFilial(@RequestBody FilialDto filialDto) {
//        ApiResponse response = filialService.addFilial(filialDto);
//
//        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
//    }
}
