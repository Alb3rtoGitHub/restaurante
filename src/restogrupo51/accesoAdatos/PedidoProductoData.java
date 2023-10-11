
package restogrupo51.accesoAdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import restogrupo51.entidades.Pedido;
import restogrupo51.entidades.PedidoProducto;


public class PedidoProductoData {
    private Connection con = null;
    private PedidoData pedidodata;
    private ProductoData productodata;
    
    public PedidoProductoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarPedidoProducto(PedidoProducto pp){
        String sql = "INSERT INTO pedidoproducto (idPedido, idProducto, cantidad) VALUES (?,?,?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pp.getPedido().getIdPedido());
            ps.setInt(2, pp.getProducto().getIdProducto());
            ps.setInt(3, pp.getCantidad());
            
            ps.executeUpdate();
            
            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                pp.setIdPedidoProducto(res.getInt(1));
                JOptionPane.showMessageDialog(null, "Pedido con Producto registrado!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla PedidoProducto " + ex.getMessage());
        }
    }
    
    public void modificarPedidoConProducto(PedidoProducto pp){
        String sql = "UPDATE pedidoproducto SET idPedido = ?, idProducto = ?, cantidad = ? WHERE idPedidoProducto = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pp.getPedido().getIdPedido());
            ps.setInt(2, pp.getProducto().getIdProducto());
            ps.setInt(3, pp.getCantidad());
            ps.setInt(4, pp.getIdPedidoProducto());
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El pedido con producto se ha modificado");
            } else {
                JOptionPane.showMessageDialog(null, "El pedido con producto no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla pedido producto " + ex.getMessage());
        }
    }
    
    public void eliminarPedidoConProducto(int idPP){
        String sql = "DELETE FROM pedidoproducto WHERE idPedidoProducto = ? ";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPP);
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el Pedido Con Producto exito!");
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido Producto " + ex.getMessage());
        }
    }
    
    public PedidoProducto buscarPedidoConProducto(int idPP){
        String sql = "SELECT idPedido, idProducto, cantidad FROM pedidoproducto WHERE idPedidoProducto = ?";
        PedidoProducto pedidoproduc = null;
        pedidodata = new PedidoData();
        productodata = new ProductoData();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPP);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                
                pedidoproduc = new PedidoProducto();
                pedidoproduc.setIdPedidoProducto(idPP);
                pedidoproduc.setPedido(pedidodata.buscarPedido(res.getInt("idPedido")));
                pedidoproduc.setProducto(productodata.buscarProducto(res.getInt("idProducto")));
                pedidoproduc.setCantidad(res.getInt("cantidad"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese pedido producto");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla pedido producto " + ex.getMessage());
        }
        
        return pedidoproduc;
    }
    
    public List<PedidoProducto> obtenerPedidosConProductos(){
        String sql = "SELECT * FROM pedidoproducto";
        pedidodata = new PedidoData();
        productodata = new ProductoData();
        ArrayList<PedidoProducto> pedidosconproductos = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                
                PedidoProducto pedidop = new PedidoProducto();
                pedidop.setIdPedidoProducto(res.getInt("idPedidoProducto"));
                pedidop.setPedido(pedidodata.buscarPedido(res.getInt("idPedido")));
                pedidop.setProducto(productodata.buscarProducto(res.getInt("idProducto")));
                pedidop.setCantidad(res.getInt("cantidad"));
                
                pedidosconproductos.add(pedidop);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Pedido Producto " + ex.getMessage());
        }
        
        return pedidosconproductos;
    }
    
    public List<Pedido> obtenerPedidosXMesero(String mesero){
        //¿Este puede ir en la clase Pedido? o tiene que traer los PedidoProductos que este atendiendo?
        MesaData mesadata = new MesaData();
        
        ArrayList<Pedido> listaPedidosXMesero = new ArrayList<>(); 
        String sql = "SELECT idPedido, idMesa, nombreMesero, fechaHoraPedido, importe, cobrada FROM Pedido WHERE nombreMesero = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(res.getInt("idPedido"));
                pedido.setMesa(mesadata.buscarMesaPorId(res.getInt("idMesa")));
                pedido.setNombreMesero(mesero);
                pedido.setFechaHoraPedido(res.getTimestamp("fechaHoraPedido").toLocalDateTime());
                pedido.setImporte(res.getDouble("importe"));
                pedido.setCobrada(res.getBoolean("cobrada"));
                
                listaPedidosXMesero.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Pedido Producto " + ex.getMessage());
        }
        
        return listaPedidosXMesero;
    }
    
    public double calcularSubtotal(int idPedidoProducto){
        String sql = "SELECT (p.precio * pp.cantidad) AS subtotal FROM pedidoproducto pp INNER JOIN producto p ON (pp.idProducto = p.idProducto) WHERE pp.idPedidoProducto = ?";
        double subtotal = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedidoProducto);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                subtotal = res.getDouble("subtotal");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Pedido Producto " + ex.getMessage());
        }
        return subtotal;
    }
    
    
    public double calcularTotal(int idPedido){
        String sql = "SELECT (pr.precio * pp.cantidad) AS subtotal FROM pedidoproducto pp INNER JOIN producto pr ON (pp.idProducto = pr.idProducto) INNER JOIN pedido pe ON (pp.idPedido = pe.idPedido) WHERE pp.idPedido = ?";
        double subtotal = 0, total = 0;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                subtotal = res.getDouble("subtotal");
                total += subtotal;
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido Producto " + ex.getMessage());
        }
        
        return total;
    }
    
    public double precioTotalXFecha(LocalDate fecha){
        String sql = "SELECT (pr.precio * pp.cantidad) AS subtotal FROM pedidoproducto pp INNER JOIN producto pr ON (pp.idProducto = pr.idProducto) INNER JOIN pedido pe ON (pp.idPedido = pe.idPedido) WHERE (Date (pe.fechaHoraPedido) = ?)";
        double subtotal = 0, total = 0;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, fecha.toString());
            
            ResultSet res = ps.executeQuery();
            while(res.next()){
                subtotal = res.getDouble("subtotal");
                total += subtotal;
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Pedido Producto " + ex.getMessage());
        }
        
        return total;
    }
    
    
    public List<Pedido> listarPedidosXMeseroYFecha(String mesero, LocalDate fecha){
        MesaData mesadata = new MesaData();
        
        ArrayList<Pedido> listaPedidosXMesero = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE nombreMesero = ? AND (Date (fechaHoraPedido) = ?) AND cobrada = 1";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero);
            ps.setString(2, fecha.toString());
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(res.getInt("idPedido"));
                pedido.setMesa(mesadata.buscarMesaPorId(res.getInt("idMesa")));
                pedido.setNombreMesero(mesero);
                pedido.setFechaHoraPedido(res.getTimestamp("fechaHoraPedido").toLocalDateTime());
                pedido.setImporte(res.getDouble("importe"));
                pedido.setCobrada(res.getBoolean("cobrada"));
                
                listaPedidosXMesero.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Pedido Producto " + ex.getMessage());
        }
        
        return listaPedidosXMesero;
    }
    
    public List<Pedido> listarPedidosXMesaEntreFechaYHora(int idM, LocalDateTime fecha1, LocalDateTime fecha2){
        MesaData mesadata = new MesaData();
        
        ArrayList<Pedido> listaPedidosMesaXFH = new ArrayList<>(); 
        String sql = "SELECT p.idPedido, p.idMesa, p.nombreMesero, p.fechaHoraPedido, p.importe, p.cobrada FROM pedido p INNER JOIN mesa m ON (p.idMesa = m.idMesa) WHERE m.idMesa = ? AND (p.fechaHoraPedido BETWEEN ? AND ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idM);
            Timestamp fechaA = Timestamp.valueOf(fecha1);
            Timestamp fechaB = Timestamp.valueOf(fecha2);
            ps.setTimestamp(2, fechaA);
            ps.setTimestamp(3, fechaB);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(res.getInt("idPedido"));
                pedido.setMesa(mesadata.buscarMesaPorId(res.getInt("p.idMesa")));
                pedido.setNombreMesero(res.getString("nombreMesero"));
                pedido.setFechaHoraPedido(res.getTimestamp("fechaHoraPedido").toLocalDateTime());
                pedido.setImporte(res.getDouble("importe"));
                pedido.setCobrada(res.getBoolean("cobrada"));
                
                listaPedidosMesaXFH.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Pedido Producto " + ex.getMessage());
        }
        
        return listaPedidosMesaXFH;
    }
}
