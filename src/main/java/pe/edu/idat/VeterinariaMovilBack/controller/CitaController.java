package pe.edu.idat.VeterinariaMovilBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.VeterinariaMovilBack.model.Cita;
import pe.edu.idat.VeterinariaMovilBack.service.CitaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> getAllCitas() {
        List<Cita> citas = citaService.getAllCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Long id) {
        Optional<Cita> cita = citaService.getCitaById(id);
        return cita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {

        try {
            Cita nuevaCita = citaService.saveCita(cita);
            System.out.println("Descripción: " + cita.getFechaHora());
            System.out.println("Descripción: " + cita.getServicio());
            System.out.println("Descripción: " + cita.getMedico());
            System.out.println("Descripción: " + cita.getUsuario());
            return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);

        }catch (Exception e) {

            System.out.println("fecha: " + cita.getFechaHora());
            System.out.println("servicio: " + cita.getServicio());
            System.out.println("medico: " + cita.getMedico());
            System.out.println("usuario: " + cita.getUsuario());
            e.printStackTrace(); // O utiliza un logger para imprimir la excepción
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Long id, @RequestBody Cita nuevaCita) {
        Cita updatedCita = citaService.updateCita(id, nuevaCita);
        return updatedCita != null
                ? new ResponseEntity<>(updatedCita, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Cita>> getCitasByUsuario(@PathVariable Long idUsuario) {
        try {
            List<Cita> citas = citaService.getCitasByUsuario(idUsuario);
            return new ResponseEntity<>(citas, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para imprimir la excepción
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
