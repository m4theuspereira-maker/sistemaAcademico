package principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import interfaces.Iinscricoes;
import interfaces.Ipesquisa;

public class Aluno extends Pessoa implements Ipesquisa, Iinscricoes, Serializable {
	
	///////////////////////////////////////
	//Atributos de instância ou do objeto//
	//////////////////////////////////////
		
	//Os atributos são as características dos objetos e geralmente são representados por substantivos (Ex.: nome, idade etc..)
	//Os atributos são responsáveis por "armazenar" informações do objeto e podem ser manipulados diretamente ou pelos métodos
	//Os atributos devem estar associados a um tipo (primitivo ou não) Ex.: int, boolean, String ou outras classes
	//Os atributos possuem visibilidade (public, private e protected ) Obs.: Quando um atributo não possui uma visibilidade definida ele é public
	//A visibilidade private é usada para alcançar o conceito de encapsulamento
	
	private String situacao;
	private boolean aprovado;
	private double media;
	private double mediaPonderada;

	
	
	//Associação entre classes através de atributos
	//O atributo notas é uma arraylist (coleção) do tipo/classe Nota
	//Associação Estrutural - Composição - A partir de atributo
	private ArrayList<Nota> notas = new ArrayList<Nota>(); 
	//Atributo estático ou atributo da classe
	private static int quantidadeAlunos = 0; 
	private static String nomeInstituicao = "IFS";
	
	////////////////
	//Construtores//
	////////////////
	
	//Os construtores são métodos especiais que possuem o mesmo nome da classe
	//É possível construir um objeto do mesmo tipo de formas diferentes, com construtores diferentes, esse fenômeno está associado ao conceito de sobrecarga de métodos (Polimorfismo estático)
	//O Polimorfismo Estático se dá quando temos a mesma operação (métodos) implementada várias vezes na mesma classe. A escolha de qual operação será chamada depende da assinatura (identificador do método, parâmetros) dos métodos sobrecarregados
	
	public Aluno() {
		super();
		this.setMatricula(this.gerarMatricula()); 
	}
	
	//Os construtores são métodos, portanto é possível criar dentro deles um conjunto de códigos complexo (atribuir valores a atributos, chamar métodos da classe, criar variáveis, loops, condições - IF etc..)
	public Aluno(String nome, String sobrenome, int idade,  char sexo, double nota1, double nota2, double nota3, int[] pesos) {
		this.setMatricula(this.gerarMatricula()); 
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setNomeCompleto(nome + sobrenome);
		this.setIdade(idade);
		this.setSexo(sexo); 
		
		//Adiciona notas passadas por parâmetro para o atributo notas da classe aluno
		this.notas.add(new Nota(nota1, pesos[0]));
		this.notas.add(new Nota(nota2, pesos[1]));
		this.notas.add(new Nota(nota3, pesos[2]));
		
		//Executa os métodos de calculo de média
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
	
	//Os Gets e Sets são métodos usados para manipular os atributos da classe
	//São importantes para alcançar o conceito de encapsulamento
	//Cada atributo geralmente possui o seu respectivo get e set, onde o get é usado para recuperar o valor armazenado no atributo e o set usado para armazernar um valor no atributo
	
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
	//Métodos//
	///////////
	
	//Os métodos são os comportamentos, as ações das classes, geralmente são representados com verbos
	
	
	//O métodos toString() é uma forma de polimorfismo dinâmico, que chamamos de sopreposição, já que esse método é definido na classe object
	//O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o método original.
	@Override
	public String toString() {
		String detalhes = "";
		detalhes += super.toString();
		
		int i = 1;
		for (Nota nota: this.notas) {
			detalhes += "\n nota " + i + ": " + nota.valor + " \n";
			i++;
		}
		
		detalhes += "Media Aritimética: " + this.media + " \n";
		detalhes += "Media Ponderada: " + this.mediaPonderada + " \n";
		detalhes += "Situacao: " + this.situacao + " \n";
		detalhes += "Nome da Instituição: " + Aluno.getNomeInstituicao() + " \n";
		return detalhes;
	
	}
	
	
	// O método gerarMatricula é uma sobrescrita
	// A implementação do método gerarMatricula na classe Aluno sobrescreve o método abstrato definido na classe Pessoa
	
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
			this.situacao = "Recuperação";
			this.aprovado = false;
		}
		else {
			this.situacao = "Reprovado";
			this.aprovado = false;
		}
		
	}
	
	//O métodos equals() é uma forma de polimorfismo dinâmico, que chamamos de sopreposição, já que esse método é definido na classe object
	//O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o método original.
	public boolean equals(Aluno aluno) {
		boolean isEqual = false;
		if (aluno instanceof Aluno) {
			if (this.getMatricula() == aluno.getMatricula()) {
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	//Método que incrementa o atributo estático quantidadeAlunos 
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
