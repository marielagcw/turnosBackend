package com.marielagcw.health_center.model.dto;

import com.marielagcw.health_center.model.entity.Appointment;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
public class SpecialistDTO {

    //ATTRIBUTES
    private Long id;
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String lastname;
    @NotBlank(message = "La especialidad no puede estar en blanco")
    private String specialty;
    private Set<Appointment> appointmentList = new HashSet<>();
}
