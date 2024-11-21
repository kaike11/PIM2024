package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdProduto")
	private int IdProduto;
	
	@Column(name = "NomeProduto", length = 100, nullable = false)
	private String nomeProduto;
	
	@Column(name = "PrecoProduto", nullable = false)
	private BigDecimal precoProduto;
	
	@Column(name = "EstoqueProduto", nullable = false)
	private int estoqueProduto;
	
	@Column(name = "ValidadeProduto", nullable = false)
	private LocalDate validadeProduto;

	
	public int getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(int estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public LocalDate getValidadeProduto() {
		return validadeProduto;
	}

	public void setValidadeProduto(LocalDate validadeProduto) {
		this.validadeProduto = validadeProduto;
	}
	
}
