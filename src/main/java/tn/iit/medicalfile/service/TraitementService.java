package tn.iit.medicalfile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.medicalfile.dao.TraitementDao;
import tn.iit.medicalfile.dto.MedicamentDto;
import tn.iit.medicalfile.dto.TraitementDto;
import tn.iit.medicalfile.mappers.TraitementMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TraitementService {
    public Logger logger = LoggerFactory.getLogger (TraitementService.class);
    private final TraitementDao traitementDao;
    private final StoreManagementService storeManagementClientService;

    public TraitementService(TraitementDao traitementDao, StoreManagementService storeManagementClientService) {
        this.traitementDao = traitementDao;
        this.storeManagementClientService = storeManagementClientService;
    }

    public TraitementDto save(TraitementDto traitementDto) {
        this.traitementDao.saveAndFlush (TraitementMapper.traitementDtoToTraitement (traitementDto));
        return traitementDto;
    }

    public void deleteById(Long id) {
        this.traitementDao.deleteById (id);
    }
    @Transactional(readOnly = true)
    public TraitementDto findOne(Long id) {
        TraitementDto traitementDto= TraitementMapper.traitementToTraitementDto (this.traitementDao.getOne (id));
        MedicamentDto medicamentDto = this.storeManagementClientService.getMedicamentById (traitementDto.getMedicamentId ());
        traitementDto.setMedicamentDosage (medicamentDto.getDosage ());
        traitementDto.setMedicamentName (medicamentDto.getName ());
        traitementDto.setMedicamentPrice (medicamentDto.getPrice ());
        return traitementDto;
    }
    @Transactional(readOnly = true)
    public Collection<TraitementDto> findAll(Pageable pageable) {
        Collection<TraitementDto> traitementDtos = TraitementMapper.traitementsToTraitementDtos (this.traitementDao.findAll (pageable).getContent ());
        traitementDtos.forEach (traitementDto -> {
            MedicamentDto medicamentDto = this.storeManagementClientService.getMedicamentById (traitementDto.getMedicamentId ());
            traitementDto.setMedicamentDosage (medicamentDto.getDosage ());
            traitementDto.setMedicamentName (medicamentDto.getName ());
            traitementDto.setMedicamentPrice (medicamentDto.getPrice ());
        });
        return traitementDtos;
    }

}
