package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.PatientDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface IPatientService {
    // SAVE
    PatientDTO saveAndFlush(PatientDTO patientDTO);

    // FIND ALL
    List<PatientDTO> findAll(Pageable pageable);

    // FIND BY ID
    PatientDTO findById(@NotNull Long id) throws NoSuchElementException;

    // DELETE BY ID
    void deleteById(@NotNull Long id) throws NoSuchElementException;

    // UPDATE BY ID
    void update(PatientDTO patientDTO);

}
