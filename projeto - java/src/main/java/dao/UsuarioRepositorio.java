package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
