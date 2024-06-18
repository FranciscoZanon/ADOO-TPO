package modelos;

public abstract class ExtraDecorator extends Habitacion {
    protected Habitacion habitacionDecorada;

    public ExtraDecorator(Habitacion habitacionDecorada) {
        super(habitacionDecorada.getNumero());
        this.habitacionDecorada = habitacionDecorada;
    }

    @Override
    public double getPrecio() {
        return habitacionDecorada.getPrecio();
    }

    @Override
    public String toString() {
        return habitacionDecorada.toString();
    }
}