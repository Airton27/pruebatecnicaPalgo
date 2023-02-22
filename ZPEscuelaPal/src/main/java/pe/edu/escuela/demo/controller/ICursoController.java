package pe.edu.escuela.demo.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.escuela.demo.entities.Curso;
import pe.edu.escuela.demo.serviceinterface.ICursoInterface;

@Controller
@RequestMapping("/cursos")
public class ICursoController {

	@Autowired
	private ICursoInterface aService;

	@GetMapping("/nuevo")
	public String newAlumno(Model model) {
		model.addAttribute("c", new Curso());
		return "curso/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveCourse(@Valid Curso us, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "curso/frmRegistro";
		} else {
			aService.insert(us);
			model.addAttribute("mensaje", "Se registró correctamente!");
			return "redirect:/cursos/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listCourse(Model model) {
		try {
			model.addAttribute("listaCursos", aService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/curso/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleteAlumno(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				aService.delete(id); // elimina
				model.put("listaCursos", aService.list());// vuelve a listar

			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/curso/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Curso> objTa = aService.listId(id);
		model.addAttribute("c", objTa.get());
		return "curso/ActualizaCurso";
	}

	@PostMapping("/modificar")
	public String updatTalla(Curso a) {
		aService.update(a);
		return "redirect:/cursos/listar";

	}
}
