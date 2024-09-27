package com.itb.lip2.agendamentus.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.itb.lip2.agendamentus.model.Cliente;
import com.itb.lip2.agendamentus.model.Funcionario;
import com.itb.lip2.agendamentus.model.Papel;
import com.itb.lip2.agendamentus.repository.FuncionarioRepository;
import com.itb.lip2.agendamentus.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itb.lip2.agendamentus.model.Usuario;
import com.itb.lip2.agendamentus.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private PapelRepository papelRepository;


	@Override
	public Usuario save(Usuario usuario) {
		usuario.setCodStatusUsuario(true);
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuario.setPapeis(new ArrayList<>());
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario saveFuncionario(Funcionario funcionario) {
		funcionario.setCodStatusUsuario(true);
		funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
		funcionario.setPapeis(new ArrayList<>());
		addPapelToUsuario(funcionario, "ROLE_FUNCIONARIO");
		return usuarioRepository.save(funcionario);
	}


	@Override
	public Usuario saveCliente(Cliente cliente) {
		cliente.setCodStatusUsuario(true);
		cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
		cliente.setPapeis(new ArrayList<>());
		addPapelToUsuario(cliente, "ROLE_CLIENTE");
		return usuarioRepository.save(cliente);
	}


	@Override
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		Optional <Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}

	@Override
	@Transactional
	public Usuario update(Long id, Usuario usuario) throws Exception {
		return usuarioRepository.findById(id).map(user ->{
			user.setNome(usuario.getNome());
			user.setDataNascimento(usuario.getDataNascimento());
			return usuarioRepository.save(user);
		}).orElseThrow(()-> new Exception("Usuário não encontrado!"));
	}

	@Override
	public Papel savePapel(Papel papel) {
		return papelRepository.save(papel);
	}

	@Override
	public void addPapelToUsuario(Usuario usuario, String nomePapel) {
		Papel papel = papelRepository.findByName(nomePapel);
		usuario.getPapeis().add(papel);
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null) {
			throw  new UsernameNotFoundException("Usuário não encontrado no banco de dados");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		usuario.getPapeis().forEach(papel -> {
			authorities.add(new SimpleGrantedAuthority(papel.getNomePapel()));
		});

		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), authorities);
	}
}
