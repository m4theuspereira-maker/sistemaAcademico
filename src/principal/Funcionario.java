package principal;

public abstract class Funcionario extends Pessoa {
	
	private int cargaHoraria; 
	private float salario;

	///////////////
	//Gets e Sets//
	///////////////

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
