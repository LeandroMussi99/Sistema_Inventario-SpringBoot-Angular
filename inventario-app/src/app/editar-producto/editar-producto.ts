import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-producto',
  imports: [FormsModule],
  templateUrl: './editar-producto.html',
})
export class EditarProducto {
  producto: Producto = new Producto();
  id!: number;;

  private productoServicio= inject(ProductoService);
  private ruta= inject(ActivatedRoute);
  private enrutador= inject(Router);
  
  ngOnInit(): void {
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obtenerProductoPorId(this.id).subscribe({
      next:(datos) => this.producto = datos,
      error:(error:any) => console.log(error)
    });
  }

  onSubmit() {
    this.guardarProducto();
  }
  
  guardarProducto() {
    this.productoServicio.editarProducto(this.id, this.producto).subscribe({
      next: (datos) => {this.irProductosLista(); },
      error: (error: any) => console.log(error),
    });
  }

  irProductosLista() {
    this.enrutador.navigate(['/productos']);
  }
}
