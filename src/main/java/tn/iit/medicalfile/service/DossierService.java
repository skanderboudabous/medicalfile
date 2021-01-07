package tn.iit.medicalfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.medicalfile.dao.DossierDao;
import tn.iit.medicalfile.dto.DossierDto;
import tn.iit.medicalfile.mappers.DossierMapper;

import java.util.Collection;

@Transactional
@Service
public class DossierService {
    private final DossierDao dossierDao;
    private final TraitementService traitementService;

    @Autowired
    public DossierService(DossierDao dossierDao, TraitementService traitementService) {
        this.dossierDao = dossierDao;
        this.traitementService = traitementService;
    }

    public DossierDto save(DossierDto dossierDto) {
        this.dossierDao.saveAndFlush (DossierMapper.dossierDtoToDossier (dossierDto));
        return dossierDto;
    }

    public void deleteById(Long id) {
        this.dossierDao.deleteById (id);
    }

    @Transactional(readOnly = true)
    public DossierDto findOne(Long id) {

        DossierDto dossierDto= DossierMapper.dossierToDossierDto (this.dossierDao.getOne (id));
        return dossierDto;
    }
    @Transactional(readOnly = true)
    public Collection<DossierDto> findAll() {
        return DossierMapper.dossiersToDossierDtos (this.dossierDao.findAll ());
    }
}
