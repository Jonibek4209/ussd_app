package uz.pdp.jonibek.ussd_app.payload;

import lombok.Data;
import uz.pdp.jonibek.ussd_app.entity.enums.PayType;

import java.util.UUID;

@Data
public class PaymentDto {
    private PayType payType;
    private double amount;

    private String payerName;

    private String payerId;
    private UUID simCardID;

}
