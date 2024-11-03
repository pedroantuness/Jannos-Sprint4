package br.com.fiap.jannos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.jannos.mensageria.ProdutorKafka;

@Controller
public class KafkaController {
	
	@Autowired
	private ProdutorKafka produtorKafka;

	@GetMapping("/form_mensagem")
	public String retornaFormEnvioMensagem(Model model) {
		return "form_mensagem";
	}
	
	@PostMapping("/enviar_mensagem")
	public String enviarMensagem(@RequestParam(name = "mensagem") String mensagem, Model model) {
		produtorKafka.enviarMensagem(mensagem);
		model.addAttribute("var","Mensagem enviada com sucesso");
		return "form_mensagem";
	}
	
}
