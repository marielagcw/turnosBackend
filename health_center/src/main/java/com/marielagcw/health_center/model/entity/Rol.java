package com.marielagcw.health_center.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
@Setter
@Getter
public class Rol {
    @Id
    private Long Id;
    private String name;
}