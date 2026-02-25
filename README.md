# 🏥 Health Center – Sistema de Gestión de Turnos

Backend RESTful API para la gestión integral de turnos en un centro de salud.

El sistema permite administrar especialistas, pacientes y turnos, incorporando autenticación segura y separación clara de capas siguiendo buenas prácticas de arquitectura con Spring Boot.

---

## 🎯 Objetivo del Proyecto

Diseñar y desarrollar una API robusta y mantenible que permita:

- Gestión CRUD de especialistas.
- Gestión CRUD de pacientes.
- Gestión de turnos médicos con validaciones de integridad.
- Autenticación y autorización basada en JWT.
- Documentación y testing integral del sistema.

El foco estuvo en estructurar correctamente las capas del backend y aplicar principios de diseño orientados a escalabilidad y claridad.

---

## 🧩 Arquitectura y Diseño

El proyecto sigue una arquitectura en capas:

- **Capa de presentación:** Controllers REST desarrollados con Spring Boot.
- **Capa de negocio:** Services con lógica de validación y reglas del dominio.
- **Capa de acceso a datos:** Repositories utilizando Spring Data JPA.
- **Capa de persistencia:** Base de datos H2 (configurable a PostgreSQL para entorno productivo).

Principios aplicados:

- Separación de responsabilidades.
- Manejo centralizado de excepciones.
- Logging estructurado con SLF4J.
- Documentación automática de endpoints con Swagger.

---

## 🔐 Seguridad

- Implementación de autenticación con **Spring Security**.
- Generación y validación de **JSON Web Tokens (JWT)**.
- Protección de endpoints mediante configuración de seguridad y filtros personalizados.

---

## 🧪 Testing

- Tests de integración utilizando **MockMvc**.
- Validación de comportamiento de endpoints.
- Colección de requests documentada en Postman para pruebas manuales.

---

## 🚀 Deploy

- Deploy realizado en Heroku.
- Configuración de pipelines.
- Adaptación de base de datos a PostgreSQL para entorno productivo.

---

## 🛠 Tecnologías utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- H2 / PostgreSQL
- JWT
- MockMvc
- Swagger
- React (frontend desarrollado en proyecto separado)

---

## 💡 Desafíos técnicos abordados

- Implementación de autenticación stateless con JWT.
- Manejo consistente de excepciones y respuestas HTTP.
- Modelado de relaciones entre entidades (Especialista, Paciente, Turno).
- Separación adecuada entre lógica de negocio y persistencia.
- Preparación del proyecto para migración de base de datos en producción.
