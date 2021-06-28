package uz.pdp.jonibek.ussd_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.jonibek.ussd_app.payload.ApiResponse;
import uz.pdp.jonibek.ussd_app.payload.UssdCodeDTO;
import uz.pdp.jonibek.ussd_app.service.UssdCodeService;

@RestController
@RequestMapping("/ussd")
public class UssdController {
    @Autowired
    UssdCodeService ussdCodeService;

    @PostMapping
    public HttpEntity<?> addUssd(@RequestBody UssdCodeDTO ussdCodeDTO){
        ApiResponse response = ussdCodeService.addUssd(ussdCodeDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }
}
