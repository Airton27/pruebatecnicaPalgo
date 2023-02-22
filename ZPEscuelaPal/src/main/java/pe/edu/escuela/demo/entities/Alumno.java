package pe.edu.escuela.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoalum;

	@Column(name = "nombres", nullable = false, length = 44)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 44)
	private String apellidos;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechanacimiento", nullable = false)
	private Date fechanacimiento;

	@Column(name = "sexo", nullable = false, length = 44)
	private String sexo;

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumno(int codigoalum, String nombres, String apellidos, Date fechanacimiento, String sexo) {
		super();
		this.codigoalum = codigoalum;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.sexo = sexo;
	}

	public int getCodigoalum() {
		return codigoalum;
	}

	public void setCodigoalum(int codigoalum) {
		this.codigoalum = codigoalum;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
