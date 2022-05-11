package com.marielagcw.health_center.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@Entity
public class Patient {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotBlank(message = "El apellido no puede estar en blanco")
    private String lastname;
    private String address;
    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointmentList = new HashSet<>();

}// Cierre
