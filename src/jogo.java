import java.sql.SQLException;
import java.util.ArrayList;

public class jogo {
	
	private String nome;
	private String produtora;
	private String estilo;
	private String classificacao;
	
	public boolean inserir(String nome, String produtora, String estilo, String classificacao) {
		Conexao conexao = new Conexao();
		conexao.getConnection();
		
		if(conexao.inserirJogo(nome,produtora,estilo,classificacao))
			return true;
		else 
			return false;
	}
	
	public ArrayList<jogo> listar(){
		try
		{
			Conexao conexao = new Conexao();
			conexao.getConnection();
			
			ArrayList<jogo> lst = conexao.dadosJogo();
			
			return lst;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void cadastrar(String nome, String produtora, String estilo, String classificacao) {
		this.nome = nome;
		this.produtora = produtora;
		this.estilo = estilo;
		this.classificacao = classificacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	

}
