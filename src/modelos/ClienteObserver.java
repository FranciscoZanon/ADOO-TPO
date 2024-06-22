package modelos;

public class ClienteObserver implements Observer {
    private Cliente cliente;

    public ClienteObserver(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void update(Reserva reserva) {
        if (reserva.getCliente().equals(cliente)) {
            System.out.println("Cliente " + cliente.getNombre() + " ha sido notificado de la reserva: " + reserva.getDescripcion());
        }
    }
}