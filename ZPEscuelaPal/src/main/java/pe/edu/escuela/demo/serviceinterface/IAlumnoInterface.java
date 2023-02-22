package pe.edu.escuela.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.escuela.demo.entities.Alumno;

public interface IAlumnoInterface {

	public void insert(Alumno alumno);

	public List<Alumno> list();

	public void delete(int codigoalum);

	Optional<Alumno> listId(int codigoalum);

	public void update(Alumno alumno);

}
