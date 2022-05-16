package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.SpecialistDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface ISpecialistService {
    // SAVE
    SpecialistDTO saveAndFlush(SpecialistDTO specialistDTO);

    // FIND ALL
    List<SpecialistDTO> findAll(Pageable pageable);

    // FIND BY ID
    SpecialistDTO findById(@NotNull Long id) throws NoSuchElementException;

    // DELETE BY ID
    void deleteById(@NotNull Long id) throws NoSuchElementException;

    // UPDATE BY ID
    void update(SpecialistDTO specialistDTO);

}
