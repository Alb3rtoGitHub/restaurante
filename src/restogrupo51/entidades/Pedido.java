/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restogrupo51.entidades;

import java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private int idMesa;
    private String nombreMesero;
    private LocalDateTime FechaHora;
    private double importe;
    private boolean cobrado;

    public Pedido() {
    }

    public Pedido(int idPedido, int idMesa, String nombreMesero, LocalDateTime FechaHora, double importe, boolean cobrado) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.FechaHora = FechaHora;
        this.importe = importe;
        this.cobrado = cobrado;
    }

    public Pedido(int idMesa, String nombreMesero, LocalDateTime FechaHora, double importe, boolean cobrado) {
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.FechaHora = FechaHora;
        this.importe = importe;
        this.cobrado = cobrado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdMesa() {
        return idMesa;
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

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
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

    
    
    
}


