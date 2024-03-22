import { Supplier } from "./Supplier.model";


export interface Producto{
    categoria: any;
    id: number;

    name: string;

    description: string;

    price: number;
    stock: number;

    category: Category;

    availableStock: boolean;

    imgProduct: string;
    
     
    proveedor: Supplier;
}

export enum Category{
    OPCION1, OPCION2, OPCION3,OPCION4
}

