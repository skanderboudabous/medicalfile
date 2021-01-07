package tn.iit.medicalfile.rest;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.iit.medicalfile.dto.TraitementDto;
import tn.iit.medicalfile.service.TraitementService;


import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/traitements")
@RestController()
public class TraitementResource {
    private final TraitementService traitementService;

    public TraitementResource(TraitementService traitementService) {
        this.traitementService = traitementService;
    }

    @GetMapping("{id}")
    public TraitementDto findOne(@PathVariable("id") long id) {
        return this.traitementService.findOne (id);

    }

    @GetMapping
    public Collection<TraitementDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize
    ) {
        return this.traitementService.findAll (PageRequest.of (pageNo,pageSize));
    }

    @PostMapping
    public TraitementDto add(@RequestBody TraitementDto traitementDto) {
        return this.traitementService.save (traitementDto);
    }

    @PutMapping
    public TraitementDto update(@RequestBody TraitementDto traitementDto) {
        return this.traitementService.save (traitementDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        this.traitementService.deleteById (id);
    }
}
