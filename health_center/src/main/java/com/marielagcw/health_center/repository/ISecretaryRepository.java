package com.marielagcw.health_center.repository;

import com.marielagcw.health_center.model.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecretaryRepository extends JpaRepository<Secretary, Long> {
}
