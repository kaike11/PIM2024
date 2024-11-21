package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Fornecedor;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Integer> {

}