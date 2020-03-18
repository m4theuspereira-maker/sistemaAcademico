package principal;

import java.io.Serializable;

public class Endereco implements Serializable {

	///////////////////////////////////////
	//Atributos de instância ou do objeto//
	//////////////////////////////////////
	
	private int CEP;	
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	///////////////
	//Gets e Sets//
	///////////////
		
	public int getCEP() {
		return this.CEP;
	}
	
	public void setCEP(int CEP) {
		this.CEP = CEP;
	}
	
	public String getRua() {
		return this.rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	////////////////
	//Construtores//
	////////////////
	
	public Endereco(int CEP, String rua,String bairro,String cidade, String estado) {
		this.CEP = CEP;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		String detalhes = "";
		detalhes += "CEP: " + this.getCEP() + " \n";
		detalhes += "Rua: " + this.getRua() + " \n";
		detalhes += "Bairro: " + this.getBairro() + " \n";
		detalhes += "Cidade: " + this.getCidade() + " \n";
		detalhes += "Estado: " + this.getEstado() + " \n";
		return detalhes;
	}
	
	
}
