package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCliente")
	private int idCliente;

	@Column(name = "nomeCliente", length = 100, nullable = false)
	private String nomeCliente;
	
	@Column(name = "enderecoCliente", length = 255, nullable = true )
	private String enderecoCliente;
	
	@Column(name = "telefoneCliente", length = 15, nullable = true)
	private String telefoneCliente;
	
	@Column(name = "emailCliente", length = 100, nullable = true)
	private String emailCliente;
	
	@Override
	public String toString() {
	    return "Cliente{idCliente=" + idCliente + ", nomeCliente='" + nomeCliente + "'}";
	}

	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	
}
