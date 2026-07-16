package br.com.projetospring.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projetospring.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
