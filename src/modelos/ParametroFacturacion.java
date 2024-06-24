package modelos;

public class ParametroFacturacion {
    private float precioReserva;
    private Habitacion habitacion;

    public ParametroFacturacion(float precioReserva, Habitacion habitacion) {
        this.precioReserva = precioReserva;
        this.habitacion = habitacion;
    }

    // Getters y Setters
    public float getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(float precioReserva) {
        this.precioReserva = precioReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
