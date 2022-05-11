package com.marielagcw.health_center.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.health_center.model.dto.PatientDTO;
import com.marielagcw.health_center.model.dto.SpecialistDTO;
import com.marielagcw.health_center.model.entity.Patient;
import com.marielagcw.health_center.model.entity.Specialist;
import com.marielagcw.health_center.repository.IPatientRepository;
import com.marielagcw.health_center.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {

    // DEPENDENCIES
    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    // METHODS

    // SAVE
    @Override
    public PatientDTO saveAndFlush(PatientDTO patientDTO) {
        Patient savedPatient = mapper.convertValue(patientDTO, Patient.class);
        return mapper.convertValue(patientRepository.saveAndFlush(savedPatient), PatientDTO.class);
    }

    // FIND ALL
    @Override
    public List<PatientDTO> findAll(Pageable pageable) {
        List<Patient> patientList = patientRepository.findAll(pageable).getContent();
        return patientList.stream()
                .map(patient -> mapper.convertValue(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }


    // FIND BY ID
    @Override
    public PatientDTO findById(@NotNull Long id) throws NoSuchElementException {
        Patient foundPatient = patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No existe el Paciente con id %d", id)));
        return mapper.convertValue(foundPatient, PatientDTO.class);
    }

    // DELETE BY ID
    @Override
    public void deleteById(@NotNull Long id) throws NoSuchElementException {
        patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No existe el Paciente con id %d", id)));
        patientRepository.deleteById(id);
    }

    // UPDATE BY ID
    @Override
    public void update(PatientDTO patientDTO) {
        Patient updatedPatient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.saveAndFlush(updatedPatient);
    }
} // Cierre
