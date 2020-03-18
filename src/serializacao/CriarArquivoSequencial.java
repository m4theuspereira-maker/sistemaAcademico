package serializacao;

import principal.Turma;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import principal.*;

public class CriarArquivoSequencial {

	private static ObjectOutputStream output;
	private static String nomeArquivo = "turma.dat";

	public static void main(String[] args) {

		abrirArquivo();
		adicionarRegistro(args);		
		fecharArquivo();
	}

	public static void abrirArquivo() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(nomeArquivo)));

		} catch (IOException ioException) {
			System.err.println("Erro ao abrir o arquivo. Terminando.");
			System.exit(1);
		}
	}

	/*public static void adicionarRegistro() {

		try {

			Aluno aluno = new Aluno();
			aluno.setNome("Diego");
			aluno.setSobrenome("Armando");
			ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
			enderecos.add(new Endereco(123, "Rua A", "Bairro B", "Cidade C", "Estado E"));
			aluno.setEnderecos(enderecos);

			output.writeObject(aluno); // Serializa o objeto aluno em um arquivo

			// Cria novo registro de aluno

			Aluno aluno1 = new Aluno();
			aluno1.setNome("Pedro");
			aluno1.setSobrenome("José");
			output.writeObject(aluno1);

			System.out.println("Arquivo Gravado.");

		} catch (IOException ioException) {
			System.err.println("Erro ao escrever o arquivo.");
			System.out.println(ioException.toString());
		}

	}*/	
	
	
	public static void adicionarRegistro(Serializable objeto) {

		try {
			
			output.writeObject(objeto);

			System.out.println("Arquivo Gravado.");

		} catch (IOException ioException) {
			System.err.println("Erro ao escrever o arquivo.");
			System.out.println(ioException.toString());
		}

	}


	public static void fecharArquivo() {
		try {
			if (output != null) {
				output.close();
			}
		} catch (IOException ioException) {
			System.err.println("Erro ao fechar o arquivo.");
		}
	}
	
	public static void salvarRegistro(Serializable objeto){
		abrirArquivo();
		adicionarRegistro(objeto); 
		fecharArquivo();
	}
}
