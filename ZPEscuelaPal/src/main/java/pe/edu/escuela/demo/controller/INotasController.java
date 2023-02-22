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

import pe.edu.escuela.demo.entities.Notas;
import pe.edu.escuela.demo.serviceinterface.IAlumnoInterface;
import pe.edu.escuela.demo.serviceinterface.ICursoInterface;
import pe.edu.escuela.demo.serviceinterface.INotasInterface;

@Controller
@RequestMapping("/notas")
public class INotasController {

	@Autowired
	private INotasInterface nService;

	@Autowired
	private IAlumnoInterface aService;

	@Autowired
	private ICursoInterface cService;

	@GetMapping("/nuevo")
	public String newMatricula(Model model) {
		model.addAttribute("m", new Notas());
		model.addAttribute("listaAlumnos", aService.list());
		model.addAttribute("listaCursos", cService.list());
		return "/matricula/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveMatricula(@Valid Notas objTP, BindingResult binRes) {

		if (binRes.hasErrors()) {
			return "/matricula/frmRegistro";
		} else {
			nService.insert(objTP);
			return "redirect:/notas/nuevo";
		}

	}

	@GetMapping("/listar")
	public String listMatricula(Model model) {
		try {
			model.addAttribute("listaNotas", nService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/matricula/Listar";
	}

	@GetMapping("/listarid")
	public String lisMatricula(Model model) {
		try {
			model.addAttribute("listaNotas", nService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/matricula/Listar";
	}
}
