package uz.pdp.jonibek.ussd_app.payload;

import lombok.Data;

@Data
public class UssdCodeDTO {
    private String code;
    private String description;
}
