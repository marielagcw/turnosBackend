package com.marielagcw.health_center.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.health_center.model.dto.AppointmentDTO;
import com.marielagcw.health_center.model.entity.Appointment;
import com.marielagcw.health_center.repository.IAppointmentRepository;
import com.marielagcw.health_center.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AppointmentService implements IAppointmentService {

    // DEPENDENCIES
    @Autowired
    IAppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper mapper;

    // METHODS

    // SAVE
    @Override
    public AppointmentDTO saveAndFlush(AppointmentDTO appointmentDTO) {
        Appointment savedAppointment = mapper.convertValue(appointmentDTO, Appointment.class);
        return mapper.convertValue(appointmentRepository.saveAndFlush(savedAppointment), AppointmentDTO.class);
    }

    // FIND ALL
    @Override
    public List<AppointmentDTO> findAll(Pageable pageable) {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        return appointmentList.stream()
                .map(appointment -> mapper.convertValue(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    // FIND BY ID
    @Override
    public AppointmentDTO findById(@NotNull Long id) throws NoSuchElementException {
        Appointment foundAppointment = appointmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No existe el Turno con id %d", id)));
        return mapper.convertValue(foundAppointment, AppointmentDTO.class);
    }

    // DELETE BY ID
    @Override
    public void deleteById(@NotNull Long id) throws NoSuchElementException {
        appointmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No existe el Turno con id %d", id)));
        appointmentRepository.deleteById(id);
    }

    // UPDATE BY ID
    @Override
    public void update(AppointmentDTO appointmentDTO) {
        Appointment updatedAppointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.saveAndFlush(updatedAppointment);
    }

} //Cierre
