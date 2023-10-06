
package accesoDatos;

import entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class ProductoData {
    
    private Connection con=null;
    
    public ProductoData(){
        con=Conexion.getConexion();
    }
    
    
    
    public void agregarProducto(Producto producto){
        
        String sql = "INSERT INTO producto ( codigoProducto,nombre,descripcion,stock,precio ) "
                    + "VALUE (?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,producto.getCodigoProducto());
            ps.setString(2,producto.getNombre());
            ps.setString(3,producto.getDescripcion());
            ps.setInt(4,producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto Agregado");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
        }
        
    }
    
    
    
    public void modificarProducto(Producto producto){
        
        String sql = "UPDATE producto SET codigoProducto = ?, nombre = ?,descripcion = ?, precio = ? ,stock = ? "
                + "WHERE idProducto = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,producto.getCodigoProducto());
            ps.setString(2,producto.getNombre());
            ps.setString(3,producto.getDescripcion());
            ps.setInt(4,producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getIdProducto());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "El Producto se modifico.");
            }else{
                JOptionPane.showMessageDialog(null, "El Producto no existe.");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
        }
        
        
    }
    
    
    
    public void eliminarProducto(int idProducto){
        
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el Producto?", "Confirmar Borrar Producto", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            
            String sql = "DELETE FROM producto WHERE idProducto = ? ";
            
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setInt(1, idProducto);
                
                int exito = ps.executeUpdate();
                
                if (exito == 1){
                    JOptionPane.showMessageDialog(null, "El Producto se elimino.");
                }
                
                ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
            }
        }
        
    }
    
    
    
    public Producto buscarProductoPorId(int idProducto){
        
        String sql = "SELECT codigoProducto, nombre,descripcion, stock, precio FROM producto WHERE idProducto = ? ";
        Producto producto = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                producto = new Producto();
                producto.setCodigoProducto(rs.getString("codigoProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese Producto");
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
        }
       
        return producto;
        
    }
    
    
    
    public Producto buscarProductoPorCodigo(String codigoProducto){
        
        String sql = "SELECT idProducto, nombre, stock, precio FROM producto WHERE codigoProducto = ? ";
        Producto producto = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, codigoProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese Producto");
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
        }
       
        return producto;
        
    }
    
    
    
    public List<Producto> listaDeProductos(){
        
        String sql = "SELECT idProducto, codigoProducto, nombre, stock, precio From alumno ";
        
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setCodigoProducto(rs.getString("codigoProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                
                productos.add(producto);
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto " + ex.getMessage());
        }
       
        return productos;
    }
    
    
}
