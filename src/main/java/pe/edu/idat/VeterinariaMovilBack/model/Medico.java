package pe.edu.idat.VeterinariaMovilBack.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    private String apellidos;
    private String especialidad;
    private String horario;
    private String imagen;
    private String nombre;
}

