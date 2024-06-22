package controller;
import modelos.Cliente;
import modelos.DespertadorDecorator;
import modelos.Reserva;
import modelos.Subject;
import modelos.Habitacion;
import modelos.HabitacionNormal;
import modelos.InternetDecorator;
import modelos.MinibarDecorator;
import modelos.Suite;
import modelos.TVDecorator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaController extends Subject{
    private List<Reserva> reservas;
    private List<Habitacion> habitaciones;

    public ReservaController() {
        this.reservas = new ArrayList<>();
        this.habitaciones = new ArrayList<>();
    }

    public boolean agregarReserva(Cliente cliente, String descripcion, LocalDateTime fecha, String numeroHabitacion) {
        Habitacion habitacion = buscarHabitacionPorNumero(numeroHabitacion);
        if (habitacion != null && habitacion.isDisponible()) {
            Reserva reserva = new Reserva(cliente, descripcion, fecha, habitacion);
            reservas.add(reserva);
            habitacion.setDisponible(false); // Marcar la habitación como no disponible
            notifyObservers(reserva);
            return true;
        }
        return false; // Si la habitación no está disponible o no existe
    }

    public void agregarHabitacionDecorada(String numero, boolean esSuite, boolean conTV, boolean conInternet, boolean conDespertador, boolean conMinibar) {
        Habitacion habitacion;
        if (esSuite) {
            habitacion = new Suite(numero);
        } else {
            habitacion = new HabitacionNormal(numero);
        }

        if (conTV) {
            habitacion = new TVDecorator(habitacion);
        }

        if (conInternet) {
            habitacion = new InternetDecorator(habitacion);
        }

        if (conDespertador) {
            habitacion = new DespertadorDecorator(habitacion);
        }
        
        if (conMinibar) {
            habitacion = new MinibarDecorator(habitacion);
        }
        
        habitaciones.add(habitacion);
    }
    
    public void modificarReserva(int id, String nuevaDescripcion, LocalDateTime nuevaFecha, String nuevoNumeroHabitacion) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                Habitacion nuevaHabitacion = buscarHabitacionPorNumero(nuevoNumeroHabitacion);
                if (nuevaHabitacion != null && nuevaHabitacion.isDisponible()) {
                    reserva.getHabitacion().setDisponible(true); // Liberar la habitación actual
                    reserva.setDescripcion(nuevaDescripcion);
                    reserva.setFecha(nuevaFecha);
                    reserva.setHabitacion(nuevaHabitacion);
                    nuevaHabitacion.setDisponible(false); // Reservar la nueva habitación
                }
                break;
            }
        }
    }

    public void cancelarReserva(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                reserva.getHabitacion().setDisponible(true); // Marcar la habitación como disponible
                reservas.remove(reserva);
                break;
            }
        }
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void modificarHabitacion(String numero, String nuevoNumero, boolean disponible) {
        Habitacion habitacion = buscarHabitacionPorNumero(numero);
        if (habitacion != null) {
            habitacion.setNumero(nuevoNumero);
            habitacion.setDisponible(disponible);
        }
    }

    public void eliminarHabitacion(String numero) {
        Habitacion habitacion = buscarHabitacionPorNumero(numero);
        if (habitacion != null) {
            habitaciones.remove(habitacion);
        }
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public Reserva buscarReservaPorId(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

    private Habitacion buscarHabitacionPorNumero(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return habitacion;
            }
        }
        return null;
    }
}