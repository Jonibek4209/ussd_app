package uz.pdp.jonibek.ussd_app.payload;

import lombok.Data;

import java.util.List;

@Data
public class FilialDto {

    private String name;

    private StaffDto staffDto;

    private List<String> staffUsernames;


}
