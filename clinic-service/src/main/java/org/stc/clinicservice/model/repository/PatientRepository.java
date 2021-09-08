package org.stc.clinicservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stc.clinicservice.model.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
