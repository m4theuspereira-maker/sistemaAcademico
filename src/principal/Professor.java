package principal;

import java.io.Serializable;
import java.util.Random;
import  interfaces.Iinscricoes;

public class Professor extends Funcionario implements Iinscricoes, Serializable  {
	
	///////////
	//Métodos//
	///////////

	@Override
	protected
	int gerarMatricula() {
		Random gerador = new Random();
		return gerador.nextInt(100);
	}

	@Override
	public Pessoa inscreverEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reservarParaEnvento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verificarVagas() {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
