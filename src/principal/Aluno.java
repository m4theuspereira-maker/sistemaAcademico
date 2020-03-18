package principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import interfaces.Iinscricoes;
import interfaces.Ipesquisa;

public class Aluno extends Pessoa implements Ipesquisa, Iinscricoes, Serializable {
	
	///////////////////////////////////////
	//Atributos de inst�ncia ou do objeto//
	//////////////////////////////////////
		
	//Os atributos s�o as caracter�sticas dos objetos e geralmente s�o representados por substantivos (Ex.: nome, idade etc..)
	//Os atributos s�o respons�veis por "armazenar" informa��es do objeto e podem ser manipulados diretamente ou pelos m�todos
	//Os atributos devem estar associados a um tipo (primitivo ou n�o) Ex.: int, boolean, String ou outras classes
	//Os atributos possuem visibilidade (public, private e protected ) Obs.: Quando um atributo n�o possui uma visibilidade definida ele � public
	//A visibilidade private � usada para alcan�ar o conceito de encapsulamento
	
	private String situacao;
	private boolean aprovado;
	private double media;
	private double mediaPonderada;

	
	
	//Associa��o entre classes atrav�s de atributos
	//O atributo notas � uma arraylist (cole��o) do tipo/classe Nota
	//Associa��o Estrutural - Composi��o - A partir de atributo
	private ArrayList<Nota> notas = new ArrayList<Nota>(); 
	//Atributo est�tico ou atributo da classe
	private static int quantidadeAlunos = 0; 
	private static String nomeInstituicao = "IFS";
	
	////////////////
	//Construtores//
	////////////////
	
	//Os construtores s�o m�todos especiais que possuem o mesmo nome da classe
	//� poss�vel construir um objeto do mesmo tipo de formas diferentes, com construtores diferentes, esse fen�meno est� associado ao conceito de sobrecarga de m�todos (Polimorfismo est�tico)
	//O Polimorfismo Est�tico se d� quando temos a mesma opera��o (m�todos) implementada v�rias vezes na mesma classe. A escolha de qual opera��o ser� chamada depende da assinatura (identificador do m�todo, par�metros) dos m�todos sobrecarregados
	
	public Aluno() {
		super();
		this.setMatricula(this.gerarMatricula()); 
	}
	
	//Os construtores s�o m�todos, portanto � poss�vel criar dentro deles um conjunto de c�digos complexo (atribuir valores a atributos, chamar m�todos da classe, criar vari�veis, loops, condi��es - IF etc..)
	public Aluno(String nome, String sobrenome, int idade,  char sexo, double nota1, double nota2, double nota3, int[] pesos) {
		this.setMatricula(this.gerarMatricula()); 
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setNomeCompleto(nome + sobrenome);
		this.setIdade(idade);
		this.setSexo(sexo); 
		
		//Adiciona notas passadas por par�metro para o atributo notas da classe aluno
		this.notas.add(new Nota(nota1, pesos[0]));
		this.notas.add(new Nota(nota2, pesos[1]));
		this.notas.add(new Nota(nota3, pesos[2]));
		
		//Executa os m�todos de calculo de m�dia
		this.calcularMediaAritimetica();
		this.calcularMediaPonderada();
		
		
		this.incrementarQuantidadeAlunos();
	}
	
	public Aluno(String nome) {
		this.setNome(nome);
	}
	
	///////////////
	//Gets e Sets//
	///////////////
	
	//Os Gets e Sets s�o m�todos usados para manipular os atributos da classe
	//S�o importantes para alcan�ar o conceito de encapsulamento
	//Cada atributo geralmente possui o seu respectivo get e set, onde o get � usado para recuperar o valor armazenado no atributo e o set usado para armazernar um valor no atributo
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getMediaPonderada() {
		return mediaPonderada;
	}

	public void setMediaPonderada(double mediaPonderada) {
		this.mediaPonderada = mediaPonderada;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public static int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public static void setQuantidadeAlunos(int quantidadeAlunos) {
		Aluno.quantidadeAlunos = quantidadeAlunos;
	}

	public static String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public static void setNomeInstituicao(String nomeInstituicao) {
		Aluno.nomeInstituicao = nomeInstituicao;
	}
	
	///////////
	//M�todos//
	///////////
	
	//Os m�todos s�o os comportamentos, as a��es das classes, geralmente s�o representados com verbos
	
	
	//O m�todos toString() � uma forma de polimorfismo din�mico, que chamamos de sopreposi��o, j� que esse m�todo � definido na classe object
	//O Polimorfismo Din�mico acontece na heran�a, quando a subclasse sobrep�e o m�todo original.
	@Override
	public String toString() {
		String detalhes = "";
		detalhes += super.toString();
		
		int i = 1;
		for (Nota nota: this.notas) {
			detalhes += "\n nota " + i + ": " + nota.valor + " \n";
			i++;
		}
		
		detalhes += "Media Aritim�tica: " + this.media + " \n";
		detalhes += "Media Ponderada: " + this.mediaPonderada + " \n";
		detalhes += "Situacao: " + this.situacao + " \n";
		detalhes += "Nome da Institui��o: " + Aluno.getNomeInstituicao() + " \n";
		return detalhes;
	
	}
	
	
	// O m�todo gerarMatricula � uma sobrescrita
	// A implementa��o do m�todo gerarMatricula na classe Aluno sobrescreve o m�todo abstrato definido na classe Pessoa
	
	@Override
	public int gerarMatricula() {
		 Random gerador = new Random();
		 return gerador.nextInt(1000); 
	} 
	 
	public double calcularMediaAritimetica() {
		double somatorio = 0;
	
		for (Nota nota: this.notas) {
			somatorio += nota.valor;
		}
		this.media = somatorio / this.notas.size();
		this.calcularSituacao();
		return this.media;
	}
	
	public void calcularMediaPonderada() {
		double somatorio = 0;
		double somatorioPesos = 0;
		
		for (Nota nota: this.notas) {
			somatorio += nota.valor * nota.peso;
			somatorioPesos += nota.peso;
		}
		
		this.mediaPonderada = somatorio / somatorioPesos;	
		this.calcularSituacao();
	}
	
	private void calcularSituacao() {
		
		if (this.media >= 7) {
			this.situacao = "Aprovado";
			this.aprovado = true;
		}
		else if (this.media >= 5 && this.media < 7) {
			this.situacao = "Recupera��o";
			this.aprovado = false;
		}
		else {
			this.situacao = "Reprovado";
			this.aprovado = false;
		}
		
	}
	
	//O m�todos equals() � uma forma de polimorfismo din�mico, que chamamos de sopreposi��o, j� que esse m�todo � definido na classe object
	//O Polimorfismo Din�mico acontece na heran�a, quando a subclasse sobrep�e o m�todo original.
	public boolean equals(Aluno aluno) {
		boolean isEqual = false;
		if (aluno instanceof Aluno) {
			if (this.getMatricula() == aluno.getMatricula()) {
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	//M�todo que incrementa o atributo est�tico quantidadeAlunos 
	private void incrementarQuantidadeAlunos() {
		++Aluno.quantidadeAlunos;
	}

	@Override
	public String iniciarPesquisa() {
		return null;
		
	}

	@Override
	public void avaliarPesquisa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean aprovarPesquisa() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void lancarPesquisa() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void verificarVagas() {
		
		
	}

	

	@Override
	public void reservarParaEnvento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluno inscreverEvento() {
		// TODO Auto-generated method stub
		return null;
		
	}


	
	


	
	
}
