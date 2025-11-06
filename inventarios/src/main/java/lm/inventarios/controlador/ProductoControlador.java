package lm.inventarios.controlador;

import lm.inventarios.exepcion.RecursoNoEncontradoExcepcion;
import lm.inventarios.modelo.Producto;
import lm.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app") //http://localhost:8080/inventario-app
@CrossOrigin(value = "http://localhost:4200") // Puerto por default de Angular
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos= this.productoServicio.listarProducto();
        logger.info("Productos obtenidos");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar " + producto);
        return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto!=null){
            return ResponseEntity.ok(producto);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro el id" + id);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido
    ){
        Producto producto=this.productoServicio.buscarProductoPorId(id);
        if (producto!=null){
            producto.setDescripcion(productoRecibido.getDescripcion());
            producto.setPrecio(productoRecibido.getPrecio());
            producto.setExistencia(productoRecibido.getExistencia());
            this.productoServicio.guardarProducto(producto);
            return ResponseEntity.ok(producto);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro el id" + id);
        }
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProducro(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto==null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
        this.productoServicio.eliminarProductoPorId(producto.getIdProductos());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
