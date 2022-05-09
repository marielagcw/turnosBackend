package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.GenericUserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGenericUserI {
    // SAVE
    GenericUserDTO saveAndFlush(GenericUserDTO secretaryDTO);

    // FIND ALL
    List<GenericUserDTO> findAll();

    // FIND BY ID
    GenericUserDTO findById(Long id);

    // DELETE BY ID
    void deleteById(Long id);

    // UPDATE BY ID
    void update(GenericUserDTO secretaryDTO);

}
