package uz.pdp.jonibek.ussd_app.payload;

import lombok.Data;
import uz.pdp.jonibek.ussd_app.payload.BuyingSimCardDto;

@Data
public class ClientDto {
    private String passportNumber;
    private String fullName;
    private Integer clientTypeOrdinal; //enum ordinal

    private BuyingSimCardDto buyingSimCardDto;
    //bir  nechta simkard olishni xoxlasa shu yerda bitta boshqa dto kk

}
