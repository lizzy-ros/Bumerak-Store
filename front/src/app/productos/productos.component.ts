import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../model/productos.model';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css'
})
export class ProductosComponent implements OnInit {
 
  productos: Producto [] =[]

  constructor(private httpClient: HttpClient){}

 ngOnInit(): void {

  const url = 'http://localhost:8080/productos';

  this.httpClient.get<Producto[]>(url).subscribe(productos => this.productos = productos);
   
  }
}
