package modelos;

public abstract class Habitacion {
    protected String numero;
    protected boolean disponible;

    public Habitacion(String numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract double getPrecio(); // Método para obtener el precio base de la habitación

    @Override
    public String toString() {
        return "Habitación " + numero + " - Disponible: " + disponible;
    }
}