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

import pe.edu.escuela.demo.entities.Alumno;
import pe.edu.escuela.demo.serviceinterface.IAlumnoInterface;

@Controller
@RequestMapping("/alumnos")
public class IAlumnoController {

	@Autowired
	private IAlumnoInterface aService;

	@GetMapping("/nuevo")
	public String newAlumno(Model model) {
		model.addAttribute("a", new Alumno());
		return "alumno/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveCourse(@Valid Alumno us, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "alumno/frmRegistro";
		} else {
			aService.insert(us);
			model.addAttribute("mensaje", "Se registró correctamente!");
			return "redirect:/alumnos/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listCourse(Model model) {
		try {
			model.addAttribute("listaAlumnos", aService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/alumno/frmLista";
	}

	@RequestMapping("/eliminar")
	public String deleteAlumno(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				aService.delete(id); // elimina
				model.put("listaAlumnos", aService.list());// vuelve a listar

			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/alumno/frmLista";
	}

	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		Optional<Alumno> objTa = aService.listId(id);
		model.addAttribute("a", objTa.get());
		return "alumno/ActualizaAlumno";
	}

	@PostMapping("/modificar")
	public String updatTalla(Alumno a) {
		aService.update(a);
		return "redirect:/alumnos/listar";

	}
}
