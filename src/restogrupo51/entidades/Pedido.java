package restogrupo51.entidades;

import java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private String nombreMesero;
    private LocalDateTime FechaHora;
    private double importe;
    private boolean cobrado;

    public Pedido() {
    }

    public Pedido(Mesa mesa, String nombreMesero, LocalDateTime FechaHora, double importe, boolean cobrado) {
        this.mesa = mesa;
        this.nombreMesero = nombreMesero;
        this.FechaHora = FechaHora;
        this.importe = importe;
        this.cobrado = cobrado;
    }

    public Pedido(int idPedido, Mesa mesa, String nombreMesero, LocalDateTime FechaHora, double importe, boolean cobrado) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.nombreMesero = nombreMesero;
        this.FechaHora = FechaHora;
        this.importe = importe;
        this.cobrado = cobrado;
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

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public double getImporte() {
        return importe;
    }

    public boolean isCobrado() {
        return cobrado;
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

    public void setFechaHora(LocalDateTime FechaHora) {
        this.FechaHora = FechaHora;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesa=" + mesa + ", nombreMesero=" + nombreMesero + ", FechaHora=" + FechaHora + ", importe=" + importe + ", cobrado=" + cobrado + '}';
    }
    

    
    
    
}


