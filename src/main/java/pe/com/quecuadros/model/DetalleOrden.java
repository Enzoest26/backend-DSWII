package pe.com.quecuadros.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalles")
public class DetalleOrden
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer cantidad;
	
	private String nombre;
	
	private Double precio;
	
	private Double total;
	
	@MapsId("orden")
    @ManyToOne
    @JsonIgnore
    private Orden orden;
	
	@Column(name = "orden_id")
	private Integer idOrden;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
}
