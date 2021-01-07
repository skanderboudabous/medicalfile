package tn.iit.medicalfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.medicalfile.dao.PatientDao;
import tn.iit.medicalfile.dto.PatientDto;
import tn.iit.medicalfile.mappers.PatientMapper;

import java.util.Collection;

@Transactional
@Service
public class PatientService {
    private final PatientDao patientDao;
    @Autowired
    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }
    public PatientDto save(PatientDto patientDto) {

        this.patientDao.saveAndFlush (PatientMapper.patientDtoToPatient (patientDto));
        return patientDto;
    }
    public void deleteById(Long id) {
        this.patientDao.deleteById (id);
    }
    @Transactional(readOnly = true)
    public PatientDto findOne(Long id) {
        return PatientMapper.patientToPatientDto (this.patientDao.getOne (id));
    }
    @Transactional(readOnly = true)
    public Collection<PatientDto> findAll() {
        return PatientMapper.patientsToPatientDtos (this.patientDao.findAll ());
    }
}
