import { ServiceService } from 'src/app/Service/service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/Modelo/Persona';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  persona: Persona = new Persona();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar();
   }

   Editar() {
    let idPersona = localStorage.getItem("id");
    if (idPersona) {
      let id = +idPersona;
      this.service.getPersonaId(id)
      .subscribe(data => {
        this.persona = data;
      });
    } else {
      // Mostrar un mensaje de error o redirigir a otra página, dependiendo de la lógica de negocio.
    }
  }


  Actualizar(persona:Persona) {
    this.service.updatePersona(persona)
    .subscribe(() => {
      alert('Persona actualizo con éxito');
      this.router.navigate(['listar']);
    });
  }
}
