import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal implements ActionListener {
	JFrame tela;    
	JMenuBar menu;    
	JMenu cadastros;    
	JMenuItem jogador, jogos, avaliacao;   
			
	public MenuPrincipal()
	{    		
		
		jogador = new JMenuItem("Jogador");    
		jogos = new JMenuItem("Jogos"); 
		avaliacao = new JMenuItem("Avaliacao");

		menu = new JMenuBar();    
		cadastros = new JMenu("Cadastros");
				
		cadastros.add(jogador);
		jogador.addActionListener(this);
		cadastros.add(jogos);
		jogos.addActionListener(this);
		cadastros.add(avaliacao);
		avaliacao.addActionListener(this);

		menu.add(cadastros);   

		tela = new JFrame();  
		tela.setLayout(null);    
		tela.setSize(300,300);
		tela.setTitle("Avaliação de Jogos");
		tela.add(menu);    
		tela.setJMenuBar(menu);   
		tela.setVisible(true);
	}     

	public void actionPerformed(ActionEvent e) {   
		if (e.getSource() == jogador) {
			JFrame cad = new TelaJogador();
			cad.setVisible(true);
		}
		
		if (e.getSource() == jogos) {
			JFrame cad = new TelaJogo();
			cad.setVisible(true);
		}
		if(e.getSource() == avaliacao) {
			JFrame cad = new TelaAvaliacao() ;
			cad.setVisible(true);
		}
	}   
			
	public static void main(String[] args) {		
		new MenuPrincipal();    
	}    
}