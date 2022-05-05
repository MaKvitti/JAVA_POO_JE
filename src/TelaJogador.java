import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaJogador extends JFrame implements ActionListener  {
	JLabel L1, L2, L3,L4;
	JButton b1,b2;
	JTextField txtId, txtNome, txtPlataforma,txtIdade;
	jogador jogador = new jogador();
	
	
public TelaJogador()
	{
		setTitle("Cadastro de Jogador");
	    setSize(400, 250);
	    setResizable(false);
	    
	    Container p1 = getContentPane();
	    p1.setLayout(new GridLayout(5,2));
	    
	    L1 = new JLabel("ID ");
	    L2 = new JLabel("Nome");
	    L3 = new JLabel("Plataforma");
	    L4 = new JLabel("Idade");
	    
	    txtId = new JTextField();
	    txtNome = new JTextField();
	    txtPlataforma = new JTextField(); 
	    txtIdade = new JTextField();
	    
	    
	    b1 = new JButton("Cadastrar");
	    b1.addActionListener(this);
	    
	    b2 = new JButton("Listar");
	    b2.addActionListener(this);
	    
	    p1.add(L1); p1.add(txtId); 
	    p1.add(L2); p1.add(txtNome); 
	    p1.add(L3); p1.add(txtPlataforma); 
	    p1.add(L4); p1.add(txtIdade);
	      
	    p1.add(b1); p1.add(b2);
	}  


public void actionPerformed(ActionEvent e) {
	if (e.getSource() == b1) {
		if(jogador.inserir(txtNome.getText(), Integer.parseInt(txtId.getText()),txtPlataforma.getText() ,Integer.parseInt(txtIdade.getText())))
			JOptionPane.showMessageDialog(null, "Jogador inserido com sucesso");
		else 
			JOptionPane.showConfirmDialog(null, "Erro ao inserir o jogador");
	}
	else
		if (e.getSource() == b2) {
			ArrayList<jogador> lstjogador= jogador.listar();
			
			String conteudo = "Lista de Jogos\n\n";
			
			for(int c = 0; c< lstjogador.size();c++)
				conteudo += lstjogador.get(c).getNome()+ " - "
						 + lstjogador.get(c).getPlataforma() + " - "
						 + lstjogador.get(c).getid() + "\n";
			
			JOptionPane.showMessageDialog(null, conteudo);
		}
	
}
}
