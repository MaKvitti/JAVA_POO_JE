import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexao {

		private Connection con;
		private Statement st;
		private ResultSet rs;
		
	public Connection getConnection() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/classificacaoJogos?characterEncoding=utf8","root","1234");
			st = con.createStatement();
			
			return con;
		}
		catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		catch(SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	public boolean inserirJogador(String nome, int id, String plataforma, int idade) {
		try {
			this.st.executeUpdate("insert into jogador values('"+id + "','" + nome + "','" + idade + "','" + plataforma + "')");
			return true;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<jogador> dadosJogador() throws SQLException {
		try {
			ArrayList<jogador> lstJ = new ArrayList<jogador>();
			this.rs = this.st.executeQuery("select * from jogador order by id");
			while(rs.next()) {
				jogador jgr = new jogador();
				
				jgr.cadastrar(rs.getString("nome"),rs.getInt("id"), rs.getString("plataforma"),rs.getInt("idade"));
				
				lstJ.add(jgr);
			}
			return lstJ;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean inserirJogo(String nome, String produtora, String estilo, String classificacao) {
		try {
			this.st.executeUpdate("insert into jogo values('"+nome + "','" + produtora + "','" + estilo + "','" + classificacao + "')");
			return true;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<jogo> dadosJogo() throws SQLException {
		try {
			ArrayList<jogo> lstJ2 = new ArrayList<jogo>();
			this.rs = this.st.executeQuery("select * from jogo order by nome");
			while(rs.next()) {
				jogo jg = new jogo();
				
				jg.cadastrar(rs.getString("nome"), rs.getString("produtora"), rs.getString("estilo"), rs.getString("classificacao"));
				
				lstJ2.add(jg);
			}
			return lstJ2;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public boolean inserirAvaliacao(int jogador, String jogo, double nota, int horasJogadas, int id) {
		try {
			this.st.executeUpdate("insert into avaliacao values('"+id+ "','" + nota + "','" + horasJogadas + "','" + jogador + "','" + jogo +"')");
			return true;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Avaliacao> dadosAvaliacao() throws SQLException {
		try {
			ArrayList<Avaliacao> lst = new ArrayList<Avaliacao>();
			this.rs = this.st.executeQuery("select * from avaliacao order by idnota");
			while(rs.next()) {
				Avaliacao avl = new Avaliacao();
				avl.cadastrar(rs.getInt("jogador"), rs.getString("jogo"),rs.getDouble("nota"),rs.getInt("horasJogadas"),rs.getInt("idnota"));
				lst.add(avl);
			}
			return lst;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
