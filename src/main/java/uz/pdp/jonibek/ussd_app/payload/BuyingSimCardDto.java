package uz.pdp.jonibek.ussd_app.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class BuyingSimCardDto {
    private String code;
    private String number;
    private double sum;
    private UUID tariffId;
}
