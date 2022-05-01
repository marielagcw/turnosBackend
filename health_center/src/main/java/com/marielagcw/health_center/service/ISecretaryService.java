package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.SecretaryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISecretaryService {
    // SAVE
    SecretaryDTO saveAndFlush(SecretaryDTO secretaryDTO);

    // FIND ALL
    List<SecretaryDTO> findAll();

    // FIND BY ID
    SecretaryDTO findById(Long id);

    // DELETE BY ID
    void deleteById(Long id);

    // UPDATE BY ID
    void update(SecretaryDTO secretaryDTO);

}
