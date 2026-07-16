package br.com.projetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetospring.entity.Usuario;
import br.com.projetospring.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
public class ControllerUsuario {

	@Autowired
	private UsuarioRepository dao;

	@PostMapping(value = "usuario")
	public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
		Usuario usuario = null;
		try {
			usuario = dao.save(user);
			return ResponseEntity.ok(usuario);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "usuario")
	public ResponseEntity<List<Usuario>> lista() {
		List<Usuario> listagem = null;
		listagem = (List<Usuario>) dao.findAll();
		return ResponseEntity.ok(listagem);
	}

	@GetMapping(value = "usuario/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
		try {
			Usuario resposta = dao.findById(id).orElse(null);
			return ResponseEntity.ok(resposta);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PutMapping(value = "usuario")
	public ResponseEntity<Usuario> update(@RequestBody Usuario user) {
		try {
			Usuario usuario = dao.save(user);
			return ResponseEntity.ok(usuario);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping(value = "usuario/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			dao.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}

}
