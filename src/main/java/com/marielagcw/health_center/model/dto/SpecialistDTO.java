package com.marielagcw.health_center.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

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
}
