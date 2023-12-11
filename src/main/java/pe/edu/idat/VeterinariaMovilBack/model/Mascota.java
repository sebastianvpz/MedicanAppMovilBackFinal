package pe.edu.idat.VeterinariaMovilBack.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    private int edad;
    private String especie;
    private String nombre;
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
