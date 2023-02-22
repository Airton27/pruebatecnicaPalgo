package pe.edu.escuela.demo.serviceimple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.escuela.demo.entities.Notas;
import pe.edu.escuela.demo.repositories.INotasRepository;
import pe.edu.escuela.demo.serviceinterface.INotasInterface;

@Service
public class INotasImpl implements INotasInterface {

	@Autowired
	private INotasRepository nRepository;

	@Override
	public void insert(Notas notas) {
		// TODO Auto-generated method stub
		nRepository.save(notas);
	}

	@Override
	public List<Notas> list() {
		// TODO Auto-generated method stub
		return nRepository.findAll();
	}

}
