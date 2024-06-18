package modelos;

public class Cliente extends Usuario {

    public Cliente(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni, "Cliente");
    }

    @Override
    public String getUsuario() {
        return "Cliente: " + getNombre() + " " + getApellido() + ", DNI: " + getDni();
    }
}