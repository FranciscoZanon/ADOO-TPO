package modelos;

public class Suite extends Habitacion {
    public Suite(String numero) {
        super(numero);
    }

    @Override
    public String toString() {
        return "Suite{" +
                "numero='" + getNumero() + '\'' +
                ", disponible=" + isDisponible() +
                '}';
    }
    public double getPrecio() {
        return 200.0; // Precio base de la habitación normal
    }
}