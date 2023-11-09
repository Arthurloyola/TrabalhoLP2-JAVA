package LP2TRABALHOFINAL;

import java.util.Scanner;

public class Menu {
	static Scanner leitura = new Scanner(System.in);
	
	static int menu(){
		System.out.println("************************************");
		System.out.println("*************** MENU ***************");
		System.out.println("1 - CADASTRAR ");
		System.out.println("2 - CONSULTAR ");
		System.out.println("3 - LOCACAO ");
		System.out.println("0 - Sair");
		System.out.println("Escolha a opção: ");
		System.out.println("************************************");
		System.out.println("************************************");
		return Integer.parseInt(leitura.nextLine());
	}
	
	static int menuCadastro(){
		System.out.println("*****************************************");
		System.out.println("*************** CADASTRAR ***************");
		System.out.println("1 - FILME ");
		System.out.println("2 - CLIENTE ");
		System.out.println("0 - Sair");
		System.out.println("Escolha a opção: ");
		System.out.println("******************************************");
		System.out.println("******************************************");
		return Integer.parseInt(leitura.nextLine());
	}
	
	static int menuConsulta(){
		System.out.println("*****************************************");
		System.out.println("*************** CONSULTAR ***************");
		System.out.println("1 - ATRASOS ");
		System.out.println("2 - CONSULTAR FILME ");
		System.out.println("3 - CONSULTAR CLIENTE ");
		System.out.println("0 - Sair");
		System.out.println("Escolha a opção: ");
		System.out.println("******************************************");
		System.out.println("******************************************");
		return Integer.parseInt(leitura.nextLine());
	}

	static int menuLocacao(){
		System.out.println("*****************************************");
		System.out.println("*************** LOCACAO ***************");
		System.out.println("1 - LOCACAO ");
		System.out.println("2 - DEVOLUCAO ");
		System.out.println("0 - Sair");
		System.out.println("Escolha a opção: ");
		System.out.println("******************************************");
		System.out.println("******************************************");
		return Integer.parseInt(leitura.nextLine());
	}
}
