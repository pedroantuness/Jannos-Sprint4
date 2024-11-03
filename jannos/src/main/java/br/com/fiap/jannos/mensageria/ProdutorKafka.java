package br.com.fiap.jannos.mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProdutorKafka {
	
	public static final String topico = "Aplicativo_Jannos";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void enviarMensagem(String mensagem) {
		kafkaTemplate.send(topico, mensagem);
		System.out.println("Mensagem enviada: " + mensagem);
	}

}