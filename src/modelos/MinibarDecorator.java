package modelos;

public class MinibarDecorator extends ExtraDecorator {
    public MinibarDecorator(Habitacion habitacionDecorada) {
        super(habitacionDecorada);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 15.0; // Añadir el costo del extra Internet
    }

    @Override
    public String toString() {
        return super.toString() + " con Despertador";
    }
}
