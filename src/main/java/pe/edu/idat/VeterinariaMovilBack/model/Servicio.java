package pe.edu.idat.VeterinariaMovilBack.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    private double costo;
    private String descripcion;
    private String horario;
    private String nombre;
    private String imagen;
}
