package pe.edu.idat.VeterinariaMovilBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String apellido;
    private int celular;
    private String contrasena;
    private String direccion;
    private int dni;
    private String email;
    private String nombre;


    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Mascota> mascotas;
}
