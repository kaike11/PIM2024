package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
