package uz.pdp.jonibek.ussd_app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.jonibek.ussd_app.entity.enums.ActionType;
import uz.pdp.jonibek.ussd_app.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details extends AbsEntity {

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @ManyToOne
    private SimCard simCard;

    //ayni vaqtda qancha sarfladi! //8 min
    private double amount;


}
