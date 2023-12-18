package pe.edu.idat.VeterinariaMovilBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.idat.VeterinariaMovilBack.model.Usuario;
import pe.edu.idat.VeterinariaMovilBack.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(Long id, Usuario nuevoUsuario) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setApellido(nuevoUsuario.getApellido());
                    usuario.setCelular(nuevoUsuario.getCelular());
                    usuario.setContrasena(passwordEncoder.encode(nuevoUsuario.getContrasena()));
                    usuario.setDireccion(nuevoUsuario.getDireccion());
                    usuario.setDni(nuevoUsuario.getDni());
                    usuario.setEmail(nuevoUsuario.getEmail());
                    usuario.setNombre(nuevoUsuario.getNombre());
                    return usuarioRepository.save(usuario);
                })
                .orElse(null); // Puedes manejar esto de acuerdo a tus requerimientos
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        // Busca al usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Verifica si el usuario existe y la contraseña coincide
        if (usuario != null && passwordEncoder.matches(contrasena, usuario.getContrasena())) {
            return usuario;
        }

        // Retorna null si la autenticación falla
        return null;
    }
}
