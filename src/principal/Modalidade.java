package principal;

abstract class Modalidade{
		
	private String nome; 
	private int codigo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String toString(){
		String detalhes = ""; 
		
		detalhes += "Modalidade" +this.getNome(); 
		detalhes += "Código"+ this.getCodigo(); 
		
		
		return  detalhes; 
	}
	
	
}
