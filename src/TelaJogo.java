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

public class TelaJogo extends JFrame implements ActionListener{
	
	JLabel L1, L2, L3,L4;
	JButton b1,b2;
	JTextField txtNome, txtProdutora, txtEstilo,txtClass;
	jogo jogo = new jogo();
	
	public TelaJogo() {
		
		setTitle("Cadastro de Jogo");
	    setSize(400, 250);
	    setResizable(false);
	    
	    Container p1 = getContentPane();
	    p1.setLayout(new GridLayout(5,2));
	    
	    L1 = new JLabel("Nome");
	    L2 = new JLabel("Produtora");
	    L3 = new JLabel("Estilo");
	    L4 = new JLabel("Classificação");
	    
	    txtNome = new JTextField();
	    txtProdutora = new JTextField();
	    txtEstilo = new JTextField(); 
	    txtClass = new JTextField();
	    
	    
	    b1 = new JButton("Cadastrar");
	    b1.addActionListener(this);
	    
	    b2 = new JButton("Listar");
	    b2.addActionListener(this);
	    
	    p1.add(L1); p1.add(txtNome); 
	    p1.add(L2); p1.add(txtProdutora); 
	    p1.add(L3); p1.add(txtEstilo); 
	    p1.add(L4); p1.add(txtClass);
	      
	    p1.add(b1);  p1.add(b2); 
	}  
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if(jogo.inserir(txtNome.getText(), txtProdutora.getText(),txtEstilo.getText() ,txtClass.getText()))
				JOptionPane.showMessageDialog(null, "Jogo inserido com sucesso");
			else 
				JOptionPane.showConfirmDialog(null, "Erro ao inserir o jogo");
		}
		else
			if (e.getSource() == b2) {
				ArrayList<jogo> lstjogo = jogo.listar();
				
				String conteudo = "Lista de Jogos\n\n";
				
				for(int c = 0; c< lstjogo.size();c++)
					conteudo += lstjogo.get(c).getNome()+ " - "
							 + lstjogo.get(c).getProdutora() + " - "
							 + lstjogo.get(c).getEstilo() + "\n";
				
				JOptionPane.showMessageDialog(null, conteudo);
			}
		
	}
	

}
