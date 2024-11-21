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
@Table(name = "Relatorios_Plantio")
public class Relatorios_Plantio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdRelatorioPlantio")
	private int idRelatorioPlantio;

	@Column(name = "TipoPlantacao", length = 100)
	private String tipoPlantacao;

	@Column(name = "SecaoPlantacao", length = 100)
	private String secaoPlantacao;
	
	@Column(name = "DataDoPlantio")
	private LocalDate dataDoPlantio;
	
	@Column(name = "AguaUtilizada")
	private BigDecimal aguaUtilizada;
	
	@Column(name = "AgrotoxicosUtilizados", length = 255)
	private String agrotoxicosUtilizados;
	
	@Column(name = "PrevisaoColheita")
	private LocalDate previsaoColheita;
	
	@Override
	public String toString() {
	    return "Relatorios_Plantio{" +
	           "idRelatorioPlantio=" + idRelatorioPlantio +
	           ", tipoPlantacao='" + tipoPlantacao + '\'' +
	           ", secaoPlantacao='" + secaoPlantacao + '\'' +
	           ", dataDoPlantio=" + dataDoPlantio +
	           ", aguaUtilizada=" + aguaUtilizada +
	           ", agrotoxicosUtilizados='" + agrotoxicosUtilizados + '\'' +
	           ", previsaoColheita=" + previsaoColheita +
	           '}';
	}

	
	
	public int getIdRelatorioPlantio() {
		return idRelatorioPlantio;
	}

	public void setIdRelatorioPlantio(int idRelatorioPlantio) {
		this.idRelatorioPlantio = idRelatorioPlantio;
	}

	public String getTipoPlantacao() {
		return tipoPlantacao;
	}

	public void setTipoPlantacao(String tipoPlantacao) {
		this.tipoPlantacao = tipoPlantacao;
	}

	public String getSecaoPlantacao() {
		return secaoPlantacao;
	}

	public void setSecaoPlantacao(String secaoPlantacao) {
		this.secaoPlantacao = secaoPlantacao;
	}

	public LocalDate getDataDoPlantio() {
		return dataDoPlantio;
	}

	public void setDataDoPlantio(LocalDate dataDoPlantio) {
		this.dataDoPlantio = dataDoPlantio;
	}

	public BigDecimal getAguaUtilizada() {
		return aguaUtilizada;
	}

	public void setAguaUtilizada(BigDecimal aguaUtilizada) {
		this.aguaUtilizada = aguaUtilizada;
	}

	public String getAgrotoxicosUtilizados() {
		return agrotoxicosUtilizados;
	}

	public void setAgrotoxicosUtilizados(String agrotoxicosUtilizados) {
		this.agrotoxicosUtilizados = agrotoxicosUtilizados;
	}

	public LocalDate getPrevisaoColheita() {
		return previsaoColheita;
	}

	public void setPrevisaoColheita(LocalDate previsaoColheita) {
		this.previsaoColheita = previsaoColheita;
	}
	
}
