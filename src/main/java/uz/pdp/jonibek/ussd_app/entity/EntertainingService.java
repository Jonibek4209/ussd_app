package uz.pdp.jonibek.ussd_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.jonibek.ussd_app.entity.enums.ServiceType;
import uz.pdp.jonibek.ussd_app.entity.template.AbsEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class EntertainingService extends AbsEntity {

    private String name;

    private double price;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ServiceCategory serviceCategory;

    private Timestamp expireDate;

    @ManyToMany
    private List<SimCard> simCardList;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;


}
