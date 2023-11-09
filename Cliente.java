package LP2TRABALHOFINAL;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente {
	int codigo;
	String nome;
	String sexo;
	long cpf;
	String endereco;
	Filme filmesLocados[];

	public Cliente() {
		super();
		
		this.codigo=0;
		this.nome = "";
		this.sexo = "";
		this.cpf = 0;
		this.endereco = "";
		this.filmesLocados = filmesLocados;
	}

	public Cliente(int codigo, String nome, String sexo, long cpf, String endereco, Filme[] filmesLocados) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.filmesLocados = filmesLocados;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Filme[] getFilmesLocados() {
		return filmesLocados;
	}
	public void setFilmesLocados(Filme[] filmesLocados) {
		this.filmesLocados = filmesLocados;
	}

	public void cadastroCliente()
	{
		Cliente novoCliente = new Cliente();
		PrintWriter arquivoClienteW = null;
		Scanner ler= new Scanner(System.in);
		String codPainel;
		try 
		{
			FileWriter escreverArquivo = new FileWriter("C:\\Users\\arthu\\OneDrive\\Documentos\\LAB. FAESA\\Projeto 1\\Projeto 1\\src\\LP2TRABALHOFINAL\\cliente.txt", true); 
			arquivoClienteW = new PrintWriter(escreverArquivo);

			System.out.println("_____________________________________________\n");
			System.out.println("      Cadastrando cliente da locadora   ");
			System.out.println("_____________________________________________\n\n");

			do {
				String nome;
				String sexo;
				long cpf;
				String endereco;

				System.out.printf("Informe o codigo do cliente que sera cadastrado\n");
				novoCliente.setCodigo(Integer.parseInt(ler.nextLine()));
				System.out.printf("Informe o nome do cliente :\n");
				novoCliente.setNome(ler.nextLine());
				System.out.printf("Informe  o sexo do cliente:\n");
				novoCliente.setSexo(ler.nextLine());
				System.out.printf("Informe o CPF do cliente:\n");
				novoCliente.setCpf(Long.parseLong(ler.nextLine()));
				System.out.printf("Informe o endereco do cliente :\n");
				novoCliente.setEndereco(ler.nextLine());

				arquivoClienteW.println(novoCliente.getCodigo()+"-"+novoCliente.getNome()+"-"+novoCliente.getSexo()+
						""+novoCliente.getCpf()+"-"+novoCliente.getEndereco());

				System.out.println("Cliente cadastrado com sucesso");
				System.out.println("__________________________________________________");
				
				System.out.println("_____________________________________________\n");
				System.out.println("Deseja cadastrar um novo cliente S para sim ou N para Nao:  ");
				System.out.println("_____________________________________________");

				codPainel=ler.nextLine().toLowerCase();
			} while (codPainel=="n");
		}catch (Exception e){ 
			System.out.println(e);
		}finally{ 
			arquivoClienteW.close();
		}

	} 
	
	

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", filmesLocados=" + Arrays.toString(filmesLocados) + "]";
	}

}