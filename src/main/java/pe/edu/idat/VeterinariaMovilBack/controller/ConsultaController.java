package pe.edu.idat.VeterinariaMovilBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.VeterinariaMovilBack.model.Consulta;
import pe.edu.idat.VeterinariaMovilBack.service.ConsultaService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultas() {
        List<Consulta> consultas = consultaService.getAllConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        Optional<Consulta> consulta = consultaService.getConsultaById(id);
        return consulta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {
        try {
            // Imprime o loguea los valores recibidos
            System.out.println("Descripción: " + consulta.getDescripcion());
            System.out.println("Diagnóstico: " + consulta.getDiagnostico());
            System.out.println("Fecha: " + consulta.getFecha());
            System.out.println("Razón: " + consulta.getRazon());
            System.out.println("ID Mascota: " + consulta.getMascota().getIdMascota());  // Asegúrate de que la mascota esté configurada

            // Resto del código...
            Consulta nuevaConsulta = consultaService.saveConsulta(consulta);
            return new ResponseEntity<>(nuevaConsulta, HttpStatus.CREATED);
        } catch (Exception e) {

            System.out.println("Descripción: " + consulta.getDescripcion());
            System.out.println("Diagnóstico: " + consulta.getDiagnostico());
            System.out.println("Fecha: " + consulta.getFecha());
            System.out.println("Razón: " + consulta.getRazon());
            System.out.println("ID Mascota: " + consulta.getMascota().getIdMascota());

            e.printStackTrace(); // O utiliza un logger para imprimir la excepción
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta nuevaConsulta) {
        Consulta updatedConsulta = consultaService.updateConsulta(id, nuevaConsulta);
        return updatedConsulta != null
                ? new ResponseEntity<>(updatedConsulta, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Consulta>> getConsultasByUsuario(@PathVariable Long idUsuario) {
        try {
            List<Consulta> consultas = consultaService.getConsultasByUsuario(idUsuario);
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para imprimir la excepción
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

