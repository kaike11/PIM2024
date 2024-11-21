package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notas_Fiscais")
public class Notas_Fiscais {
	
	public Notas_Fiscais(Pedido idPedido, LocalDate dataDeEmissao, BigDecimal valorTotal) {
	    this.idPedido = idPedido;
	    this.dataDeEmissao = dataDeEmissao;
	    this.valorTotal = valorTotal;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdNotas_Fiscais")
	private int idNotas_Fiscais;

	@ManyToOne
	@JoinColumn(name = "IdPedido", referencedColumnName = "IdPedido", nullable =  true)
	private Pedido idPedido;
	
	@Column(name = "DataDeEmissao", nullable = true)
	private LocalDate dataDeEmissao;
	
	@Column(name = "ValorTotal", nullable = true)
	private BigDecimal valorTotal;
	
	@Override
	public String toString() {
	    return "NotasFiscais{idNotas_Fiscais=" + idNotas_Fiscais + ", dataDeEmissao=" + dataDeEmissao + ", valorTotal=" + valorTotal + "}";
	}

	
	public int getIdNotas_Fiscais() {
		return idNotas_Fiscais;
	}

	public void setIdNotas_Fiscais(int idNotas_Fiscais) {
		this.idNotas_Fiscais = idNotas_Fiscais;
	}

	public Pedido getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataDeEmissao() {
		return dataDeEmissao;
	}

	public void setDataDeEmissao(LocalDate dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

}
