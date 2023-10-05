
package restogrupo51.entidades;

public class Producto {
    private int idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombreProducto, double precio, int stock) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(int idProducto, String codigoProducto, String nombreProducto, double precio, int stock) {
        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    

    @Override
    public String toString() {
        return "ID: " + idProducto + ", " + codigoProducto + ", " + nombreProducto + ", " + precio + ", " + stock;
    }
}
