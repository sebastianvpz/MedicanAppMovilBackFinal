package pe.edu.idat.VeterinariaMovilBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.VeterinariaMovilBack.model.Medico;
import pe.edu.idat.VeterinariaMovilBack.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> getMedicoById(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico saveMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico nuevoMedico) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    medico.setApellidos(nuevoMedico.getApellidos());
                    medico.setEspecialidad(nuevoMedico.getEspecialidad());
                    medico.setHorario(nuevoMedico.getHorario());
                    medico.setImagen(nuevoMedico.getImagen());
                    medico.setNombre(nuevoMedico.getNombre());
                    // Actualizar otros campos según sea necesario
                    return medicoRepository.save(medico);
                })
                .orElse(null); // Puedes manejar esto de acuerdo a tus requerimientos
    }

    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
