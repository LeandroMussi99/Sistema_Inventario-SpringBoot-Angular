package lm.inventarios.servicio;

import lm.inventarios.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> listarProducto();

    Producto buscarProductoPorId(Integer idProducto);

    Producto guardarProducto(Producto producto);

    void eliminarProductoPorId(Integer idProducto);
}
