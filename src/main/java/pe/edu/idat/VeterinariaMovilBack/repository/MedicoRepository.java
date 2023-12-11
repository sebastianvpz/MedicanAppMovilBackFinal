package pe.edu.idat.VeterinariaMovilBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.VeterinariaMovilBack.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
