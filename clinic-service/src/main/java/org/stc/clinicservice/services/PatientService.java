package org.stc.clinicservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stc.clinicservice.model.entity.Patient;
import org.stc.clinicservice.model.repository.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
}
