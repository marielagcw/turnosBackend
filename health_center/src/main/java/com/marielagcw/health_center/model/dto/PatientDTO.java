package com.marielagcw.health_center.model.dto;

import com.marielagcw.health_center.model.entity.Appointment;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class PatientDTO {

    // ATTRIBUTES
    private Long id;
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String lastname;
    private String address;
    private Set<Appointment> appointmentList = new HashSet<>();
}
