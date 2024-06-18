package modelos;

public class InternetDecorator extends ExtraDecorator {
    public InternetDecorator(Habitacion habitacionDecorada) {
        super(habitacionDecorada);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 15.0; // Añadir el costo del extra Internet
    }

    @Override
    public String toString() {
        return super.toString() + " con Internet";
    }
}
