package com.itb.lip2.agendamentus.controller;

import java.net.URI;
import java.util.List;

import com.itb.lip2.agendamentus.model.Cliente;
import com.itb.lip2.agendamentus.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.agendamentus.model.Usuario;
import com.itb.lip2.agendamentus.service.UsuarioService;

@RestController
@RequestMapping("/agendamentus/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/users")
	public ResponseEntity<List<Usuario>> getUsers() {

		return ResponseEntity.ok().body(usuarioService.findAll());
	}

	@PostMapping("/users")
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/agendamentus/api/v1/users").toUriString());
		return ResponseEntity.created(uri).body(usuarioService.save(usuario));

	}

	@PostMapping("/users/funcionario")
	public ResponseEntity<Usuario> saveFuncionario(@RequestBody Funcionario funcionario) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users").toUriString());
		return ResponseEntity.created(uri).body(usuarioService.saveFuncionario(funcionario));

	}

	@PostMapping("/users/cliente")
	public ResponseEntity<Usuario> saveCliente(@RequestBody Cliente cliente) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/academico/api/v1/users").toUriString());
		return ResponseEntity.created(uri).body(usuarioService.saveCliente(cliente));

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Object> findUserById(@PathVariable(value = "id") Long id) {
		//return ResponseEntity.ok().body(usuarioService.findById(id).get());
		try{
			return ResponseEntity.ok().body(usuarioService.findById(id).get());
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
		try{
			return ResponseEntity.ok().body(usuarioService.update(id, usuario));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}