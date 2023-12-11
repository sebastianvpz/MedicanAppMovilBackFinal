package pe.edu.idat.VeterinariaMovilBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.idat.VeterinariaMovilBack.model.Mascota;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    @Query("SELECT m FROM Mascota m WHERE m.usuario.idUsuario = :idUsuario")
    List<Mascota> findByUsuarioId(Long idUsuario);
}
