package com.marielagcw.health_center.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
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
    @Past(message = "La fecha no puede ser anterior a la actual")
    private LocalDate dateAppointment;
    @Past(message = "La hora no puede ser anterior a la actual")
    private LocalTime startAppointment;
    @Past(message = "La hora no puede ser anterior a la actual")
    private LocalTime endAppointment;
    @ManyToOne
    @JoinColumn(name="patient_id", referencedColumnName="id")
    private Specialist specialist;
    @ManyToOne
    @JoinColumn(name="specialist_id", referencedColumnName = "id")
    private Patient patient;

}
