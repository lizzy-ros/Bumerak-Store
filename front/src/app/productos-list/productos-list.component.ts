import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../model/productos.model';
import { RouterLink } from '@angular/router';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [HttpClientModule, RouterLink, NgbAlertModule],
  templateUrl: './productos-list.component.html',
  styleUrl: './productos-list.component.css'
})
export class ProductosComponent implements OnInit {
 
  productos: Producto [] =[]
  showDeletedBookMessage: boolean = false;


  constructor(private httpClient: HttpClient){}

 ngOnInit(): void {
  this.loadproductos();
  }
  
  delete( producto: Producto){

    const url = 'http://localhost:8080/productos/'+ producto.id;

    this.httpClient.delete(url).subscribe(product => {
      this.loadproductos();
      this.showDeletedBookMessage = true;
    });
  }

  hideDeleteBookMessage() {
    this.showDeletedBookMessage = false;
  }

  private loadproductos() {
    const url = 'http://localhost:8080/productos';

    this.httpClient.get<Producto[]>(url).subscribe(productos => this.productos = productos);
  }
  
}
