package br.cubas.usercontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.cubas.usercontrol.beans.Emprestimo;
import br.cubas.usercontrol.services.EmprestimoService;

@Controller
@RequestMapping(EmprestimoController.PATH_EMPRESTIMO)
public class EmprestimoController {
	
	public static final String PATH_EMPRESTIMO = "/emprestimos";
	public static final String PATH_EMPRESTIMO_LIST = "/list";
	
	@Autowired
	EmprestimoService emprestimoService;
	
	@RequestMapping("/")
	public ModelAndView  home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(PATH_EMPRESTIMO_LIST)
	public ModelAndView emprestimos() {
		List<Emprestimo> emprestimos = emprestimoService.listaEmprestimos();
		return new ModelAndView("emprestimos/emprestimos", "emprestimos", emprestimos);
	}

}