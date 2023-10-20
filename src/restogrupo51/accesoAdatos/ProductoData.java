package restogrupo51.accesoAdatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import restogrupo51.entidades.Producto;

public class ProductoData {

        private Connection con = null;
    
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
    public void guardarProducto(Producto producto){
        String sql = "INSERT INTO producto (codigoProducto, nombreProducto, precio, stock, estadoProducto) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getCodigoProducto());
            ps.setString(2, producto.getNombreProducto());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstadoProducto());
            ps.executeUpdate();

            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                producto.setIdProducto(res.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto agregado");
            }
            ps.close();

        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al acceder a tabla Producto " + ex.getMessage());
        }
    }
    
    public void modificarProducto(Producto producto){
        String sql = "UPDATE producto SET codigoProducto = ?, nombreProducto = ?, precio = ?, stock = ?, estadoProducto = ? WHERE idProducto = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigoProducto());
            ps.setString(2, producto.getNombreProducto());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstadoProducto());
            ps.setInt(6, producto.getIdProducto());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El producto se ha modificado");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto " + ex.getMessage());
        }
    }
    
    public void eliminarProducto(int idProducto){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el producto?", "Confirmar borrar producto", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            String sql = "UPDATE producto SET estadoProducto = 0 WHERE idProducto = ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idProducto);
                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "El producto se elimino");
                } else if(exito == 0){
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto. El mismo se encuentra en uno o mas pedidos");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto " + ex.getMessage());
            }
        }
    }
    public void restaurarProducto(int idProducto){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Restaurar el producto?", "Confirmar Restaurar producto", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            String sql = "UPDATE producto SET estadoProducto = 1 WHERE idProducto = ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idProducto);
                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "El producto se restauro.");
                } else if(exito == 0){
                    JOptionPane.showMessageDialog(null, "No se pudo restaurar el producto.");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto " + ex.getMessage());
            }
        }
    }
    
    public Producto buscarProducto(int idProducto){
        String sql = "SELECT codigoProducto, nombreProducto, precio, stock, estadoProducto FROM producto WHERE idProducto = ?";// AND estadoProducto = 1";
        Producto producto = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                
                producto = new Producto();
                producto.setIdProducto(idProducto);
                producto.setCodigoProducto(res.getString("codigoProducto"));
                producto.setNombreProducto(res.getString("nombreProducto"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setEstadoProducto(res.getBoolean("estadoProducto"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese producto");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto " + ex.getMessage());
        }
        
        return producto;
    }
    
    public Producto buscarProductoPorCodigo(String codigoProducto){
        String sql = "SELECT idProducto, nombreProducto, precio, stock, estadoProducto FROM producto WHERE codigoProducto = ?";//  AND estadoProducto = 1";
        Producto producto = null;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoProducto);
            ResultSet res = ps.executeQuery();
            
            if (res.next()) {
                
                producto = new Producto();
                producto.setIdProducto(res.getInt("idProducto"));
                producto.setCodigoProducto(codigoProducto);
                producto.setNombreProducto(res.getString("nombreProducto"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setEstadoProducto(res.getBoolean("estadoProducto"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto " + ex.getMessage());
        }
        
        return producto;
    }
    
    public List<Producto> listarProductos(){
        String sql = "SELECT * FROM producto";// WHERE estadoProducto = 1";
        ArrayList<Producto> productos = new ArrayList<>();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                
                Producto producto = new Producto();
                producto.setIdProducto(res.getInt("idProducto"));
                producto.setCodigoProducto(res.getString("codigoProducto"));
                producto.setNombreProducto(res.getString("nombreProducto"));
                producto.setPrecio(res.getDouble("precio"));
                producto.setStock(res.getInt("stock"));
                producto.setEstadoProducto(res.getBoolean("estadoProducto"));
                
                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
        }
        
        return productos;
    }
}
