package modelos;

public class HabitacionNormal extends Habitacion {
    public HabitacionNormal(String numero) {
        super(numero);
    }

    @Override
    public String toString() {
        return "HabitacionNormal{" +
                "numero='" + getNumero() + '\'' +
                ", disponible=" + isDisponible() +
                '}';
    }
    public double getPrecio() {
        return 100.0; // Precio base de la habitación normal
    }
}