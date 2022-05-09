package com.marielagcw.health_center.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.health_center.model.dto.AppointmentDTO;
import com.marielagcw.health_center.repository.IAppointmentRepository;
import com.marielagcw.health_center.service.IAppointmentService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper mapper;

    /* ────────────
         SAVE
    ──────────── */
    @Override
    public AppointmentDTO saveAndFlush(AppointmentDTO appointmentDTO) {
        throw new NotImplementedException();
    }

    /* ────────────
        FIND ALL
    ──────────── */
    @Override
    public List<AppointmentDTO> findAll() {
        throw new NotImplementedException();

    }

    /* ────────────
       FIND BY ID
    ──────────── */
    @Override
    public AppointmentDTO findById(Long id) {
        throw new NotImplementedException();
    }

    /* ────────────
      DELETE BY ID
    ──────────── */
    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException();

    }

    /* ────────────
      UPDATE BY ID
    ──────────── */
    @Override
    public void update(AppointmentDTO appointmentDTO) {
        throw new NotImplementedException();
    }
}
