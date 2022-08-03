package com.marielagcw.health_center.controller;

import com.marielagcw.health_center.model.dto.AppointmentDTO;
import com.marielagcw.health_center.service.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    // DEPENDENCIES
    @Autowired
    AppointmentService appointmentService;

    // METHODS

    // SAVE / POST
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        appointmentService.saveAndFlush(appointmentDTO);
        return ResponseEntity.ok().body("El Turno fue agregado con éxito");
    }

    // FIND ALL / GET ALL
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(Pageable page ) {
        List<AppointmentDTO> appointmentDTOList = appointmentService.findAll(page);
        return ResponseEntity.ok(appointmentDTOList);
    }

    // FIND BY ID // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable @NotNull Long id) {
        AppointmentDTO foundAppointmentDTO = appointmentService.findById(id);
        return ResponseEntity.ok(foundAppointmentDTO);
    }

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().body("El Turno fue eliminado con éxito");
    }

    // UPDATE BY ID / PUT BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) throws Exception {
        appointmentDTO.setId(id);
       appointmentService.update(appointmentDTO);
       return ResponseEntity.ok().body("El turno fue modificado con éxito");
    }


}
