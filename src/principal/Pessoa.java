package principal;

import java.util.ArrayList;

import interfaces.Iinscricoes;

public abstract class Pessoa{
	
	private int matricula;	
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	private int idade;
	private char sexo;
	private String CPF;
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();  //Associação Estrutural - Composição - A partir de atributo
	private boolean inscricaoEvento; 
	private boolean pesqisaAprovada; 
	private boolean inscreverEnem; 
	
	public Pessoa(String nome, String sobenome,  int idade, char sexo){
		
		
	}

	
	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	
	public Pessoa() {
		this.gerarCPF();
	}
	
	

	///////////
	//Métodos//
	///////////
	
	public void gerarNomeCompleto(){
		
		String NomeCompleto = this.getNome() + " " + this.getSobrenome();
		this.setNomeCompleto(NomeCompleto);
		
	}

	

	@Override
	public String toString() {
		String detalhes = "";
		detalhes += "Matricula: " + this.getMatricula() + " \n";
		detalhes += "Nome: " + this.getNome() + " \n";
		detalhes += "SobreNome: " + this.getSobrenome() + " \n";
		detalhes += "NomeCompleto: " + this.getNomeCompleto() + " \n";
		detalhes += "idade: " + this.getIdade() + " \n";
		detalhes += "Sexo: " + this.getSexo() + " \n";
		for (Endereco endereco: this.enderecos) {
			detalhes += "Endereços " + endereco.toString() + " \n";
		}
		
		if (this.isInscricaoEvento() == true){
			detalhes += "Inscrito no evento"; 
			
		}else{
			detalhes += "Não inscrito no evento"; 
		}
		
		
		return detalhes;
		
	}
	
	
	
	//Método abstrato - Sem implementação
	//Usado para garantir que as classes que herdem de pessoa possuam uma implementação do gerarMatricula, 
	//assim é possivel que cada classe que herde de pessoa implemente sua forma específica de gerar matricula
	protected abstract int gerarMatricula();
	
	
	//Método Concreto
	//Gerar CPF é igual para todos os tipos de pessoa
	public String gerarCPF() {
		String cpf = GeraCpfCnpj.cpf();  //Associação Comportamental - Dependência com a classe GeraCpfCnpj
		this.setCPF(cpf);
		return cpf;
	}

	public boolean isInscricaoEvento() {
		return inscricaoEvento;
	}

	public void setInscricaoEvento(boolean inscricaoEvento) {
		this.inscricaoEvento = inscricaoEvento;
	}

	public boolean isPesqisaAprovada() {
		return pesqisaAprovada;
	}

	public void setPesqisaAprovada(boolean pesqisaAprovada) {
		this.pesqisaAprovada = pesqisaAprovada;
	}


	public boolean isInscreverEnem() {
		return inscreverEnem;
	}


	public void setInscreverEnem(boolean inscreverEnem) {
		this.inscreverEnem = inscreverEnem;
	}

	

	
}
