package com.marielagcw.health_center.controller;

import com.marielagcw.health_center.model.dto.PatientDTO;
import com.marielagcw.health_center.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    // DEPENDENCIES
    @Autowired
    PatientService patientService;

    // METHODS

    // SAVE / POST
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid PatientDTO patientDTO) {
        patientService.saveAndFlush(patientDTO);
        return ResponseEntity.ok().body("El Paciente fue agregado con éxito");
    }

    // FIND ALL
    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll(Pageable page) {
        List<PatientDTO> patientDTOList = patientService.findAll(page);
        return ResponseEntity.ok(patientDTOList);
    }

    // FIND BY ID // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable @NotNull Long id) {
        PatientDTO foundPatientDTO = patientService.findById(id);
        return ResponseEntity.ok(foundPatientDTO);
    }

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.ok().body("El Paciente con fue eliminado con éxito");
    }

    // UPDATE BY ID / PUT BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PatientDTO patientDTO) throws Exception {
        patientDTO.setId(id);
        patientService.update(patientDTO);
        return ResponseEntity.ok().body("El paciente fue modificado con éxito");
    }
}
