package com.marielagcw.health_center.model.dto;

import com.marielagcw.health_center.model.entity.Patient;
import com.marielagcw.health_center.model.entity.Specialist;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDTO {

    // ATTRIBUTES
    private Long id;
    @Past(message = "La fecha no puede ser anterior a la actual")
    private LocalDate dateAppointment;
    @Past(message = "La hora no puede ser anterior a la actual")
    private LocalTime startAppointment;
    @Past(message = "La hora no puede ser anterior a la actual")
    private LocalTime endAppointment;
    private Specialist specialist;
    private Patient patient;
}
