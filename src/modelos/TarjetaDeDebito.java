package modelos;

public class TarjetaDeDebito extends MercadoPago {
    private String numTarjeta;

    public TarjetaDeDebito(float monto, String numTarjeta) {
        super(monto);
        this.numTarjeta = numTarjeta;
    }

    public void calcularPrecioReserva(float reserva, ParametroFacturacion parametroFacturacion) {
        // Implementación del método calcularPrecioReserva
    }

    @Override
    public void registrarPago(float reserva) {
        // Implementación del método registrarPago
    }

    // Getters y Setters
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
}
