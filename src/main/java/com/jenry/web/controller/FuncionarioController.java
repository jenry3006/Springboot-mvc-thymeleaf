package com.jenry.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jenry.domain.Cargo;
import com.jenry.domain.Funcionario;
import com.jenry.domain.UF;
import com.jenry.service.CargoService;
import com.jenry.service.FuncionarioService;
import com.jenry.web.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private FuncionarioService funcService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcinario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcService.buscaTodos());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult br, RedirectAttributes attr) {
		
		if(br.hasErrors()) {
			return "/funcionario/cadastro";
		}
		
		funcService.salvar(funcionario);
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> geCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcService.buscarPorId(id));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult br, RedirectAttributes attr) {
		
		if(br.hasErrors()) {
			return "/funcionario/cadastro";
		}
		
		funcService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionario editado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable ("id") Long id, RedirectAttributes attr) {
		funcService.excluir(id);
		attr.addFlashAttribute("success", "Funcionario removido com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String consultaPorNome(@RequestParam ("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", funcService.buscarPorNome(nome));
		return "/funcionario/lista";
		
	}
	
	@GetMapping("/buscar/cargo")
	public String consultaPorCargo(@RequestParam ("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcService.buscarPorCargo(id));
		return "/funcionario/lista";
		
	}
	
	@GetMapping("/buscar/data")
	public String consultaPorDatas(@RequestParam (name = "entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
								   @RequestParam (name = "saida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
								   ModelMap model) {
		model.addAttribute("funcionarios", funcService.buscarPorDatas(entrada,saida));
		return "/funcionario/lista";
		
	}
	
	
	
	
}
