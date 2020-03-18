package principal;

import java.io.Serializable;

public class Disciplina implements Serializable{
	
	/////////////
	//Atributos//
	/////////////
	
	private int cargaHoraria;
	private char nome;
	
	///////////////
	//Gets e Sets//
	///////////////
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public char getNome() {
		return this.nome;
	}
	
	public void setNome(char nome) {
		this.nome = nome;
	}
	
	
}
