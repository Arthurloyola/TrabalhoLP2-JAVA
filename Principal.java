package LP2TRABALHOFINAL;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		Filme filme = new Filme();
		Cliente cliente= new Cliente();
		Locadora locadora = new Locadora();
		Scanner leitura = new Scanner(System.in);
		int opcaoPrincipal=100,opcaoCadastro=100, opcaoConsulta=100, opcaoLocacao=100;
		String nome, a;
		

		while((opcaoPrincipal=Menu.menu())!=0)
		{
			switch(opcaoPrincipal)
			{

			case 1:

				while((opcaoCadastro=Menu.menuCadastro())!=0) 
				{
					switch(opcaoCadastro)
					{
					
					case 1:
						filme.cadastroFilme();
						break;
					case 2:
						cliente.cadastroCliente();
						break;
					case 3:	
						break;
					case 0:
						break;
					default:
						System.out.println("Opção inválida!");
					}
				}
				break;

			case 2: 
				
				while((opcaoConsulta=Menu.menuConsulta())!=0) 
				{
					switch(opcaoConsulta)
					{
					case 1:
						locadora.consultarAtrasos();
						break;
					case 2:
						locadora.consultarFilmes();
						break;
					case 3:	
						locadora.consultarClientes();
						break;	
					case 0:
						break;
					default:
						System.out.println("Opção inválida!");

					}
				}
				break;
				
			case 3:
				while((opcaoLocacao=Menu.menuLocacao())!=0) 
				{
					switch(opcaoLocacao)
					{
					case 1:
						locadora.locar();
						break;
					case 2:
						locadora.devolverFilmes();
						break;
					case 3:	
						break;	
					case 0:
						break;
					default:
						System.out.println("Opção inválida!");

					}
				}
				
				
				
			case 0:
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
		System.out.println("Fim de programa!");
		leitura.close();
	}
}