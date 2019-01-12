package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.emums.NivelDoTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelDoTrabalhador nivel;
	private double salarioBase;

	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();

	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelDoTrabalhador nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDoTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelDoTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public void addContrato(HoraContrato contrato) {
		this.contratos.add(contrato);
	}

	public void removeContrato(HoraContrato contrato) {
		this.contratos.remove(contrato);
	}

	public double salario(int ano, int mes) {
		double soma = salarioBase;
		Calendar calendar = Calendar.getInstance();

		for (HoraContrato c : contratos) {
			calendar.setTime(c.getData());
			int c_ano = calendar.get(Calendar.YEAR);
			int c_mes = 1 + calendar.get(Calendar.MONTH);

			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
