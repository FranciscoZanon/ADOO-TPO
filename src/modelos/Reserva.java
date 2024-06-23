package modelos;

import java.time.LocalDateTime;

public class Reserva{
    private static int idCounter = 0;
    private int id;
    private Cliente cliente;
    private String descripcion;
    private LocalDateTime fecha;
    private Habitacion habitacion;
    private boolean activa;

    public Reserva(Cliente cliente, String descripcion, LocalDateTime fecha, Habitacion habitacion) {
        this.id = ++idCounter;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.activa = true;
        this.habitacion.setDisponible(false); // Marcar habitación como no disponible
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void cancelar() {
        this.activa = false;
        this.habitacion.setDisponible(true); // Marcar habitación como disponible
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", habitacion=" + habitacion.getNumero() +
                ", activa=" + activa +
                '}';
    }
}