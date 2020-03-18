package principal;


import java.util.ArrayList;

import java.util.Scanner;

import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.*;
import serializacao.CriarArquivoSequencial;
import serializacao.LerArquivoSequencial;

public class Principal {

	public static String Print(Pessoa p) {

		return p.toString();
	}


	public static ArrayList<Aluno> adicionarListaAlunos() {
		Scanner ler = new Scanner(System.in);		
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		ArrayList<Turma> turmas = new ArrayList<Turma>(); 
		
		System.out.printf("Informe a quantidade de alunos a serem cadastrados: ");
		int qtdAlunos = ler.nextInt();

		for (int i = 1; i <= qtdAlunos; i++) {

			////////////////////////
			// Cria um objeto aluno//
			////////////////////////

			Aluno aluno = new Aluno();
			Turma turma = new Turma(); 

			System.out.printf("-------------------------------\n");
			System.out.printf(i + "º Aluno \n");
			System.out.printf("-------------------------------\n");

			System.out.printf("Informe o nome do aluno: \n");
			String nomeAluno = ler.next();
			aluno.setNome(nomeAluno);
			
			System.out.printf("Informe o sobrenome do aluno: \n");
			String sobrenomeAluno = ler.next();
			aluno.setSobrenome(sobrenomeAluno);
			
			aluno.gerarNomeCompleto(); 

			System.out.printf("Informe idade do aluno: \n");
			int idadeAluno = ler.nextInt();
			aluno.setIdade(idadeAluno);

			System.out.printf("Informe sexo do aluno: \n");
			char sexoAluno = ler.next().charAt(0);
			aluno.setSexo(sexoAluno);
			
			
			
		
			

			//////////////////
			// Notas do aluno//
			//////////////////

			System.out.printf("Informe a quantidade de notas do aluno: \n");
			int qtdNotas = ler.nextInt();

			for (int cont = 1; cont <= qtdNotas; cont++) {

				System.out.printf("Informe " + cont + "ª nota do aluno: \n");
				double nota = ler.nextDouble();

				System.out.printf("Informe o peso da " + cont + "ª nota do aluno: \n");
				int peso = ler.nextInt();

				aluno.getNotas().add(new Nota(nota, peso));

			}

			//////////////////////
			// Endereços do aluno//
			//////////////////////

			System.out.printf("Informe a quantidade de endereços do aluno: \n");
			int qtdEnderecos = ler.nextInt();

			for (int cont = 1; cont <= qtdEnderecos; cont++) {

				System.out.printf("Informe o CEP do aluno: \n");
				int CEP = ler.nextInt();

				System.out.printf("Informe a rua do aluno: \n");
				String rua = ler.next();

				System.out.printf("Informe o bairro do aluno: \n");
				String bairro = ler.next();

				System.out.printf("Informe a cidade do aluno: \n");
				String cidade = ler.next();

				System.out.printf("Informe o estado do aluno: \n");
				String estado = ler.next();

				aluno.getEnderecos().add(new Endereco(CEP, rua, bairro, cidade, estado));

			}

			aluno.calcularMediaAritimetica();
			aluno.calcularMediaPonderada();
			
			alunos.add(aluno);
			turmas.add(turma); 
		}

		return alunos;

	}
	
	public static Aluno inscreverEvento(Aluno aluno){
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println("Deseja inscrever o aluno? (s/n)");
		char resp = ler.next().charAt(0);		
			
			
			
			try {
				if (resp == 's') {
					aluno.setInscricaoEvento(true);
					
				} else if (resp == 'n') {
					aluno.setInscricaoEvento(false);
					
				} 
			} catch (Exception e) {
				System.out.println("Dado inválido, digite novamente");
			}
			
			return aluno;
			
	}
	
	
	public static ArrayList<Professor> adicionarListaProfessores() {

		Scanner ler = new Scanner(System.in);

		ArrayList<Professor> professores = new ArrayList<Professor>();

		System.out.printf("Informe a quantidade de professores a serem cadastrados: ");
		int qtdProfessores = ler.nextInt();

		for (int i = 1; i <= qtdProfessores; i++) {

			////////////////////////////
			//Cria um objeto professor//
			////////////////////////////

			Professor professor = new Professor();

			System.out.printf("-------------------------------\n");
			System.out.printf(i + "º Professor \n");
			System.out.printf("-------------------------------\n");

			System.out.printf("Informe o nome do professor: \n");			
			professor.setNome(ler.next());

			System.out.printf("Informe o sobrenome do professor: \n");
			professor.setSobrenome(ler.next());
			
			professor.gerarNomeCompleto();

			professores.add(professor);

		}

		return professores;

	}
	
