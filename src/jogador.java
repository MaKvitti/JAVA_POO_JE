import java.sql.SQLException;
import java.util.ArrayList;

public class jogador {
	private String nome;
	private int id;
	private String plataforma;
	private int idade;

	public boolean inserir(String nome, int id, String plataforma, int idade) {
		Conexao conexao = new Conexao();
		conexao.getConnection();
		
		if(conexao.inserirJogador(nome,id,plataforma,idade))
			return true;
		else 
			return false;
	}
	
	public ArrayList<jogador> listar(){
		try
		{
			Conexao conexao = new Conexao();
			conexao.getConnection();
			
			ArrayList<jogador> lst2 = conexao.dadosJogador();
			
			return lst2;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void cadastrar(String nome, int id, String plataforma, int idade) {
		this.nome = nome;
		this.id = id;
		this.plataforma = plataforma;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getid() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
	
}
