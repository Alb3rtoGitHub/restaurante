/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import restogrupo51.accesoAdatos.MesaData;
import restogrupo51.accesoAdatos.PedidoProductoData;
import restogrupo51.accesoAdatos.ProductoData;

/**
 *
 * @author Nico
 */
public class testPedidoProductoData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* PEDIDO PRODUCTO */
        MesaData mesadata = new MesaData();
        ProductoData productodata = new ProductoData();
        PedidoProductoData ppData = new PedidoProductoData();
        
        /* GUARDAR PEDIDO PRODUCTO */
        
        /*
        PedidoProducto newpp = new PedidoProducto(pedidodata.buscarPedido(3), productoData.buscarProducto(2), 3);
        PedidoProducto newpp2 = new PedidoProducto(pedidodata.buscarPedido(1), productoData.buscarProducto(3), 1);
        
        ppData.agregarPedidoProducto(newpp);
        ppData.agregarPedidoProducto(newpp2);
        */
        
        /* MODIFICAR PEDIDO PRODUCTO */
        //PedidoProducto modpp = new PedidoProducto(6, pedidodata.buscarPedido(1), productoData.buscarProducto(2), 1);
        //ppData.modificarPedidoConProducto(modpp);
        
        /* ELIMINAR PEDIDO PRODUCTO */
        //ppData.eliminarPedidoConProducto(6);
        
        /* BUSCAR PEDIDO PRODUCTO */
        
        /*
        PedidoProducto buscado = ppData.buscarPedidoConProducto(5);
        System.out.println("ID: " + buscado.getIdPedidoProducto());
        System.out.println("Mesa: " + buscado.getPedido().getMesa().getNumMesa());
        System.out.println("Mesero: " + buscado.getPedido().getNombreMesero());
        System.out.println("Producto: " + buscado.getProducto().getNombreProducto());
        System.out.println("Cantidad: " + buscado.getCantidad());
        */
        
        /* LISTA PEDIDO PRODUCTO */
        /*
        for (PedidoProducto PedidosProductos : ppData.obtenerPedidosConProductos()) {
            System.out.println("ID: " + PedidosProductos.getIdPedidoProducto());
            System.out.println("Mesa: " + PedidosProductos.getPedido().getMesa().getNumMesa());
            System.out.println("Producto: " + PedidosProductos.getProducto().getNombreProducto());
            System.out.println("Cantidad: " + PedidosProductos.getCantidad());
            System.out.println("");
        }
        */
        
        /* LISTA PEDIDOS POR MESERO */
        /*
        for (Pedido ppXMesero : ppData.obtenerPedidosXMesero("Rojan")) {
            System.out.println("ID Pedido: " + ppXMesero.getIdPedido());
            System.out.println("Mesero: " + ppXMesero.getNombreMesero());
            System.out.println("Mesa: " + ppXMesero.getMesa().getNumMesa());
            System.out.println("Fecha: " + ppXMesero.getFechaCreacion());
            System.out.println("Importe: " + ppXMesero.getImporte());
            System.out.println("");
        }
        */
        
        /* CALCULAR SUBTOTAL DE UN PEDIDO PRODUCTO */
        //System.out.println("Subtotal: " + ppData.calcularSubtotal(2)); ;
        
        /* CALCULAR TOTAL DE UN PEDIDO */
        //System.out.println("Total: "  + ppData.calcularTotal(1, 1));
        
        /* TOTAL EN UN DIA */
        //System.out.println("Total: " + ppData.precioTotalXFecha(LocalDate.of(2023, 10, 10))); //Posible metodo pero no puedo buscar por fecha;
        
        /* LISTAR PEDIDOS MESEROS EN FECHA */
        /*
        for (Pedido pedidosMeseros : ppData.listarPedidosXMeseroYFecha("Rojan", LocalDate.of(2023, 10, 8))) {
            System.out.println("ID: " + pedidosMeseros.getIdPedido());
            System.out.println("Numero Mesa: " + pedidosMeseros.getMesa().getNumMesa());
            System.out.println("Nombre Mesero: " + pedidosMeseros.getNombreMesero());
            System.out.println("Fecha: " + pedidosMeseros.getFechaCreacion());
            System.out.println("Importe: " + pedidosMeseros.getImporte());
        }
        */
        
        /* LISTAR PEDIDOS MESA ENTRE FECHA Y HORA */
        /*
        for (Pedido pedidofh : ppData.listarPedidosXMesaEntreFechaYHora(1, LocalDateTime.of(2023, 10, 8, 10, 26, 00), LocalDateTime.of(2023, 10, 11, 10, 30, 00))) {
            System.out.println("ID: " + pedidofh.getIdPedido());
            System.out.println("Mesa: " + pedidofh.getMesa().getIdMesa());
            System.out.println("Mesero: " + pedidofh.getNombreMesero());
            System.out.println("Fecha y Hora: " + pedidofh.getFechaCreacion());
            System.out.println("");
        }
        */
    }
    
}
