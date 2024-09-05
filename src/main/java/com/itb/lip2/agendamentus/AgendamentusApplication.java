package com.itb.lip2.agendamentus;

import com.itb.lip2.agendamentus.model.Papel;
import com.itb.lip2.agendamentus.repository.PapelRepository;
import com.itb.lip2.agendamentus.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendamentusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentusApplication.class, args);

	}

	@Bean
	CommandLineRunner run(UsuarioService usuarioService, PapelRepository papelRepository){
		return args -> {
			//usuarioService.save(new Professor(null,"Rogerio","Caetano Santos", "nilcc@gmail.com", "1234", new ArrayList<>()));
			if(papelRepository.findAll().size() == 0) {
				usuarioService.savePapel(new Papel(null, "ROLE_FUNCIONARIO"));
			}else {
				System.out.println("Papeis já criados no banco de dados!");
			}
		};

}
}
