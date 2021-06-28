package uz.pdp.jonibek.ussd_app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.jonibek.ussd_app.entity.enums.ClientType;
import uz.pdp.jonibek.ussd_app.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbsEntity {

    private String passportNumber;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @ManyToMany
    private Set<Role> roles;

    private String password;

    //client bir nechta simkartaga ega bo'lasz?
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    @JsonManagedReference
    private List<SimCard> simCardList;


}