	public static  ArrayList<Sala> adicionarSala(){

		Scanner ler = new Scanner(System.in); 		
		ArrayList<Sala> sala = new ArrayList<Sala>(); 
		
		System.out.println("Quantas salas deseja cadastrar ");
		int qtd = ler.nextInt(); 		
		
		
		for (int i = 1; i<=qtd; i++){
				Sala salas = new Sala(i); 
				System.out.println("---------------------------");
				System.out.println("Sala de número "+ i);
				System.out.println("---------------------------");
				
				System.out.println("Digite a capacidade de alunos ");
				salas.setCapacidadeAlunos(ler.nextInt());
				
				boolean itworks = false; 
				
				//ATRIBUTOS BOLEANOS; 
				
			do{
				System.out.println("A sala possui ar-condicionado? s/n");
				char resp = ler.next().charAt(0); 
				
				try{
					
					if (resp == 's'){
					
						itworks = true;
						salas.setArCondicionado(true); 
					
					}else if(resp == 'n'){
					
						salas.setArCondicionado(false);
						itworks = true;
					
					}
				
				}catch(Exception e){
						System.out.println("Dado inválido");
						itworks = false;
				}
				
			}while(itworks == false);
			
			
			do{
				System.out.println("A sala é um laboratório? s/n");
				char resp = ler.next().charAt(0); 
				
				try{
					
					if (resp == 's'){
					
						itworks = true;
						salas.seteLaboratorio(true); 
					
					}else if(resp == 'n'){
					
						salas.seteLaboratorio(false); 
						itworks = true;
					
					}
				
				}catch(Exception e){
						System.out.println("Dado inválido");
						itworks = false;
				}
				
			}while(itworks == false);
			
			do{
				System.out.println("A sala tem quadro branco? s/n");
				char resp = ler.next().charAt(0); 
				
				try{
					
					if (resp == 's'){
					
						itworks = true;
						salas.setQuadroBranco(true); 
					
					}else if(resp == 'n'){
					
						salas.setQuadroBranco(false);  
						itworks = true;
					}
				
				}catch(Exception e){
						System.out.println("Dado inválido");
						itworks = false;
				}
				
			}while(itworks == false);
			
			sala.add(salas);	
		}
		
		return sala; 
	}
	
	
	public static ArrayList<Disciplina> adicionarListaDisciplinas(){
		Scanner ler = new Scanner (System.in); 
		
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>(); 
		
		System.out.println("Quantas Disciplinas deseja cadastrar");
		int qtdDisciplinas = ler.nextInt(); 
		
		for (int i = 0; i< qtdDisciplinas; i++){
			
			Disciplina disciplina = new Disciplina();
			
			System.out.println("===DADOS DA DISCIPLINA====");
			Disciplina disc = new Disciplina(); 
			
			System.out.println("Digite o nome da disciplina");
			disciplina.setNome(ler.next().charAt(0));
			
			
			System.out.println("Digite a carga horária da disciplina");
			disciplina.setCargaHoraria(ler.nextInt());			
			
			
			
			disciplinas.add(disciplina);
			
			
		}
		
		return disciplinas;
	}
	
	public static Turma adicionarTurma(ArrayList<Aluno> alunos,ArrayList<Professor> professores, ArrayList<Sala> salas, ArrayList<Disciplina> disciplinas){
		
		Scanner ler = new Scanner(System.in);
		
		Turma turma = new Turma(); 
				
		System.out.println("------------------------------");
		System.out.println("Turma");			
		System.out.println("------------------------------");
			
			
		System.out.println("Digite o nome da turma");
		turma.setNome(ler.next());
			
		System.out.println("Digite o período ");
		turma.setPeriodo(ler.nextInt());
			
		turma.setAlunos(alunos);
		
		//PROFESSOR DA TURMA//			
		
		System.out.println("=LISTA DE PROFESSORES=");
			
		int contadorprofessor = 1;
		for (Professor professor:professores){	
			
			professor.gerarNomeCompleto();
			System.out.println("Professor: (" + contadorprofessor + ") " + professor.getNomeCompleto());
			contadorprofessor += 1;
		}			
		System.out.println("Selecione um dos professores a partir de seu código:");
		turma.setProfessor(professores.get(ler.nextInt()-1));
		
			
		System.out.println("=LISTA DE SALAS=");
		
		int contadorsala = 1; 				
			for (Sala sala: salas){
				System.out.print("Sala: ("+contadorsala + ") " + sala.getNumero());
				contadorsala+= 1;
			}		
		System.out.println("Selecione uma das salas a partir de seu código:");
		turma.setSalas(salas.get(ler.nextInt()-1));			
			
		
		System.out.println("=LISTA DE ALUNOS=");
		
			for(Aluno aluno: alunos){
				System.out.println("Aluno: "+aluno.getNomeCompleto());				
			}
		turma.setAlunos(alunos);		
		
		System.out.println("=LISTA DE DISCIPLINAS");
			
		int contadordisciplinas = 1;
			for(Disciplina disciplina: disciplinas){
				System.out.println("Disciplina: ("+contadordisciplinas+") "+disciplina.getNome());
			}
		System.out.println("Selecione a disciplina a partir do seu código: ");
		turma.setDisciplina(disciplinas.get(ler.nextInt()-1));
		
			turma.calcularMediaTurma(); 		
		
		return turma;
		
	}
	
	
	
	

	public static void main(String[] args) {
		Aluno aluno = new Aluno(); 
		Scanner ler = new Scanner(System.in);		 
		
		
		
		System.out.printf("Informe o nome da instituição de ensino: ");
		Aluno.setNomeInstituicao(ler.next());	
	
		ArrayList<Aluno> alunos = adicionarListaAlunos();
		
		aluno = inscreverEvento(aluno); 
		
		
		ArrayList<Professor> professores = adicionarListaProfessores(); 		
		
		ArrayList<Sala> salas = adicionarSala(); 
		
		ArrayList<Disciplina> disciplinas = adicionarListaDisciplinas();
		
		Turma turma = adicionarTurma(alunos,professores, salas, disciplinas); 
		
		CriarArquivoSequencial.salvarRegistro(turma); 
		
		
	

		//////////////////////////////
		// Imprimir os dados do aluno//
		//////////////////////////////

		
	

		/*for (Aluno aluno : alunos) {
			System.out.printf("------------------------------ \n");
			System.out.printf("Aluno \n");
			System.out.printf(aluno.toString());
		}*/
		
		
		
		System.out.printf("------------------------------ \n");
		System.out.printf("Turma \n");
		System.out.printf(turma.toString());	
		
		
		
		/*for (Sala sala: salas){
			System.out.printf("----------------------------- \n");
			System.out.println("Sala \n");
			System.out.println(salas.toString());
		}*/
		

		ler.close();

	}
}
