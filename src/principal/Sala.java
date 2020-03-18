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

	// construtor padrão
	public Sala(int numero, int capacidade, boolean arCondicionado, boolean quadroBranco, boolean eLaboratorio) {
		super();
		this.numero = numero;
		this.vagas = capacidade;
		this.arCondicionado = arCondicionado;
		this.quadroBranco = quadroBranco;
		this.eLaboratorio = eLaboratorio;
	}

	// construtor só apra ser usado no for
	public Sala(int numero) {
		this.numero = numero;
	}

	// construtor vazio só para ser instânciado
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
		detalhes += "Número da Sala: " + this.getNumero() + " \n";
		detalhes += "Quantidade de vagas para novas turmas " + this.getCapacidadeAlunos() + " \n";

		if (this.isArCondicionado() == false) {
			detalhes += "Esta sala não contém ar-condicionado" + " \n";
		} else {
			detalhes += "Esta sala contém ar-condicionado" + " \n";
		}

		if (this.isQuadroBranco() == false) {
			detalhes += "Esta sala não contém quadro braco" + " \n";
		} else {
			detalhes += "Esta sala contém quadro braco" + " \n";
		}

		if (this.iseLaboratorio() == false) {
			detalhes += "Esta sala não é um laboratório" + " \n";
		} else {
			detalhes += "Esta sala é um laboratório" + " \n";
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
