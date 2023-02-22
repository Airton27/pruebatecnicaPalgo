package pe.edu.escuela.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.escuela.demo.entities.Notas;

@Repository
public interface INotasRepository extends JpaRepository<Notas, Integer> {

}
