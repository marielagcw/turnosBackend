package com.marielagcw.health_center.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.health_center.model.dto.SpecialistDTO;
import com.marielagcw.health_center.model.entity.Specialist;
import com.marielagcw.health_center.repository.ISpecialistRepository;
import com.marielagcw.health_center.service.ISpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SpecialistService implements ISpecialistService {

    // DEPENDENCIES
    @Autowired
    ISpecialistRepository specialistRepository;

    @Autowired
    ObjectMapper mapper;

    // METHODS

    // SAVE
    @Override
    public SpecialistDTO saveAndFlush(SpecialistDTO specialistDTO) {
        Specialist savedSpecialist = mapper.convertValue(specialistDTO, Specialist.class);
        return mapper.convertValue(specialistRepository.saveAndFlush(savedSpecialist), SpecialistDTO.class);
    }

    // FIND ALL
    @Override
    public List<SpecialistDTO> findAll(Pageable pageable) {
        List<Specialist> specialistList = specialistRepository.findAll(pageable).getContent();
        return specialistList.stream()
                .map(specialist -> mapper.convertValue(specialist, SpecialistDTO.class))
                .collect(Collectors.toList());
    }

    // FIND BY ID
    @Override
    public SpecialistDTO findById(@NotNull Long id) throws NoSuchElementException { //TODO Hacer TODAS las excepciones!
        Specialist foundSpecialist = specialistRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No existe el Especialista con id %d", id)));
        return mapper.convertValue(foundSpecialist, SpecialistDTO.class);

    }

    // DELETE BY ID
    @Override
    public void deleteById(@NotNull Long id) throws NoSuchElementException {
        specialistRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No existe el Especialista con id %d", id)));
        specialistRepository.deleteById(id);
    }

    // UPDATE BY ID
    @Override
    public void update(SpecialistDTO specialistDTO) {
        Specialist updatedSpecialist = mapper.convertValue(specialistDTO, Specialist.class);
        specialistRepository.saveAndFlush(updatedSpecialist);
    }
} // Cierre
