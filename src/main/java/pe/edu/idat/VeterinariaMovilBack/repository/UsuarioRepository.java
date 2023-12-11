package pe.edu.idat.VeterinariaMovilBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.VeterinariaMovilBack.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
