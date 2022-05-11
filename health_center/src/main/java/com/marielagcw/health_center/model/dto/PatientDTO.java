package com.marielagcw.health_center.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PatientDTO {

    // ATTRIBUTES
    private Long id;
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String lastname;
    private String address;
}
