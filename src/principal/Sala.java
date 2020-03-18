package principal;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.Iinscricoes;

public class Sala implements Iinscricoes, Serializable {

	private int numero;
	private int vagas;
	private int capacidadeAlunos;
	private boolean arCondicionado;
	private boolean quadroBranco;
	private boolean eLaboratorio;
	private Turma turma;

	// construtor padr�o
	public Sala(int numero, int capacidade, boolean arCondicionado, boolean quadroBranco, boolean eLaboratorio) {
		super();
		this.numero = numero;
		this.vagas = capacidade;
		this.arCondicionado = arCondicionado;
		this.quadroBranco = quadroBranco;
		this.eLaboratorio = eLaboratorio;
	}

	// construtor s� apra ser usado no for
	public Sala(int numero) {
		this.numero = numero;
	}

	// construtor vazio s� para ser inst�nciado
	public Sala() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public boolean isQuadroBranco() {
		return quadroBranco;
	}

	public void setQuadroBranco(boolean quadroBranco) {
		this.quadroBranco = quadroBranco;
	}

	public boolean iseLaboratorio() {
		return eLaboratorio;
	}

	public void seteLaboratorio(boolean eLaboratorio) {
		this.eLaboratorio = eLaboratorio;
	}

	public int getCapacidadeAlunos() {
		return capacidadeAlunos;
	}

	public void setCapacidadeAlunos(int capacidadeAlunos) {
		this.capacidadeAlunos = capacidadeAlunos;
	}

	public String toString() {
		String detalhes = "";
		detalhes += "N�mero da Sala: " + this.getNumero() + " \n";
		detalhes += "Quantidade de vagas para novas turmas " + this.getCapacidadeAlunos() + " \n";

		if (this.isArCondicionado() == false) {
			detalhes += "Esta sala n�o cont�m ar-condicionado" + " \n";
		} else {
			detalhes += "Esta sala cont�m ar-condicionado" + " \n";
		}

		if (this.isQuadroBranco() == false) {
			detalhes += "Esta sala n�o cont�m quadro braco" + " \n";
		} else {
			detalhes += "Esta sala cont�m quadro braco" + " \n";
		}

		if (this.iseLaboratorio() == false) {
			detalhes += "Esta sala n�o � um laborat�rio" + " \n";
		} else {
			detalhes += "Esta sala � um laborat�rio" + " \n";
		}

		return detalhes;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public void verificarVagas() {
		// TODO Auto-generated method stub

	}

	@Override
	public Pessoa inscreverEvento() {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void reservarParaEnvento() {
		// TODO Auto-generated method stub

	}



}
