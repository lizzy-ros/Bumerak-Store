import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Category, Producto } from '../model/productos.model';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Supplier } from '../model/Supplier.model';


@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule ],
  templateUrl:'./product-form.component.html',
  styleUrl: './product-form.component.css'
})
export class ProductFormComponent implements OnInit {
  
   producFrom = this.fb.group({

    id: [0],

    name: [''],

    description: [''],

    price: [0],

    stock: [0],

    category:[Category.OPCION1],

    availableStock: [false],

    imgProduct: [''],

    proveedor: this.fb.group({
      id:[0],
      fullName:[''],
      
    })
 });

   isUpdate: boolean = false;
   proveedor: Supplier[] = []; 
   catego= Category ; 
category: any;
type: any;
  constructor( private fb: FormBuilder,
               private httpClient: HttpClient,
               private router: Router,
               private activatedRoute: ActivatedRoute ){             
 }

  ngOnInit(): void { 
    this

    this.activatedRoute.params.subscribe(params => {
      const id = params['id'];
      if(!id) return;
        this.httpClient.get<Producto>('http://localhost:8080/productos'+ id).subscribe(producFrom =>{

          this.producFrom.reset({
          id: producFrom.id,
          name: producFrom.name,
          description: producFrom.description,
          price: producFrom.price,
          stock: producFrom.stock,
          category: producFrom.category,
          availableStock: producFrom.availableStock,
          imgProduct: producFrom.imgProduct,
          proveedor: producFrom.proveedor,  
        });

        this.isUpdate = true;

      });
    });  
  }

  save () {
    const productos: Producto = this.producFrom.value as Producto;
    console.log(productos);
    
    if (this.isUpdate) {
    const url = 'http://localhost:8080/productos/' + productos.id;
    this.httpClient.put<Producto>(url, productos).subscribe(producBacken => {
    this.router.navigate(['/productos', producBacken.id, 'detail']);
    });
    
    } else {
    const url = 'http://localhost:8080/productos';
    this.httpClient.post<Producto>(url, productos).subscribe(producBacken => {
    this.router.navigate(['/productos', producBacken.id, 'detail']);
    });
    }
  }
} 
  
  
  
   
 




