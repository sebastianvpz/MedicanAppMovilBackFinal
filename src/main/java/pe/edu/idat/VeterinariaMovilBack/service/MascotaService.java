package pe.edu.idat.VeterinariaMovilBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.VeterinariaMovilBack.model.Mascota;
import pe.edu.idat.VeterinariaMovilBack.repository.MascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> getMascotaById(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota saveMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    public Mascota updateMascota(Long id, Mascota nuevaMascota) {
        return mascotaRepository.findById(id)
                .map(mascota -> {
                    mascota.setEdad(nuevaMascota.getEdad());
                    mascota.setEspecie(nuevaMascota.getEspecie());
                    mascota.setNombre(nuevaMascota.getNombre());
                    mascota.setSexo(nuevaMascota.getSexo());
                    // Actualizar otros campos según sea necesario
                    return mascotaRepository.save(mascota);
                })
                .orElse(null); // Puedes manejar esto de acuerdo a tus requerimientos
    }

    public List<Mascota> getMascotasByUsuarioId(Long idUsuario) {
        return mascotaRepository.findByUsuarioId(idUsuario);
    }
}
