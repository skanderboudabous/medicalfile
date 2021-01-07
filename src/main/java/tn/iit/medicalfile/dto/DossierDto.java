package tn.iit.medicalfile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DossierDto {
    private long id;
    private long patientId;
    private String patientName;
    private Collection<TraitementDto> traitements;
    public DossierDto(Long id){
        this.id=id;
    }
}
