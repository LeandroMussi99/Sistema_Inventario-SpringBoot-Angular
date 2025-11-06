import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.html'
})
export class ProductoLista {
  productos! : Producto[];

  private productoServicio = inject(ProductoService);
  private enrutador = inject(Router);

  ngOnInit() {
    //Cargar los productos
    this.obtenerProductos();
  }

  private obtenerProductos(): void {
    this.productoServicio.obtenerProductosLista().subscribe(
      {
        next: (datos) => {
          this.productos = datos;
        },
        error: (error) => {
          console.error('Error al obtener la lista de productos:', error);
        }
      }
    );
  }

  editarProducto(idProductos: number) {
    this.enrutador.navigate(['editar-producto', idProductos]);
  }

  eliminarProducto(idProductos: number) {
    this.productoServicio.eliminarProducto(idProductos).subscribe({
      next: (datos) => {this.obtenerProductos();},
      error: (error) => console.log('Error al eliminar el producto:', error)
    });
  }
}
