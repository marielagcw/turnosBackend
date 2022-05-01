package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.SpecialistDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISpecialistService {
    // SAVE
    SpecialistDTO saveAndFlush(SpecialistDTO specialistDTO);

    // FIND ALL
    List<SpecialistDTO> findAll();

    // FIND BY ID
    SpecialistDTO findById(Long id);

    // DELETE BY ID
    void deleteById(Long id);

    // UPDATE BY ID
    void update(SpecialistDTO specialistDTO);

}
