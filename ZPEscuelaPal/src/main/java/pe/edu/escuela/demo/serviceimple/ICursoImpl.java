package pe.edu.escuela.demo.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.escuela.demo.entities.Curso;

import pe.edu.escuela.demo.repositories.ICursoRepository;

import pe.edu.escuela.demo.serviceinterface.ICursoInterface;

@Service
public class ICursoImpl implements ICursoInterface {

	@Autowired
	private ICursoRepository cRepository;

	public void insert(Curso curso) {
		// TODO Auto-generated method stub
		cRepository.save(curso);
	}

	public List<Curso> list() {
		// TODO Auto-generated method stub
		return cRepository.findAll();
	}

	@Override
	public void delete(int codigocurso) {
		// TODO Auto-generated method stub
		cRepository.deleteById(codigocurso);
	}

	@Override
	public Optional<Curso> listId(int codigocurso) {
		// TODO Auto-generated method stub
		return cRepository.findById(codigocurso);
	}

	@Override
	public void update(Curso curso) {
		// TODO Auto-generated method stub
		cRepository.save(curso);
	}
}
