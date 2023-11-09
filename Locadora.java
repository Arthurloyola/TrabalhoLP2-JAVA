package LP2TRABALHOFINAL;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Locadora  {

	String linha, fimloopConsultaAtraso, fimloopConsultaFilme,fimloopConsultaCliente, consultaFilme="", consultaCliente="",nomeFilmeWrite="",nomeClienteWrite="";
	int codFilme,codFilmeWrite,codClinteWrite,codlocacao;
	Scanner arquivoFilmeR = null;
	Scanner arquivoClienteR = null;
	Scanner arquivoLocacaoR = null;
	Scanner arquivoAtrasosR = null;
	Scanner ler= new Scanner(System.in);
	LocalDate dataLocacao, dataDevolucao, dataAtrasos;
	Date hoje  = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	Calendar calend = Calendar.getInstance ();
	Date a = new Date(); 
	
	
	
	public Locadora() {
		super();

	}

	public void locar() {
		
		
		boolean existeFilmes = false,existecliente = false;
		try {
			PrintWriter arquivoLocacaoW = null;
			
			FileWriter escreverArquivo = new FileWriter("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\locadora.txt", true); 
			arquivoLocacaoW = new PrintWriter(escreverArquivo);
			
			FileReader inCliente = new FileReader("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\cliente.txt");
			arquivoClienteR = new Scanner(inCliente);
			
			FileReader inFilme = new FileReader("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\filme.txt");
			arquivoFilmeR = new Scanner(inFilme);

			do {
				System.out.println("_____________________________________________");
				System.out.println("      Realizando a Locacao                   ");
				System.out.println("_____________________________________________");
				System.out.println("Digite o Nome do Filme que sera locado");
				consultaFilme=ler.nextLine().toLowerCase();
				System.out.println("Digite o codigo do Filme que sera locado");
				codFilme=Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Nome do Cliente que esta locando");
				consultaCliente=ler.nextLine().toLowerCase();


				while(arquivoFilmeR.hasNext())			
				{
					linha = arquivoFilmeR.nextLine();
					String[] valorComSplit = linha.split("-");


					if(consultaFilme.equals(valorComSplit[1])&& codFilme==Integer.parseInt(valorComSplit[0])) {

						existeFilmes=true;
						for(String s : valorComSplit){
							System.out.print(s.trim()+"\t");
							codFilmeWrite=Integer.parseInt(valorComSplit[0]);
							nomeFilmeWrite=valorComSplit[1];
							
							
						}
						System.out.print("\n");
					}
				}
				if(existeFilmes==false) {
					System.out.println("Filme não encontrado!");
				}

				

				while(arquivoClienteR.hasNext())			
				{
					linha = arquivoClienteR.nextLine();
					String[] valorComSplitCliente = linha.split("-");


					if(consultaCliente.equalsIgnoreCase(valorComSplitCliente[1])) {
						existecliente=true;
						for(String s : valorComSplitCliente){
							System.out.print(s.trim()+"\t");
							codClinteWrite=Integer.parseInt(valorComSplitCliente[0]);
							nomeClienteWrite=valorComSplitCliente[1];
							dataLocacao = LocalDate.now();
							dataDevolucao=dataLocacao.plusDays(3);
						
							
						}
						System.out.print("\n");
					}


				}
				if(existecliente==false) {
					System.out.println("Cliente nao encontrado ");
				}
				System.out.println("Locacao realizado com sucesso\n");
				System.out.println("O filme devera ser devolvido no dia " +dataDevolucao);
				System.out.println("\n__________________________________________________");
				
				arquivoLocacaoW.println(codFilmeWrite+"-"+nomeFilmeWrite+"-"+codClinteWrite+"-"+nomeClienteWrite+"-"
				+dataLocacao+"-"+dataDevolucao);


				System.out.println("_____________________________________________\n");
				System.out.println("Deseja realizar uma nova locacao S para sim ou N para Nao:  ");
				System.out.println("_____________________________________________");
				fimloopConsultaFilme=ler.nextLine();
				arquivoLocacaoW.close();
			}while(fimloopConsultaFilme=="n");
		} catch (Exception e) { 
			System.out.println(e);
		} finally {
			
			arquivoClienteR.close();
			arquivoFilmeR.close();
		}	
	}

	public void consultarFilmes()
	{
		boolean existeFilme=true;

		try {
			FileReader inFilme = new FileReader("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\filme.txt");
			arquivoFilmeR = new Scanner(inFilme);

			do {
				System.out.println("_____________________________________________");
				System.out.println("      Consultando Filme                      ");
				System.out.println("_____________________________________________");
				System.out.println("Digite o Nome do Filme que deseja consultar");
				consultaFilme=ler.nextLine().toLowerCase();


				while(arquivoFilmeR.hasNext())			
				{
					linha = arquivoFilmeR.nextLine();
					String[] valorComSplit = linha.split("-");


					if(consultaFilme.equalsIgnoreCase(valorComSplit[1])) {

						for(String s : valorComSplit){
							System.out.print(s.trim()+"\t");
						}
						System.out.print("\n");
					}
					if(existeFilme==false) {
						System.out.println("Filme não encontrado");
					}
				}

				System.out.println("_____________________________________________\n");
				System.out.println("Deseja realizar uma nova consulta S para sim ou N para Nao:  ");
				System.out.println("_____________________________________________");
				fimloopConsultaFilme=ler.nextLine();

			}while(fimloopConsultaFilme=="n");
		} catch (Exception e) { 
			System.out.println(e);
		} finally { 
			arquivoFilmeR.close();
		}
	}

	public void consultarClientes()
	{

		try {
			FileReader inCliente = new FileReader("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\cliente.txt");
			arquivoClienteR = new Scanner(inCliente);



			do {

				System.out.println("_____________________________________________");
				System.out.println("      Consultando Cliente                      ");
				System.out.println("_____________________________________________");
				System.out.println("Digite o Nome do Cliente que deseja consultar");
				consultaCliente=ler.nextLine().toLowerCase();

				while(arquivoClienteR.hasNext())			
				{
					linha = arquivoClienteR.nextLine();
					String[] valorComSplit = linha.split("-");


					if(consultaCliente.equalsIgnoreCase(valorComSplit[1])) {

						for(String s : valorComSplit){
							System.out.print(s.trim()+"\t");
						}
						System.out.print("\n");
					}
				}
				System.out.println("_____________________________________________\n");
				System.out.println("Deseja realizar uma nova consulta S para sim ou N para Nao:  ");
				System.out.println("_____________________________________________");
				fimloopConsultaCliente=ler.nextLine();

			}while(fimloopConsultaCliente=="n");
		} catch (Exception e) { 
			System.out.println(e);
		} finally { 
			arquivoClienteR.close();
		}
	}

	public void devolverFilmes()
	{
		Boolean existelocacao=false;
		try { 
		FileReader inLocacao =new FileReader("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\locadora.txt");
		arquivoLocacaoR = new Scanner(inLocacao);
		do {
			System.out.println("_____________________________________________");
			System.out.println("      Realizando a Devolucao                   ");
			System.out.println("_____________________________________________");
			System.out.println("Digite o codigo do Filme que sera devolvido");
			codlocacao=Integer.parseInt(ler.nextLine());
			
			
			
			while(arquivoLocacaoR.hasNext())			
			{
				linha = arquivoLocacaoR.nextLine();
				String[] valorComSplit = linha.split("-");


				if(codlocacao==Integer.parseInt(valorComSplit[0])) {

					existelocacao=true;
					for(String s : valorComSplit){
						System.out.print(s.trim()+"\t");
						
						
						
					}
					System.out.print("\n");
				}
			}
			if(existelocacao==false) {
				System.out.println("Locacao não encontrado");
			}
			dataDevolucao = LocalDate.now();
			System.out.println("Devolucao realizado com sucesso\n");
			System.out.println("O filme foi devolvido  no dia " + dataDevolucao);
			System.out.println("\n__________________________________________________");
			


			System.out.println("_____________________________________________\n");
			System.out.println("Deseja realizar uma nova locação? S para sim e N para Não:  ");
			System.out.println("_____________________________________________");
			fimloopConsultaFilme=ler.nextLine();

			
		} while(fimloopConsultaFilme=="n");
	  } catch (Exception e) { 
		System.out.println(e);
	} finally {
		
		arquivoLocacaoR.close();

	}	
}
	
	public void consultarAtrasos()
	{
		
		boolean existeAtrasos = false;

		try {
			
			FileReader inAtrasos = new FileReader("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\locadora.txt");

			do {

				System.out.println("_____________________________________________");
				System.out.println("      Consultando atraso                     ");
				System.out.println("_____________________________________________");
				System.out.println("Digite o nome do filme do atraso que deseja procurar");
				String consultaAtrasos = ler.nextLine().toLowerCase();

				while(arquivoAtrasosR.hasNext())			
				{
					linha = arquivoAtrasosR.nextLine();
					String[] valorComSplit = linha.split("-");


					if(codlocacao==Integer.parseInt(valorComSplit[0])) {

						existeAtrasos=true;
						for(String s : valorComSplit){
							System.out.print(s.trim()+"\t");
							dataAtrasos=dataAtrasos.plusDays(4);
						}
						System.out.print("\n");
					}
				}
				
				if(existeAtrasos==false) {
					System.out.println("Atraso não encontrado");
				}

				System.out.println("O filme está em atraso desde o dia " + dataAtrasos);
				System.out.println("\n__________________________________________________");
				
				System.out.println("_____________________________________________\n");
				System.out.println("Deseja realizar uma nova consulta S para sim ou N para Nao:  ");
				System.out.println("_____________________________________________");
				fimloopConsultaAtraso=ler.nextLine();

			}while(fimloopConsultaAtraso=="n");
		} catch (Exception e) { 
			System.out.println(e);
		} finally { 
			arquivoAtrasosR.close();
		}
	}
	
	
}