package main;
import modelos.Cliente;
import modelos.DespertadorDecorator;
import modelos.Gerente;
import modelos.Usuario;
import modelos.Reserva;
import modelos.Habitacion;
import modelos.HabitacionNormal;
import modelos.InternetDecorator;
import modelos.MinibarDecorator;
import modelos.Suite;
import modelos.TVDecorator;
import controller.UsuarioController;
import controller.ReservaController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservaController reservaController = new ReservaController();
        UsuarioController usuarioController = new UsuarioController();

        // Agregar algunos usuarios para pruebas
        usuarioController.agregarUsuario(new Cliente("Juan", "Perez", "12345678"));
        usuarioController.agregarUsuario(new Gerente("Maria", "Lopez", "87654321"));

        boolean programaActivo = true;
        Usuario usuarioActual = null;

        while (programaActivo) {
            System.out.println("Introduce tu DNI para iniciar sesión:");
            String dni = scanner.nextLine();
            usuarioActual = usuarioController.buscarUsuarioPorDni(dni);

            if (usuarioActual == null) {
                System.out.println("Usuario no encontrado. Intenta nuevamente.");
                continue;
            }

            if (usuarioActual instanceof Cliente) {
                Cliente cliente = (Cliente) usuarioActual;
                boolean clienteActivo = true;

                while (clienteActivo) {
                    System.out.println("Bienvenido, " + cliente.getNombre() + ". Selecciona una opción:");
                    System.out.println("1. Ver habitaciones disponibles");
                    System.out.println("2. Realizar reserva");
                    System.out.println("3. Ver mis reservas");
                    System.out.println("4. Cancelar reserva");
                    System.out.println("5. Cambiar a modo Gerente");
                    System.out.println("6. Salir");
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            System.out.println("Habitaciones disponibles:");
                            for (Habitacion habitacion : reservaController.getHabitacionesDisponibles()) {
                                System.out.println(habitacion);
                            }
                            break;
                        case 2:
                            System.out.println("Introduce la descripción de la reserva:");
                            String descripcion = scanner.nextLine();
                            System.out.println("Introduce la fecha de la reserva (formato: yyyy-MM-dd HH:mm):");
                            String fechaStr = scanner.nextLine();
                            LocalDateTime fecha = LocalDateTime.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            System.out.println("Introduce el número de la habitación:");
                            String numeroHabitacion = scanner.nextLine();
                            if (reservaController.agregarReserva(cliente, descripcion, fecha, numeroHabitacion)) {
                                System.out.println("Reserva realizada con éxito.");
                            } else {
                                System.out.println("Error: La habitación no está disponible o no existe.");
                            }
                            break;
                        case 3:
                            System.out.println("Tus reservas:");
                            for (Reserva reserva : reservaController.getReservas()) {
                                if (reserva.getCliente().equals(cliente)) {
                                    System.out.println(reserva);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Introduce el ID de la reserva a cancelar:");
                            int idReserva = scanner.nextInt();
                            reservaController.cancelarReserva(idReserva);
                            System.out.println("Reserva cancelada.");
                            break;
                        case 5:
                            clienteActivo = false; // Salir del bucle de cliente para cambiar a gerente
                            break;
                        case 6:
                            clienteActivo = false;
                            programaActivo = false; // Salir del programa
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            } else if (usuarioActual instanceof Gerente) {
                Gerente gerente = (Gerente) usuarioActual;
                boolean gerenteActivo = true;

                while (gerenteActivo) {
                    System.out.println("Bienvenido, " + gerente.getNombre() + ". Selecciona una opción:");
                    System.out.println("1. Ver todas las habitaciones");
                    System.out.println("2. Agregar habitación");
                    System.out.println("3. Modificar habitación");
                    System.out.println("4. Eliminar habitación");
                    System.out.println("5. Modificar reserva");
                    System.out.println("6. Cancelar reserva");
                    System.out.println("7. Cambiar a modo Cliente");
                    System.out.println("8. Salir");
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            System.out.println("Todas las habitaciones:");
                            for (Habitacion habitacion : reservaController.getHabitaciones()) {
                                System.out.println(habitacion);
                            }
                            break;
                        case 2:
                            System.out.println("Introduce el número de la habitación:");
                            String numeroHabitacion = scanner.nextLine();
                            System.out.println("¿Es una suite? (true/false):");
                            boolean esSuite = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar el buffer

                            boolean deseaTV = false;
                            boolean deseaInternet = false;
                            boolean deseaDespertador = false;
                            boolean deseaMinibar = false;

                            System.out.println("¿Desea agregar TV? (true/false):");
                            deseaTV = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar el buffer

                            System.out.println("¿Desea agregar Internet? (true/false):");
                            deseaInternet = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar el buffer

                            System.out.println("¿Desea agregar Despertador? (true/false):");
                            deseaDespertador = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar el buffer

                            System.out.println("¿Desea agregar Minibar? (true/false):");
                            deseaMinibar = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar el buffer

                            Habitacion habitacion;
                            if (esSuite) {
                                habitacion = new Suite(numeroHabitacion);
                            } else {
                                habitacion = new HabitacionNormal(numeroHabitacion);
                            }

                            // Agregar extras si se desean
                            if (deseaTV) {
                                habitacion = new TVDecorator(habitacion);
                            }
                            if (deseaInternet) {
                                habitacion = new InternetDecorator(habitacion);
                            }
                            if (deseaDespertador) {
                                habitacion = new DespertadorDecorator(habitacion);
                            }
                            if (deseaMinibar) {
                                habitacion = new MinibarDecorator(habitacion);
                            }

                            reservaController.agregarHabitacion(habitacion);
                            System.out.println("Habitación agregada correctamente.");
                            break;
                        case 3:
                            System.out.println("Introduce el número de la habitación a modificar:");
                            String numeroModificar = scanner.nextLine();
                            System.out.println("Introduce el nuevo número de la habitación:");
                            String nuevoNumero = scanner.nextLine();
                            System.out.println("Introduce la disponibilidad (true/false):");
                            boolean disponible = scanner.nextBoolean();
                            reservaController.modificarHabitacion(numeroModificar, nuevoNumero, disponible);
                            System.out.println("Habitación modificada.");
                            break;
                        case 4:
                            System.out.println("Introduce el número de la habitación a eliminar:");
                            String numeroEliminar = scanner.nextLine();
                            reservaController.eliminarHabitacion(numeroEliminar);
                            System.out.println("Habitación eliminada.");
                            break;
                        case 5:
                            System.out.println("Introduce el ID de la reserva a modificar:");
                            int idModificar = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            System.out.println("Introduce la nueva descripción:");
                            String nuevaDescripcion = scanner.nextLine();
                            System.out.println("Introduce la nueva fecha de la reserva (formato: yyyy-MM-dd HH:mm):");
                            String nuevaFechaStr = scanner.nextLine();
                            LocalDateTime nuevaFecha = LocalDateTime.parse(nuevaFechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            System.out.println("Introduce el nuevo número de la habitación:");
                            String nuevoNumeroHabitacion = scanner.nextLine();
                            reservaController.modificarReserva(idModificar, nuevaDescripcion, nuevaFecha, nuevoNumeroHabitacion);
                            System.out.println("Reserva modificada.");
                            break;
                        case 6:
                            System.out.println("Introduce el ID de la reserva a cancelar:");
                            int idCancelar = scanner.nextInt();
                            reservaController.cancelarReserva(idCancelar);
                            System.out.println("Reserva cancelada.");
                            break;
                        case 7:
                            gerenteActivo = false; // Salir del bucle de gerente para cambiar a cliente
                            break;
                        case 8:
                            gerenteActivo = false;
                            programaActivo = false; // Salir del programa
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            }
        }

        scanner.close();
    }
}