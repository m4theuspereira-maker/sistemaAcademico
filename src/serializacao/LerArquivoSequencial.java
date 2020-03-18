package serializacao;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import principal.*; //Importar as classes do pacote principal

public class LerArquivoSequencial {

	private static ObjectInputStream input;

	private static String nomeArquivo = "turma.dat";

	public static void lerRegistros(Serializable objeto) {

		try {
			while (true) // faz um loop at� ocorrer uma EOFException
			{
			 objeto = (Serializable) input.readObject();
				
				// exibe o conte�do de registro
				System.out.println("---------------dados----------------");	
				System.out.println(objeto.toString());
				;
				// System.out.printf(aluno.getNotas().toString());
			}
		} catch (EOFException endOfFileException) {
			System.out.println("------------------------------------");
			System.out.println("N�o h� mais registros");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Tipo de objeto inv�lido. Terminando.");
		} catch (IOException ioException) {
			System.err.println("Erro ao ler do arquivo. Terminando.");
		}
	}

	public static void main(String[] args) {

		// Exemplo de c�digo defensivo, usando a t�cnica de separa��o de cada
		// a��o em um m�todo diferente

		abrirArquivo();
		lerRegistros(args);
		fecharArquivo();
	}

	// permite que o usu�rio selecione o arquivo a abrir
	public static void abrirArquivo() {
		try // abre o arquivo
		{
			input = new ObjectInputStream(Files.newInputStream(Paths.get(nomeArquivo)));
		} catch (IOException ioException) {
			System.err.println("Erro ao abrir o arquivo.");
			System.exit(1);
		}
	}

	// l� o registro no arquivo
	/*
	 * public static void lerRegistros() {
	 * 
	 * try { while (true) // faz um loop at� ocorrer uma EOFException { Aluno
	 * aluno = (Aluno) input.readObject();
	 * 
	 * // exibe o conte�do de registro
	 * System.out.println("---------------Aluno----------------");
	 * System.out.println(aluno.getNome());
	 * System.out.println(aluno.getSobrenome());
	 * System.out.println(aluno.getEnderecos().toString());
	 * //System.out.printf(aluno.getNotas().toString()); } } catch (EOFException
	 * endOfFileException) {
	 * System.out.println("------------------------------------");
	 * System.out.println("N�o h� mais registros"); } catch
	 * (ClassNotFoundException classNotFoundException) {
	 * System.err.println("Tipo de objeto inv�lido. Terminando."); } catch
	 * (IOException ioException) {
	 * System.err.println("Erro ao ler do arquivo. Terminando."); } } // fim do
	 * m�todo readRecords
	 */

	// fecha o arquivo e termina o aplicativo

	public static void fecharArquivo() {
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException ioException) {
			System.err.println("Erro ao fechar o arquivo. Terminando.");
			System.exit(1);
		}
	}

}
