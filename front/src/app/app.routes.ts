import { Routes } from '@angular/router';
import { ProductosComponent } from './productos-list/productos-list.component';
import { ProductoDetailComponent } from './producto-detail/producto-detail.component';
import { HomeComponent } from './home/home.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { Component } from '@angular/core';


export const routes: Routes = [

    {
        path:'',
        component: HomeComponent
    },
    {
        path:'productos',
        component: ProductosComponent
    },
    {
        path:'productos/:id/detail',
        component: ProductoDetailComponent
    },
    {
        path:'productos/create',
        component: ProductFormComponent
    },
    {
        path:'productos/:id/update',
        component: ProductFormComponent
    },
       
];
