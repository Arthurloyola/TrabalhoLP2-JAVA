package LP2TRABALHOFINAL;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Filme {
	private int codigo;
	private String titulo;
	private String genero;
	private int quantidade;
	private int qtdEmEstoque;
	boolean locado;
	
	public Filme() {
		super();
		// TODO Auto-generated constructor stub
		this.titulo="";
		this.genero="";
		this.quantidade=0;
		this.qtdEmEstoque=0;
		this.locado=false;
	}
	
	public Filme(String titulo, String genero, int quantidade, boolean locado) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.quantidade = quantidade;
		this.qtdEmEstoque = quantidade;
		this.locado = locado;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQtdEmEstoque() {
		return qtdEmEstoque;
	}
	public void setQtdEmEstoque(int qtdLocado) {
		this.qtdEmEstoque -= qtdLocado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isLocado() {
		return locado;
	}
	public void setLocado(boolean locado) {
		this.locado = locado;
	}
	
	
	public void cadastroFilme()
	{
		Filme novoFilme = new Filme();
		PrintWriter arquivoFilmeW = null;
		Scanner ler= new Scanner(System.in);
		String codPainel;
		try 
		{
			FileWriter escreverArquivo = new FileWriter("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\filme.txt", true); 
			arquivoFilmeW = new PrintWriter(escreverArquivo);
			
			System.out.println("_____________________________________________\n");
			System.out.println("      Cadastrando filme da locadora   ");
			System.out.println("_____________________________________________\n\n");
			
			do {
				
				System.out.printf("Informe o codigo do filme que sera cadastrado\n");
				novoFilme.setCodigo(Integer.parseInt(ler.nextLine().toLowerCase()));
				System.out.printf("Informe o titulo do filme:\n");
				novoFilme.setTitulo(ler.nextLine().toLowerCase());
				System.out.printf("Informe  o genero do filme:\n");
				novoFilme.setGenero(ler.nextLine().toLowerCase());
				System.out.printf("Informe a quantidade do estoque:\n");
				novoFilme.setQtdEmEstoque(Integer.parseInt(ler.nextLine()));
				System.out.printf("Informe a quantidade disponivel para locacao :\n");
				novoFilme.setQuantidade(Integer.parseInt(ler.nextLine()));
				novoFilme.setLocado(false); 
				
				int codigoFilme=novoFilme.getCodigo();
				
				
				for(int i=0; i<novoFilme.getQuantidade();i++) {
						
				arquivoFilmeW.println(codigoFilme+"-"+novoFilme.getTitulo()+"-"+novoFilme.getGenero()+
						""+novoFilme.getQtdEmEstoque()+"-"+codigoFilme+"-"+codigoFilme+"-"+novoFilme.locado);
				
				codigoFilme++;
				}
				System.out.println("Filme cadastrado com sucesso");
				System.out.println("__________________________________________________");
				
				System.out.println("_____________________________________________\n");
				System.out.println("Deseja cadastrar um novo filme S para sim ou N para Nao:  ");
				System.out.println("_____________________________________________");
				
				
				 codPainel=ler.nextLine().toLowerCase();
			} while (codPainel=="n");
		}catch (Exception e){ 
			System.out.println(e);
		}finally{ 
			arquivoFilmeW.close();
		}
		
	}
	public void locadoFilme(Filme filme)
	{
		
	}
	@Override
	public String toString() {
		return "Filme [Titulo=" + titulo + ", Gênero=" + genero + ", Quantidade=" + quantidade + ", Quantidade Locado="
				+ qtdEmEstoque + "]";
	}
}