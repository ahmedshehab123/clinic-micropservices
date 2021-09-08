package org.stc.clinicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stc.clinicservice.exceptions.DoctorClinicExceptions;
import org.stc.clinicservice.model.entity.Patient;
import org.stc.clinicservice.services.PatientService;

@RestController
@RequestMapping(value = "/api")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping ("/patient")
    public ResponseEntity<?> savePatient(@RequestBody Patient patient){
        try {
            return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.OK);
        }catch (DoctorClinicExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
