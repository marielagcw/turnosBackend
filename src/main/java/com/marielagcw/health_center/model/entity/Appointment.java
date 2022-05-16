package com.marielagcw.health_center.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@RequiredArgsConstructor
@Entity
public class Appointment {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateAppointment;
    private LocalTime startAppointment;
    private LocalTime endAppointment;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Specialist specialist;
    @ManyToOne
    @JoinColumn(name = "specialist_id", referencedColumnName = "id")
    private Patient patient;
}
