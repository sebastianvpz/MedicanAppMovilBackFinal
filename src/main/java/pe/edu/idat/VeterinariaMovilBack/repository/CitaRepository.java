package pe.edu.idat.VeterinariaMovilBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.idat.VeterinariaMovilBack.model.Cita;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Long> {

    @Query("SELECT c FROM Cita c WHERE c.usuario.idUsuario = :idUsuario")
    List<Cita> findCitasByUsuarioId(@Param("idUsuario") Long idUsuario);
}
