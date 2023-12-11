package pe.edu.idat.VeterinariaMovilBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.VeterinariaMovilBack.model.Servicio;
import pe.edu.idat.VeterinariaMovilBack.repository.ServicioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> getServicioById(Long id) {
        return servicioRepository.findById(id);
    }

    public Servicio saveServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio updateServicio(Long id, Servicio nuevoServicio) {
        return servicioRepository.findById(id)
                .map(servicio -> {
                    servicio.setCosto(nuevoServicio.getCosto());
                    servicio.setDescripcion(nuevoServicio.getDescripcion());
                    servicio.setHorario(nuevoServicio.getHorario());
                    servicio.setNombre(nuevoServicio.getNombre());
                    servicio.setImagen(nuevoServicio.getImagen());
                    // Actualizar otros campos según sea necesario
                    return servicioRepository.save(servicio);
                })
                .orElse(null); // Puedes manejar esto de acuerdo a tus requerimientos
    }

    public void deleteServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
