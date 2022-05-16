package com.marielagcw.health_center.controller;

import com.marielagcw.health_center.model.dto.SpecialistDTO;
import com.marielagcw.health_center.service.impl.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/specialists")
@CrossOrigin(origins = "*")
public class SpecialistController {

    // DEPENDENCIES
    @Autowired
    SpecialistService specialistService;

    // METHODS

    // SAVE / POST
    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody @Valid SpecialistDTO specialistDTO) {
        specialistService.saveAndFlush(specialistDTO);
        return ResponseEntity.ok().body("El Especialista fue agregado con éxito");
    }

    // FIND ALL / GET ALL
    @GetMapping("/find")
    public ResponseEntity<List<SpecialistDTO>> findAll(Pageable page) {
        List<SpecialistDTO> specialistDTOList = specialistService.findAll(page);
        return ResponseEntity.ok(specialistDTOList);
    }

    // FIND BY ID // GET BY ID
    @GetMapping("/find/{id}")
    public ResponseEntity<SpecialistDTO> findById(@PathVariable @NotNull Long id) {
        SpecialistDTO foundSpecialistDTO = specialistService.findById(id);
        return ResponseEntity.ok(foundSpecialistDTO);
    }

    // DELETE BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        specialistService.deleteById(id);
        return ResponseEntity.ok().body("El Especialista fue eliminado con éxito");
    }

    // UPDATE BY ID / PUT BY ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SpecialistDTO specialistDTO) throws Exception {
        specialistDTO.setId(id);
        specialistService.update(specialistDTO);
        return ResponseEntity.ok().body("El especialista fue modificado con éxito");
    }
}
