package pe.edu.escuela.demo.serviceinterface;

import java.util.List;

import pe.edu.escuela.demo.entities.Notas;

public interface INotasInterface {

	public void insert(Notas notas);

	public List<Notas> list();
}
