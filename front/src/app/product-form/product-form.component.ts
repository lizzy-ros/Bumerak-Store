import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Category, Producto } from '../model/productos.model';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Supplier } from '../model/Supplier.model';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule,RouterLink ],
  templateUrl:'./product-form.component.html',
  styleUrl: './product-form.component.css'
})
export class ProductFormComponent implements OnInit {
 
  
  producForm= new FormGroup ({
    id: new FormControl<number>(0),
    name:new FormControl<string>(''),
    description: new FormControl<string>(''),
    price: new FormControl<number>(0.0),
    stock: new FormControl<number>(0),
    category: new FormControl<Category>(Category.OPCION1),
    availableStock: new FormControl<boolean>(false),
    imgProduct: new FormControl<string>(''),
    proveedor: new FormControl(),
  });

    isUpdate : boolean = false;
    proveedors: Supplier[] = [];
    category = Object.values(Category);
    img : File |undefined;
    imgPreview : string | undefined;

    constructor( private httpCliente: HttpClient,
                 private router: Router, 
                 private fb: FormBuilder,
                 private activatedRouter: ActivatedRoute){}

   ngOnInit(): void {
    this.activatedRouter.params.subscribe(params => {
      const id = params['id'];
      if(!id) return;
        this.httpCliente.get<Producto>('http://localhost:8080/productos/'+ id).subscribe(producFrom =>{

          this.producForm.reset({
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

        this.isUpdate =true;

      });
    });
 }
 onFileChange(event:Event){

  let target =event.target as HTMLInputElement;
  if( target.files === null || target.files.length == 0){
    return;
  }
  this.img = target.files[0];
/* previsualizar la img*/
  let reader = new FileReader();
  reader.onload = event => this.imgPreview = reader.result as string;
  reader.readAsDataURL(this.img);
 }

  save () {
    const productos: Producto = this.producForm.value as Producto;
    console.log(productos);
    
    if (this.isUpdate) {
    const url = 'http://localhost:8080/productos/' + productos.id;
    this.httpCliente.put<Producto>(url, productos).subscribe(producBacken => {
    this.router.navigate(['/productos', producBacken.id, 'detail']);
    });
    
    } else {
    const url = 'http://localhost:8080/productos';
    this.httpCliente.post<Producto>(url, productos).subscribe(producBacken => {
    this.router.navigate(['/productos', producBacken.id, 'detail']);
    });
    }
  }
  compareObjects(o1: any, o2: any): boolean {
    // console.log("Comparando objetos: ", o1, o2);

    if(o1 && o2) {
      return o1.id === o2.id;
    }
    return o1 === o2;
  }
}
