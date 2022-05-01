package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    // SAVE
    PatientDTO saveAndFlush(PatientDTO patientDTO);

    // FIND ALL
    List<PatientDTO> findAll();

    // FIND BY ID
    PatientDTO findById(Long id);

    // DELETE BY ID
    void deleteById(Long id);

    // UPDATE BY ID
    void update(PatientDTO patientDTO);

}
