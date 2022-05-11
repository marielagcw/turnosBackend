package com.marielagcw.health_center.controller;

import com.marielagcw.health_center.model.dto.AppointmentDTO;
import com.marielagcw.health_center.service.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    // DEPENDENCIES
    @Autowired
    AppointmentService appointmentService;

    // METHODS

    // SAVE / POST
    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        appointmentService.saveAndFlush(appointmentDTO);
        return ResponseEntity.ok().body("El Turno fue agregado con éxito");
    }

    // FIND ALL / GET ALL
    @GetMapping("/find") //TODO Por qué me marca como advertencia los optionals del request param?,
    public ResponseEntity<List<AppointmentDTO>> findAll(@RequestParam Optional<@PositiveOrZero Integer> page,
                                                        @RequestParam Optional<@PositiveOrZero Integer> size) {
        Pageable pageable;
        if (size.isPresent()) {
            pageable = Pageable.ofSize(size.get()).withPage(page.orElse(0));
        } else {
            pageable = Pageable.unpaged();
        }
        List<AppointmentDTO> appointmentDTOList = appointmentService.findAll(pageable);
        return ResponseEntity.ok(appointmentDTOList);
    }

    // FIND BY ID // GET BY ID
    @GetMapping("/find/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable @NotNull Long id) {
        AppointmentDTO foundAppointmentDTO = appointmentService.findById(id);
        return ResponseEntity.ok(foundAppointmentDTO);
    }

    // DELETE BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().body("El Turno fue eliminado con éxito");
    }

    // UPDATE BY ID / PUT BY ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) throws Exception {
        appointmentDTO.setId(id);
       appointmentService.update(appointmentDTO);
       return ResponseEntity.ok().body("El turno fue modificado con éxito");
    }

} // Cierre
