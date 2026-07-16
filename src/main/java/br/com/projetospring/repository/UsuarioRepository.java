package br.com.projetospring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetospring.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findByEmailContainingIgnoreCase(String email);

}
