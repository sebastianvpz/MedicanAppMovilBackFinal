package pe.edu.idat.VeterinariaMovilBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.VeterinariaMovilBack.model.Consulta;
import pe.edu.idat.VeterinariaMovilBack.repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getConsultaById(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta updateConsulta(Long id, Consulta nuevaConsulta) {
        return consultaRepository.findById(id)
                .map(consulta -> {
                    consulta.setDescripcion(nuevaConsulta.getDescripcion());
                    consulta.setDiagnostico(nuevaConsulta.getDiagnostico());
                    consulta.setFecha(nuevaConsulta.getFecha());
                    consulta.setRazon(nuevaConsulta.getRazon());
                    consulta.setMascota(nuevaConsulta.getMascota());
                    consulta.setServicio(nuevaConsulta.getServicio());
                    // Actualizar otros campos según sea necesario
                    return consultaRepository.save(consulta);
                })
                .orElse(null); // Puedes manejar esto de acuerdo a tus requerimientos
    }

    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<Consulta> getConsultasByUsuario(Long idUsuario) {
        return consultaRepository.findConsultasByUsuarioId(idUsuario);
    }
}
