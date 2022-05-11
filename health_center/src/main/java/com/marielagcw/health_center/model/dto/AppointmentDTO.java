package com.marielagcw.health_center.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marielagcw.health_center.model.entity.Patient;
import com.marielagcw.health_center.model.entity.Specialist;
import lombok.Data;

import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDTO {

    // ATTRIBUTES
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateAppointment;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startAppointment;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endAppointment;
    private SpecialistDTO specialist;
    private PatientDTO patient;
}
