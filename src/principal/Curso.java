package principal;

import java.util.ArrayList;

public abstract class  Curso {
	
	/////////////
	//Atributos//
	/////////////

	private int cargaHoraria;
	private String nome;
	private int duracao;
	private ArrayList<Professor> professores = new ArrayList<Professor>(); //Associação Estrutural - Agregação - A partir de atributo
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>(); //Associação Estrutural - Agregação - A partir de atributo
	
	///////////////
	//Gets e Sets//
	///////////////
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public ArrayList<Professor> getProfessores() {
		return this.professores;
	}
	
	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
	
	
}
