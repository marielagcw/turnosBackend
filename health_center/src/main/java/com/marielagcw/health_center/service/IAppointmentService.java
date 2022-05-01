package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.AppointmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAppointmentService {

    // SAVE
    AppointmentDTO saveAndFlush(AppointmentDTO appointmentDTO);

    // FIND ALL
    List<AppointmentDTO> findAll();

    // FIND BY ID
    AppointmentDTO findById(Long id);

    // DELETE BY ID
    void deleteById(Long id);

    // UPDATE BY ID
    void update(AppointmentDTO appointmentDTO);

}
