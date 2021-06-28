package uz.pdp.jonibek.ussd_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.jonibek.ussd_app.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tariff extends AbsEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private double price; //tariff narxi 70000

    private double switchPrice; //o'tish narxi 2500

    private Timestamp expireDate;


    //tarif ichidagi
    private int mb; //tarif rejasi doirasida mb
    private int sms;
    private int min;

    private int mbCost; //mb tugaganda 1mb narxi
    private int smsCost; //sms tugaganda 1sms narxi
    private int minCost; //daqiqa tugaganda 1daq narxi


//    @Enumerated(EnumType.STRING)
//    private ClientType clientType;


}
