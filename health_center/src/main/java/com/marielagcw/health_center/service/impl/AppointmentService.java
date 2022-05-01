package com.marielagcw.health_center.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.health_center.model.dto.AppointmentDTO;
import com.marielagcw.health_center.repository.IAppointmentRepository;
import com.marielagcw.health_center.service.IAppointmentService;
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
        return null;
    }

    /* ────────────
        FIND ALL
    ──────────── */
    @Override
    public List<AppointmentDTO> findAll() {
        return null;
    }

    /* ────────────
       FIND BY ID
    ──────────── */
    @Override
    public AppointmentDTO findById(Long id) {
        return null;
    }

    /* ────────────
      DELETE BY ID
    ──────────── */
    @Override
    public void deleteById(Long id) {

    }

    /* ────────────
      UPDATE BY ID
    ──────────── */
    @Override
    public void update(AppointmentDTO appointmentDTO) {

    }
}
