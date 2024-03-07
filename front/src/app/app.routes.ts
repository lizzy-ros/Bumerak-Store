import { Routes } from '@angular/router';
import { ProductosComponent } from './productos/productos.component';
import { ProductoDetailComponent } from './producto-detail/producto-detail.component';

export const routes: Routes = [

    {
        path:'',
        component: ProductosComponent
    },
    {
        path:'productos/:id/detail',
        component:ProductoDetailComponent
    }
];
