package modelos;

public class MercadoPago {
    private float monto;

    public MercadoPago(float monto) {
        this.monto = monto;
    }

    public void pagar() {
        // Implementación del método pagar
    }

    public void calcularReserva(float reserva, ParametroFacturacion parametroFacturacion) {
        // Implementación del método calcularReserva
    }

    public void registrarPago(float reserva) {
        // Implementación del método registrarPago
    }

    // Getters y Setters
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
