import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html'
})
export class AddComponent implements OnInit {

  persona = { id: 0, name: '', apellidos: '' };

  constructor(private router: Router, private service: ServiceService) {}

  ngOnInit() {}

  Guardar() {
    this.service.createPersona(this.persona)
    .subscribe(() => {
      alert('Persona agregada con éxito');
      this.router.navigate(['listar']);
    });
  }

}
