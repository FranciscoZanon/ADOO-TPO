package modelos;

public class TVDecorator extends ExtraDecorator {
    public TVDecorator(Habitacion habitacionDecorada) {
        super(habitacionDecorada);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 10.0; 
    }

    @Override
    public String toString() {
        return super.toString() + " con TV";
    }
}