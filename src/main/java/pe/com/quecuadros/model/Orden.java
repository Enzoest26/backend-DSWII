package pe.com.quecuadros.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "ordenes")
public class Orden {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
	@Column(name = "fecha_recibida")
    private LocalDateTime fechaRecibida;

	@Column(name = "numero")
    private String numero;

	@Column(name = "total")
    private Double total;
	
	@OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detalles;
    
	@ManyToOne
	@JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
