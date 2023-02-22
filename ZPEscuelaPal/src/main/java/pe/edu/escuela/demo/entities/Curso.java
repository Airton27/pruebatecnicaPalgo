package pe.edu.escuela.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigocurso;

	@Column(name = "nombre", nullable = false, length = 44)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 44)
	private String descripcion;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int codigocurso, String nombre, String descripcion) {
		super();
		this.codigocurso = codigocurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getCodigocurso() {
		return codigocurso;
	}

	public void setCodigocurso(int codigocurso) {
		this.codigocurso = codigocurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
