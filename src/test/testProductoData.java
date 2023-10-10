package test;

import restogrupo51.accesoAdatos.ProductoData;
import restogrupo51.entidades.Producto;

public class testProductoData {
    public static void main(String[] args) {
    
        ProductoData productoData = new ProductoData();
        
        /*
            Prueba de Creación de Producto
        */
        Producto producto = new Producto("BS001", "Agua", 400, 500, true);
        //productoData.guardarProducto(producto);

        Producto producto2 = new Producto("BC001", "Fernet", 1800, 50, true);
        //productoData.guardarProducto(producto2);
        
        Producto producto3 = new Producto("C001", "Hamburguesa", 1, 100, true);
        //productoData.guardarProducto(producto3);
        
        
        /*
            Prueba Modificación de Producto
        */
        Producto producto3Modificado = new Producto(3,"C001", "Hamburguesa Clasica", 2100, 100, true);
        
        //productoData.modificarProducto(producto3Modificado);
        
        
        /*
            Prueba Eliminación de Producto
        */
        //productoData.eliminarProducto(3);

        
        /*
            Prueba buscar Producto por Codigo
        */
        //System.out.println(productoData.buscarProducto(1));
        
        /*
            Prueba buscar Producto por ID
        */
        //System.out.println(productoData.buscarProductoPorCodigo("BC001"));
        
        
        /*
            Prueba listar Productos
        */
        for (Producto listarProducto : productoData.listarProductos()) {
            System.out.println(listarProducto);
            System.out.println("");
        }

        
    }
}
