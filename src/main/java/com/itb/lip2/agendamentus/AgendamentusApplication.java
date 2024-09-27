package com.itb.lip2.agendamentus;

import com.itb.lip2.agendamentus.model.Empresa;
import com.itb.lip2.agendamentus.model.Funcionario;
import com.itb.lip2.agendamentus.model.Papel;
import com.itb.lip2.agendamentus.repository.EmpresaRepository;
import com.itb.lip2.agendamentus.repository.PapelRepository;
import com.itb.lip2.agendamentus.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class AgendamentusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentusApplication.class, args);

	}

	@Bean
	CommandLineRunner run(UsuarioService usuarioService, PapelRepository papelRepository, EmpresaRepository empresaRepository){
		return args -> {
			//empresaRepository.save(new Empresa(null, "IGE", new ArrayList<>()))
			//usuarioService.save(new Funcionario(null,"Admin","admin2@gmail.com", "1234", "Funcionario", "ROLE_FUNCIONARIO" new ArrayList<>()));
			if(papelRepository.findAll().size() == 0) {
				usuarioService.savePapel(new Papel(null, "ROLE_FUNCIONARIO"));
				usuarioService.savePapel(new Papel(null, "ROLE_CLIENTE"));
				usuarioService.save(new Funcionario(null,"Admin","admin2@gmail.com", "1234", "Funcionario", new ArrayList<>()));
			}else if (papelRepository.findAll().size() >= 1){
				System.out.println("Papeis já criados no banco de dados!");
				//usuarioService.save(new Funcionario(null,"Admin","admin2@gmail.com", "1234", "Funcionario", new ArrayList<>()));
			}


		};

}
}
