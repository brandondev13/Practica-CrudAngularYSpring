package com.crudBack.service;

import com.crudBack.model.Persona;
import com.crudBack.repository.PersonaRepository;
import com.crudBack.service.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository repository;

    @Override
    public List<Persona> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Persona add(Persona p) {
        return repository.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        return repository.save(p);
    }

    @Override
    public Persona delete(int id) {
        Optional<Persona> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        }
        return null;
    }

}
