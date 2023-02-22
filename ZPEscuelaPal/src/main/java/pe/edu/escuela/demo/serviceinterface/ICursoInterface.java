package pe.edu.escuela.demo.serviceinterface;

import java.util.List;
import java.util.Optional;
import pe.edu.escuela.demo.entities.Curso;

public interface ICursoInterface {

	public void insert(Curso curso);

	public List<Curso> list();

	public void delete(int codigocurso);

	Optional<Curso> listId(int codigocurso);

	public void update(Curso curso);

}
