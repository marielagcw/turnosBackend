package com.marielagcw.health_center.service;

import com.marielagcw.health_center.model.dto.AppointmentDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface IAppointmentService {

    // SAVE
    AppointmentDTO saveAndFlush(AppointmentDTO appointmentDTO);

    // FIND ALL
    List<AppointmentDTO> findAll(Pageable pageable);

    // FIND BY ID
    AppointmentDTO findById(@NotNull Long id) throws NoSuchElementException;

    // DELETE BY ID
    void deleteById(@NotNull Long id) throws NoSuchElementException;

    // UPDATE BY ID
    void update(AppointmentDTO appointmentDTO);

}
