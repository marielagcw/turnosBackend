package com.marielagcw.health_center.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
public class Specialist {

    //ATTRIBUTES
    private Long id;
    private String name;
    private String lastname;
    private String specialty;
    private List<Appointment> appointmentList;

    // CONSTRUCTORS
    public Specialist() {
    }

}// Cierre
