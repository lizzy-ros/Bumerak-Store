export interface Producto{
    id: number,

    name: string,

    description: string,

    price: number,

    stock: number,

    //category: new Category[],

    availableStock: boolean,

    imgProduct: string,
}