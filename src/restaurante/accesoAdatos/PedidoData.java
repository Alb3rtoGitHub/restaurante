package restaurante.accesoAdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import restaurante.entidades.Mesa;
import restaurante.entidades.Pedido;

public class PedidoData {
    private Connection con = null;
    private MesaData mesaData;
    
    public PedidoData() {
        con = Conexion.getConexion();
    }
    
    public void registrarPedido(Pedido pedido){
        String sql = "INSERT INTO pedido (idMesa, nombreMesero, fechaHoraPedido, importe, cobrada) VALUES (?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int idMesa = pedido.getMesa().getIdMesa();
            ps.setInt(1, idMesa);
            ps.setString(2, pedido.getNombreMesero());
            ps.setObject(3, pedido.getFechaHoraPedido());
            ps.setDouble(4, pedido.getImporte()); //Revisar importe, va o no?
            ps.setBoolean(5, pedido.isCobrada()); //siempre false / no pago.
            
            if (mesaData.buscarMesaPorId(idMesa).isDisponibilidad() == true) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Esta mesa esta libre, desea que pase a ocupada?", "Confirmar cambio de Disponibilidad", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    Mesa mesita = mesaData.buscarMesaPorId(idMesa);
                    mesita.setDisponibilidad(false);
                    mesaData.modificarMesa(mesita);
                    
                    ps.executeUpdate();
                    ResultSet res = ps.getGeneratedKeys();
                    if (res.next()) {
                        pedido.setIdPedido(res.getInt(1));
                        JOptionPane.showMessageDialog(null, "Pedido Registrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La mesa ha quedado en Disponibilidad Libre, asi que el pedido no se hara!");
                }

            } else {
                ps.executeUpdate();
                ResultSet res = ps.getGeneratedKeys();
                if (res.next()) {
                    pedido.setIdPedido(res.getInt(1));
                    JOptionPane.showMessageDialog(null, "Pedido Registrado");
                }
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Pedido " + ex.getMessage());
        }
    }
    
    public void modificarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET idMesa = ?, nombreMesero = ?, fechaHoraPedido = ?, importe = ?, cobrada = ? WHERE idPedido = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setString(2, pedido.getNombreMesero());
            ps.setObject(3, pedido.getFechaHoraPedido());
            ps.setDouble(4, pedido.getImporte());
            ps.setBoolean(5, pedido.isCobrada()); //Nicolas habia puesto false porque?
            ps.setInt(6, pedido.getIdPedido());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pedido modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El Pedido no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Pedido " + ex.getMessage());
        }
    }
    
    public void eliminarPedido(int idPedido) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Borrar el Pedido?", "Confirmar Borrar Pedido", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {

            String sql = "DELETE FROM pedido WHERE idPedido = ? AND cobrada = 0";

            try {
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, idPedido);

                int exito = ps.executeUpdate();
                if (exito == 1){
                    JOptionPane.showMessageDialog(null, "El Pedido fue Borrado");
                } else if (exito == 0){
                    JOptionPane.showMessageDialog(null, "No se pudo Borrar el pedido. Aun no se encuentra pago.");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Pedido " + ex.getMessage());
            }
        }
    }
    
    public Pedido buscarPedido(int idPedido) {
        Pedido pedido = null;
        mesaData = new MesaData();
        
        String sql = "SELECT idMesa, nombreMesero, fechaHoraPedido, importe, cobrada FROM pedido WHERE idPedido = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(idPedido);
                pedido.setMesa(mesaData.buscarMesaPorId(rs.getInt("idMesa")));
                pedido.setNombreMesero(rs.getString("nombreMesero"));
                // Recupera la columna 'fechaHoraPedido' como Date y Time
                java.sql.Date date = rs.getDate("fechaHoraPedido");
                java.sql.Time time = rs.getTime("fechaHoraPedido");
                if (date != null && time != null) {
                    LocalDateTime localDateTime = LocalDateTime.of(date.toLocalDate(), time.toLocalTime());
                    pedido.setFechaHoraPedido(localDateTime);
                }   // convierto fechaHoraPedido de datetime a LocalDateTime
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setCobrada(rs.getBoolean("cobrada"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Pedido");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Pedido " + ex.getMessage());
        }
        return pedido;
    }
    
    public ArrayList<Pedido> listarPedidos(){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        mesaData = new MesaData();
        
        String sql = "SELECT * FROM pedido";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.buscarMesaPorId(rs.getInt("idMesa")));
                pedido.setNombreMesero(rs.getString("nombreMesero"));
                java.sql.Date date = rs.getDate("fechaHoraPedido");
                java.sql.Time time = rs.getTime("fechaHoraPedido");
                if (date != null && time != null) {
                    LocalDateTime localDateTime = LocalDateTime.of(date.toLocalDate(), time.toLocalTime());
                    pedido.setFechaHoraPedido(localDateTime);
                }
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setCobrada(rs.getBoolean("cobrada"));
                pedidos.add(pedido);
            }
            if (pedidos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen datos de pedidos");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Pedido " + ex.getMessage());
        }
        return pedidos;
    }
    
    public ArrayList<Pedido> listarPedidoPorMesa(int idMesa){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        mesaData = new MesaData();
        
        String sql = "SELECT * FROM pedido WHERE idMesa = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idMesa);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaData.buscarMesaPorId(rs.getInt("idMesa")));
                pedido.setNombreMesero(rs.getString("nombreMesero"));
                java.sql.Date date = rs.getDate("fechaHoraPedido");
                java.sql.Time time = rs.getTime("fechaHoraPedido");
                if (date != null && time != null) {
                    LocalDateTime localDateTime = LocalDateTime.of(date.toLocalDate(), time.toLocalTime());
                    pedido.setFechaHoraPedido(localDateTime);
                }
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setCobrada(rs.getBoolean("cobrada"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Pedido " + ex.getMessage());
        }
        return pedidos;
    }
}
