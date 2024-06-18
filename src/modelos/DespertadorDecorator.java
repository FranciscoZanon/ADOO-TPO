package modelos;

public class DespertadorDecorator extends ExtraDecorator {
    public DespertadorDecorator(Habitacion habitacionDecorada) {
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
