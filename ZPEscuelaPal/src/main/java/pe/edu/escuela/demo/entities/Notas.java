package pe.edu.escuela.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Notas")
public class Notas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNotas;

	@ManyToOne
	@JoinColumn(name = "codigoalum", nullable = false)
	private Alumno alumno;

	@ManyToOne
	@JoinColumn(name = "codigocurso", nullable = false)
	private Curso curso;

	@Column(name = "Pc1", nullable = true)
	private double Pc1;

	@Column(name = "Pc2", nullable = true)
	private double Pc2;

	@Column(name = "Pc3", nullable = true)
	private double Pc3;

	@Column(name = "Parcial", nullable = true)
	private double Parcial;

	@Column(name = "Final", nullable = true)
	private double Final;

	public Notas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notas(int idNotas, Alumno alumno, Curso curso, double pc1, double pc2, double pc3, double parcial,
			double final1) {
		super();
		this.idNotas = idNotas;
		this.alumno = alumno;
		this.curso = curso;
		Pc1 = pc1;
		Pc2 = pc2;
		Pc3 = pc3;
		Parcial = parcial;
		Final = final1;
	}

	public int getIdNotas() {
		return idNotas;
	}

	public void setIdNotas(int idNotas) {
		this.idNotas = idNotas;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public double getPc1() {
		return Pc1;
	}

	public void setPc1(double pc1) {
		Pc1 = pc1;
	}

	public double getPc2() {
		return Pc2;
	}

	public void setPc2(double pc2) {
		Pc2 = pc2;
	}

	public double getPc3() {
		return Pc3;
	}

	public void setPc3(double pc3) {
		Pc3 = pc3;
	}

	public double getParcial() {
		return Parcial;
	}

	public void setParcial(double parcial) {
		Parcial = parcial;
	}

	public double getFinal() {
		return Final;
	}

	public void setFinal(double final1) {
		Final = final1;
	}

}
