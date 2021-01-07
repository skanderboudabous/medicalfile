package tn.iit.medicalfile.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.medicalfile.dto.PatientDto;
import tn.iit.medicalfile.service.PatientService;


import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/patients")
@RestController()
public class PatientResource {


    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public PatientDto findOne(@PathVariable("id") long id) {
        return this.patientService.findOne (id);
    }

    @GetMapping
    public Collection<PatientDto> findAll(){
        return this.patientService.findAll ();
    }

    @PostMapping
    public PatientDto add(@RequestBody PatientDto patientDto){
        return this.patientService.save (patientDto);
    }

    @PutMapping
    public PatientDto update(@RequestBody PatientDto patientDto){
        return this.patientService.save (patientDto);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.patientService.deleteById (id);
    }
}
