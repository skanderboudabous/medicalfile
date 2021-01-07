package tn.iit.medicalfile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TraitementDto {

    private long id;
    private long dossierId;
    private String medicamentName;
    private float medicamentDosage;
    private float medicamentPrice;
    private long medicamentId;
}
