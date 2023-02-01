package com.crudBack.controller;

import com.crudBack.model.Persona;
import com.crudBack.service.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personas")
public class PersonaControlador {


    @Autowired
    PersonaService service;

    @GetMapping
    public List<Persona> lisar() {
        return service.listar();
    }

    @PostMapping
    public Persona agregar(@RequestBody Persona p) {
        return service.add(p);
    }

    @GetMapping(path = "/{id}")
    public Optional<Persona> lisar(@PathVariable("id") int id) {
        return service.listarId(id);
    }

    @PutMapping(path = "/{id}")
    public Persona editar(@RequestBody Persona p, @PathVariable("id") int id) {
        p.setId(id);
        return service.edit(p);
    }

    @DeleteMapping(path = "/{id}")
    public Persona editar(@PathVariable("id") int id) {
        return service.delete(id);
    }


}
