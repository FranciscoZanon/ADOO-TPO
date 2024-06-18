package modelos;

public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String dni;
    private String rol;

    public Usuario(String nombre, String apellido, String dni, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getRol() {
        return rol;
    }

    public abstract String getUsuario();
}