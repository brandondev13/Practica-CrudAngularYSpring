package com.crudBack.service.interfaces;

import com.crudBack.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> listar();
    Optional<Persona> listarId(int id);
    Persona add(Persona p);
    Persona edit(Persona p);
    public Persona delete(int id);
}
