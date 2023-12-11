package pe.edu.idat.VeterinariaMovilBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.idat.VeterinariaMovilBack.model.Consulta;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    @Query("SELECT c FROM Consulta c JOIN c.mascota m WHERE m.usuario.idUsuario = :idUsuario")
    List<Consulta> findConsultasByUsuarioId(@Param("idUsuario") Long idUsuario);
}
