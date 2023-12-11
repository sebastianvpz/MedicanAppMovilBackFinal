package pe.edu.idat.VeterinariaMovilBack.model;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long idConsulta;

    private String descripcion;
    private String diagnostico;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    private String razon;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
}

