package tn.iit.medicalfile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private long id;
    private long cin;
    private String name;
    private Date birthday;



    public PatientDto(long id)
    {
        this.id=id;
    }

}
