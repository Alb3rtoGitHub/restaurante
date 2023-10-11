package test;

import java.time.LocalDateTime;
import restogrupo51.accesoAdatos.MesaData;
import restogrupo51.accesoAdatos.PedidoData;
import restogrupo51.entidades.Mesa;
import restogrupo51.entidades.Pedido;

public class testPedidoData {
    public static void main(String[] args) {
        MesaData mesaData = new MesaData();
        PedidoData pedidoData = new PedidoData();
        
        // Constructor de Mesa: int numeroMesa, int capacidad, boolean disponibilidad, boolean estadoMesa
//        Mesa mesa = new Mesa(10, 2, true, true);
//        Mesa mesa2 = new Mesa(20, 3, true, true);
//        Mesa mesa3 = new Mesa(30, 4, true, true);
//        
//        mesaData.agregarMesa(mesa);
//        mesaData.agregarMesa(mesa2);
//        mesaData.agregarMesa(mesa3);
//        /*
//            Prueba de Creación de Pedido
//        */
//        // Constructor de Pedido: Mesa mesa, String nombreMesero, LocalDateTime fechaHoraPedido, double importe, boolean cobrada
//        Pedido pedido = new Pedido(mesa, "Dusatoir", LocalDateTime.now(), 0.0, false);
//        pedidoData.registrarPedido(pedido);
//
//        Pedido pedido2 = new Pedido(mesa, "Dusatoir", LocalDateTime.now(), 0.0, false);
//        pedidoData.registrarPedido(pedido2);
//        
//        Pedido pedido3 = new Pedido(mesa2, "Dupont", LocalDateTime.now(), 0.0, false);
//        pedidoData.registrarPedido(pedido3);
//        
//        Pedido pedido4 = new Pedido(mesa3, "Mignon", LocalDateTime.now(), 0.0, false);
//        pedidoData.registrarPedido(pedido4);
        Pedido pedido5 = new Pedido(mesaData.buscarMesaPorId(4), "Dusatoir", LocalDateTime.now(), 0.0, false);
        pedidoData.registrarPedido(pedido5);
        
        /*
            Prueba Modificación de Pedido
        */
//        Pedido pedido3 = new Pedido(13, mesaData.buscarMesaPorId(6), "Bublé", LocalDateTime.now(), 0.0, false);
//        pedidoData.modificarPedido(pedido3);
        
        
//        /*
//            Prueba Eliminación de Pedido
//        */
//        pedidoData.eliminarPedido(13);

//        
//        /*
//            Prueba buscar Pedido por IdPedido
//        */
//        System.out.println(pedidoData.buscarPedido(10));
//        
//        /*
//            Prueba listar Pedidos
//        */
//        for (Pedido listarPedido : pedidoData.listarPedidos()) {
//            System.out.println(listarPedido);
//            System.out.println("");
//        }
//        
//        /*
//            Prueba listar Pedidos por Mesa
//        */
//        ArrayList<Pedido> pedidosPorMesa = new ArrayList<>();
        
        for (Pedido PedidoPorMesa : pedidoData.listarPedidoPorMesa(4)) {
            System.out.println(PedidoPorMesa);
            System.out.println("");
        }
//        
    }
}
