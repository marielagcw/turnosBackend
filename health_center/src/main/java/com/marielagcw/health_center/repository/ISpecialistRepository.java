package com.marielagcw.health_center.repository;

import com.marielagcw.health_center.model.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpecialistRepository extends JpaRepository<Specialist, Long> {
}
