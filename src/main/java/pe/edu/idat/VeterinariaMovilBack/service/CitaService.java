package pe.edu.idat.VeterinariaMovilBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.VeterinariaMovilBack.model.Cita;
import pe.edu.idat.VeterinariaMovilBack.repository.CitaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita updateCita(Long id, Cita nuevaCita) {
        return citaRepository.findById(id)
                .map(cita -> {
                    cita.setFechaHora(nuevaCita.getFechaHora());
                    cita.setMedico(nuevaCita.getMedico());
                    cita.setServicio(nuevaCita.getServicio());
                    // Actualizar otros campos según sea necesario
                    return citaRepository.save(cita);
                })
                .orElse(null); // Puedes manejar esto de acuerdo a tus requerimientos
    }

    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    public List<Cita> getCitasByUsuario(Long idUsuario) {
        return citaRepository.findCitasByUsuarioId(idUsuario);
    }
}

