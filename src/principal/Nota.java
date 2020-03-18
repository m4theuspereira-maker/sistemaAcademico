package principal;

import java.io.Serializable;

public class Nota implements Serializable{
	
	///////////////////////
	//Atributos de Objeto//
	///////////////////////

	public double valor;	
	
	public int peso;
	
	///////////////
	//Gets e Sets//
	///////////////
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	////////////////
	//Construtores//
	////////////////
	
	public Nota(double nota, int peso) {
		this.valor = nota;
		this.peso = peso;
	}
		
	
	
	
}
