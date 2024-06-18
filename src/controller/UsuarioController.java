package controller;
import modelos.Cliente;
import modelos.Gerente;
import modelos.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController {
    private Map<String, Usuario> usuarios;

    public UsuarioController() {
        usuarios = new HashMap<>();
        // Crear algunos usuarios por defecto
        agregarUsuario(new Cliente("Juan", "Pérez", "12345678"));
        agregarUsuario(new Gerente("María", "González", "87654321"));
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getDni(), usuario);
    }

    public Usuario buscarUsuarioPorDni(String dni) {
        return usuarios.get(dni);
    }
}