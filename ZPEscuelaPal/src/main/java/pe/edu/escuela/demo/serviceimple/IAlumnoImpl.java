package pe.edu.escuela.demo.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.escuela.demo.entities.Alumno;
import pe.edu.escuela.demo.repositories.IAlumnoRepository;
import pe.edu.escuela.demo.serviceinterface.IAlumnoInterface;

@Service
public class IAlumnoImpl implements IAlumnoInterface {

	@Autowired
	private IAlumnoRepository aRepository;

	public void insert(Alumno alumno) {
		// TODO Auto-generated method stub
		aRepository.save(alumno);
	}

	public List<Alumno> list() {
		// TODO Auto-generated method stub
		return aRepository.findAll();
	}

	@Override
	public void delete(int codigoalum) {
		// TODO Auto-generated method stub
		aRepository.deleteById(codigoalum);
	}

	@Override
	public Optional<Alumno> listId(int codigoalum) {
		// TODO Auto-generated method stub
		return aRepository.findById(codigoalum);
	}

	@Override
	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		aRepository.save(alumno);
	}
}
