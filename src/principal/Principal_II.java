package principal;

import java.util.Scanner; 
import interfaces.Iinscricoes;

public class Principal_II {
	

	public static Professor adicionarProf(){
		Professor professor = new Professor(); 
		Scanner s = new Scanner (System.in); 
		
		System.out.println("DADOS DO PROFESSOR");
		
		System.out.println("Digite o nome do professor ");
		professor.setNome(s.next()); 
		
		
		return professor;
	}
	
	public static String iniciarPesquisa (Professor prof){		
		
		String  dados ="A pesquisa do "+prof.getNome()+" foi iniciada";
		
		return dados; 
	}
	
	public static boolean aprovarPesquisa(Professor prof){
		Scanner s = new Scanner(System.in); 
				
		char aprovar ; 
		boolean itWorks = false;
			 
		do{
			
			System.out.println("Deseja aprovar a pesquisa do professor "+prof.getNome()+" s/n");
			aprovar = s.next().charAt(0); 
							
			try {
				
				if (aprovar == 's'){
					itWorks = true; 
					prof.setPesqisaAprovada(true);
					return true;
				
			
				}else if(aprovar == 'n'){
					
					itWorks = true; 
					prof.setPesqisaAprovada(false);
					return false;
					
		
			}
		}catch(Exception e ){
			System.out.println("Dado inválido");
			itWorks = false; 
		}
		
		}while(itWorks == false);
		
		return false; 
		
	}
	
	public static void lancarPesquisa(Professor prof){
		Scanner s = new Scanner(System.in); 
		
		float notaPesquisa = 0;
		boolean itWorks = false; 
		if (prof.isPesqisaAprovada() == false){
			System.out.println("Não é possível lançar uma esquisa reprovada");
			
		}else{
		
		do{
		
				try{
			
					System.out.println("Qual a nota da pesquisa do professor "+prof.getNome()+" de 0 a 10");
					notaPesquisa = s.nextFloat(); 
					itWorks = true; 
		
					if (notaPesquisa >= 7.0 && prof.isPesqisaAprovada() == true){
						System.out.println("Psquisa do professor "+prof.getNome()+ " lançada com sucesso");
						itWorks = true; 
					}else if(notaPesquisa < 7.0 && prof.isPesqisaAprovada() == true){
						System.out.println("Não é possível lançar a pesquisa, nota abaixo de 7,0");
						itWorks = true; 
					}
				}catch(Exception e){
					System.out.println("Dado inválido");
					itWorks = false; 
				}
		
			}while(itWorks == false); 
		}
	} 
	
	public static Iinscricoes inscreverEnem(Iinscricoes objeto){	
		
		System.out.println("Inscrevendo no Enem");			
		
		return objeto; 
	}
	

	public static void main(String[] args) { 
		
		
		Professor prof = adicionarProf(); 
		
		System.out.println(iniciarPesquisa(prof)); 
		
		aprovarPesquisa(prof); 
		
		lancarPesquisa(prof); 
		
		inscreverEnem(prof); 
	
		

	}

}
