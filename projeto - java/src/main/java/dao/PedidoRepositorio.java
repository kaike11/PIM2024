package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{

}
