
package restogrupo51.entidades;


public class Mesa {
    
    private int idMesa;
    private int numeroMesa;
    private int capacidad;
    private boolean disponibilidad;
    private boolean estadoMesa;

    public Mesa() {
    }

    public Mesa(int numeroMesa, int capacidad, boolean disponibilidad, boolean estadoMesa) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
        this.estadoMesa = estadoMesa;
    }

    public Mesa(int idMesa, int numeroMesa, int capacidad, boolean disponibilidad, boolean estadoMesa) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
        this.estadoMesa = estadoMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", numeroMesa=" + numeroMesa + ", capacidad=" + capacidad + ", disponibilidad=" + disponibilidad + ", estadoMesa=" + estadoMesa + '}';
    }
    
}
