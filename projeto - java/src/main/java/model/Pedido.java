package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPedido")
	private int idPedido;
	
	@ManyToOne
	@JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente", nullable =  true)
	private Cliente idCliente;
	
	@ManyToOne
	@JoinColumn(name = "IdFornecedor", referencedColumnName = "IdFornecedor", nullable =  true)
	private Fornecedor idFornecedor;
	
	@ManyToOne
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto", nullable =  true)
	private Produto idProduto;
	
	@Column(name = "DataPedido", nullable =  true)
	private LocalDate dataPedido;
	
	public enum StatusPedido {
	    PENDENTE,
	    FINALIZADO,
	    CANCELADO;
	}
	
	@Column(name = "StatusPedido", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Fornecedor getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Fornecedor idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	
}
