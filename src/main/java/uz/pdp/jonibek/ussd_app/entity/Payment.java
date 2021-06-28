package uz.pdp.jonibek.ussd_app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.jonibek.ussd_app.entity.enums.PayType;
import uz.pdp.jonibek.ussd_app.entity.template.AbsEntity;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends AbsEntity {

    @ManyToOne
    private SimCard simCard;

    @Enumerated(EnumType.STRING)
    private PayType payType;

    private double amount;

    private String payerName;

    private String payerId;
    //chek nomeri
}
