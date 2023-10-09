package restogrupo51.entidades;

import java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private String nombreMesero;
    private LocalDateTime fechaHoraPedido;
    private double importe;
    private boolean cobrada;

    public Pedido() {
    }

    public Pedido(Mesa mesa, String nombreMesero, LocalDateTime fechaHoraPedido, double importe, boolean cobrada) {
        this.mesa = mesa;
        this.nombreMesero = nombreMesero;
        this.fechaHoraPedido = fechaHoraPedido;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public Pedido(int idPedido, Mesa mesa, String nombreMesero, LocalDateTime fechaHoraPedido, double importe, boolean cobrada) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.nombreMesero = nombreMesero;
        this.fechaHoraPedido = fechaHoraPedido;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public LocalDateTime getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public double getImporte() {
        return importe;
    }

    public boolean isCobrada() {
        return cobrada;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public void setFechaHoraPedido(LocalDateTime fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setCobrada(boolean cobrada) {
        this.cobrada = cobrada;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesa=" + mesa + ", nombreMesero=" + nombreMesero + ", fechaHoraPedido=" + fechaHoraPedido + ", importe=" + importe + ", cobrada=" + cobrada + '}';
    }
    

    
    
    
}


