package uz.pdp.jonibek.ussd_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.pdp.jonibek.ussd_app.payload.ApiResponse;
import uz.pdp.jonibek.ussd_app.payload.ClientDto;
import uz.pdp.jonibek.ussd_app.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/buySimCard")
    public HttpEntity<?> buySimCard(@RequestBody ClientDto clientDto) {
        ApiResponse response = clientService.buySimcard(clientDto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

}
