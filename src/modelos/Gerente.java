package modelos;

public class Gerente extends Usuario {

    public Gerente(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni, "Gerente");
    }

    @Override
    public String getUsuario() {
        return "Gerente: " + getNombre() + " " + getApellido() + ", DNI: " + getDni();
    }
}
