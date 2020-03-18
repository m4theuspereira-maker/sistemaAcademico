package principal;

import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable {
	
	/////////////
	//Atributos//
	/////////////
		
	private String nome;
	private int periodo;
	private double mediaTurma;
	
	private Professor professor; 								//Associação Estrutural - Agregação - A partir de atributo
	private Disciplina disciplina; 								//Associação Estrutural - Agregação - A partir de atributo
	private Sala sala = new Sala();
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>(); 	//Associação Estrutural - Agregação - A partir de atributo

	//Gets e Sets//
	///////////////
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	

	public double getMediaTurma() {
		return this.mediaTurma;
	}

	public void setMediaTurma(double mediaTurma) {
		this.mediaTurma = mediaTurma;
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public ArrayList<Aluno> getAlunos() {
		return this.alunos;
	}
	
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	

	public Sala getSalas() {
		return sala;
	}

	public void setSalas(Sala salas) {
		this.sala = salas;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professores) {
		this.professor = professores;
	}
	
	public double calcularMediaTurma() {
		double somatorio = 0;
		
		for (Aluno aluno: this.alunos) {
			somatorio += aluno.calcularMediaAritimetica();
		}
		this.setMediaTurma(somatorio / this.alunos.size());
		return this.getMediaTurma();
	}
		
		public String toString(){
			String detalhes = ""; 
			
			detalhes += "Nome da turma: "+ this.getNome()+" \n"; 
			detalhes += "Período: "+ this.getPeriodo()+"º"+" \n"; 	
			professor.gerarNomeCompleto();
			detalhes+= "Professor cadastrado " + professor.getNomeCompleto() + "\n"; 
			detalhes += "Média da turma: "+ this.calcularMediaTurma()+" \n";
			detalhes += "Sala da turma"+ this.sala.getNumero()+ "/n";
			detalhes += "Disciplina: " +this.disciplina.getNome()+ "/n"; 		
			 
			return detalhes; 
		}

	
	
}
