package uz.pdp.jonibek.ussd_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.jonibek.ussd_app.entity.*;

import uz.pdp.jonibek.ussd_app.entity.enums.ClientType;
import uz.pdp.jonibek.ussd_app.entity.enums.RoleName;
import uz.pdp.jonibek.ussd_app.payload.ApiResponse;
import uz.pdp.jonibek.ussd_app.payload.ClientDto;
import uz.pdp.jonibek.ussd_app.repository.ClientRepository;
import uz.pdp.jonibek.ussd_app.repository.RoleRepository;
import uz.pdp.jonibek.ussd_app.repository.SimcardRepository;
import uz.pdp.jonibek.ussd_app.repository.TariffRepository;

import javax.management.relation.Role;
import java.util.Collections;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TariffRepository tariffRepository;

    @Autowired
    SimcardRepository simcardRepository;

    public ApiResponse buySimcard(ClientDto clientDto) {

        boolean existsByPassportNumber = clientRepository.existsByPassportNumber(clientDto.getPassportNumber());

        Client client = new Client();
        if (existsByPassportNumber) {

            Optional<Client> byPassportNumber = clientRepository.findByPassportNumber(clientDto.getPassportNumber());

            client = byPassportNumber.get();

        } else {
            //mijoz 1-marta

            client.setPassportNumber(clientDto.getPassportNumber());
            if (clientDto.getClientTypeOrdinal() == 1) {
                client.setClientType(ClientType.JISMONIY);
            } else if (clientDto.getClientTypeOrdinal() == 2) {
                client.setClientType(ClientType.YURIDIK);
            } else {
                return new ApiResponse("Client type notogri keldi!", false);
            }

            client.setFullName(clientDto.getFullName());

            Role byRoleName = roleRepository.findByRoleName(RoleName.ROLE_CLIENT);
            client.setRoles(Collections.singleton(byRoleName));

        }

        Optional<Tariff> optionalTariff = tariffRepository.findById(clientDto.getBuyingSimCardDto().getTariffId());

        if (!optionalTariff.isPresent()) return new ApiResponse("Tariff not found!", false);
        Tariff tariff = optionalTariff.get();

        Optional<SimCard> optionalSimCard = simcardRepository.findByCodeAndNumber(clientDto.getBuyingSimCardDto().getCode(), clientDto.getBuyingSimCardDto().getNumber());

        if (!optionalSimCard.isPresent()) return new ApiResponse("Simcard not found!", false);
        SimCard simCard = optionalSimCard.get();

        //sim karta aktiv bo'lmasligi kk
        if (simCard.isActive()) return new ApiResponse("Simcard already bought", false);

        simCard.setActive(true);
        simCard.setTariff(tariff);
        simCard.setClient(client);
        simCard.setBalance(clientDto.getBuyingSimCardDto().getSum());


        simcardRepository.save(simCard);
        //mana shu joyda simcardga min sms mb qancha borligini field
        clientRepository.save(client);
//        client.setSimCardList(Collections.singletonList(simCard));
//        clientRepository.save(client);
        return new ApiResponse("simcard rasmiylashdi!", true);

    }
}
