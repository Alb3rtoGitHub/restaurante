
package restaurante.accesoAdatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import restaurante.entidades.Mesa;


public class MesaData {
    private Connection con=null;
    
    public MesaData(){
        con=Conexion.getConexion();
    }
    
    public void guardarMesa(Mesa mesa){
        String sql = "INSERT INTO mesa (numeroMesa, capacidad, disponibilidad, estadoMesa) "
                + "VALUE (?,?,?,?)"; 
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesa.getNumeroMesa());
            ps.setInt(2,mesa.getCapacidad());
            ps.setBoolean(3,mesa.isDisponibilidad());
            ps.setBoolean(4,mesa.isEstadoMesa());
                        
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                mesa.setIdMesa(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mesa Agregada.");
            }
            ps.close();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
        }
    }
    
    public void modificarMesa(Mesa mesa){
        String sql = "UPDATE mesa SET numeroMesa = ?, capacidad = ?, disponibilidad = ?, estadoMesa = ? "
                + "WHERE idMesa = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, mesa.getNumeroMesa());
            ps.setInt(2,mesa.getCapacidad());
            ps.setBoolean(3,mesa.isDisponibilidad());
            ps.setBoolean(4,mesa.isEstadoMesa());
            ps.setInt(5,mesa.getIdMesa());
                        
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "La Mesa se modifico.");
            } else {
                JOptionPane.showMessageDialog(null, "La Mesa no existe.");
            }
            ps.close();
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
        }
    }
    
    public void eliminarMesa(int idMesa){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar la Mesa?", "Confirmar Borrar Mesa", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            String sql = "UPDATE mesa SET estadoMesa = 0 WHERE idMesa=? AND disponibilidad = 1";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idMesa);
                
                int exito = ps.executeUpdate();
                if (exito == 1){
                    JOptionPane.showMessageDialog(null, "La Mesa se elimino.");
                }else if (exito == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar una Mesa ocupada.");
                }
                ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
            }
        }
    }
    
        public void restaurarMesa(int idMesa){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea restaurar la Mesa?", "Confirmar restaurar Mesa", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            String sql = "UPDATE mesa SET estadoMesa = 1 WHERE idMesa=? AND disponibilidad = 1";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idMesa);
                
                int exito = ps.executeUpdate();
                if (exito == 1){
                    JOptionPane.showMessageDialog(null, "La Mesa se restauro.");
                }else if (exito == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede restaurar una Mesa ocupada.");
                }
                ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
            }
        }
    }
    
    public Mesa buscarMesaPorId(int idMesa){
        String sql = "SELECT numeroMesa, capacidad, disponibilidad, estadoMesa FROM mesa "
                + "WHERE idMesa = ?";// AND estadoMesa = 1";
        Mesa mesa = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(idMesa);
                mesa.setNumeroMesa(rs.getInt("numeroMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setDisponibilidad(rs.getBoolean("disponibilidad"));
                mesa.setEstadoMesa(rs.getBoolean("estadoMesa"));
                                
            }else{
                JOptionPane.showMessageDialog(null, "No existe esa Mesa.");
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
        }
       
        return mesa;
    }
    
    public Mesa buscarMesaPorNumero(int numero){
        String sql = "SELECT idMesa, capacidad, disponibilidad, estadoMesa FROM mesa "
                + "WHERE numeroMesa = ?";// AND estadoMesa = 1";
        Mesa mesa = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                mesa = new Mesa();
                
                mesa.setNumeroMesa(numero);
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setDisponibilidad(rs.getBoolean("disponibilidad"));
                mesa.setEstadoMesa(rs.getBoolean("estadoMesa"));
                                
            }else{
                JOptionPane.showMessageDialog(null, "No existe esa Mesa.");
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
        }
       
        return mesa;
    }
    
    public List<Mesa> listarMesas(){
                
        String sql = "SELECT * From mesa LIMIT 8";// WHERE estadoMesa = 1 ";
        ArrayList<Mesa> mesas = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Mesa mesa = new Mesa();
                                
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setNumeroMesa(rs.getInt("numeroMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setDisponibilidad(rs.getBoolean("disponibilidad"));
                mesa.setEstadoMesa(rs.getBoolean("estadoMesa"));
                
                mesas.add(mesa);
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
        }
       
        return mesas;
    }
    
    public int cantidadMesa(){
        String sql = "SELECT COUNT(*) FROM mesa;";
        int cantidad = 0;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cantidad = rs.getInt(1); // El resultado del conteo
            }
            rs.close();
            ps.close();
            
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Mesa " + ex.getMessage());
        }
       
        return cantidad;
    }
}
