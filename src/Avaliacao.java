import java.sql.SQLException;
import java.util.ArrayList;

public class Avaliacao {
	
	private int jogador;
	private String jogo;
	private double nota;
	private int horasJogadas;
	private int id;
	
	public boolean inserir(int jogador, String jogo, double nota, int horasJogadas, int id) {
		Conexao conexao = new Conexao();
		conexao.getConnection();
		
		if(conexao.inserirAvaliacao(jogador,jogo,nota,horasJogadas,id))
			return true;
		else 
			return false;
	}
	
	public ArrayList<Avaliacao> listar(){
		try
		{
			Conexao conexao = new Conexao();
			conexao.getConnection();
			
			ArrayList<Avaliacao> lst = conexao.dadosAvaliacao();
			
			return lst;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void cadastrar(int jogador, String jogo, double nota, int horasJogadas, int id) {
		this.jogador = jogador;
		this.jogo = jogo;
		this.nota = nota;
		this.horasJogadas = horasJogadas;
		this.id = id;
	}
	public int getJogador() {
		return jogador;
	}
	public void setJogador(int jogador) {
		this.jogador = jogador;
	}
	public String getJogo() {
		return jogo;
	}
	public void setJogo(String jogo) {
		this.jogo = jogo;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int getHorasJogadas() {
		return horasJogadas;
	}
	public void setHorasJogadas(int horasJogadas) {
		this.horasJogadas = horasJogadas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
