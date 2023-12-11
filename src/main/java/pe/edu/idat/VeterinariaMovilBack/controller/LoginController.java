package pe.edu.idat.VeterinariaMovilBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.VeterinariaMovilBack.model.LoginRequest;
import pe.edu.idat.VeterinariaMovilBack.model.Usuario;
import pe.edu.idat.VeterinariaMovilBack.service.UsuarioService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String contrasena = loginRequest.getContrasena();

        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(email, contrasena);

        if (usuarioAutenticado != null) {
            System.out.println("Acceso permitido");
            return new ResponseEntity<>(usuarioAutenticado, HttpStatus.OK);
        } else {
            System.out.println("Acceso denegado");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
    }
}
