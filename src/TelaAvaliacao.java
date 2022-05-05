import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaAvaliacao extends JFrame implements ActionListener {
	
	JLabel L1, L2, L3,L4,L5;
	JButton b1,b2;
	JTextField txtHJ,txtId,txtNota;
	JComboBox cmbJogador,cmbJogo;
	jogo jogo = new jogo();
	jogador jogador = new jogador();
	Avaliacao avaliacao = new Avaliacao();
	
	public TelaAvaliacao() {
		
		setTitle("Cadastro de Avaliação");
	    setSize(400, 250);
	    setResizable(false);
	    
	    Container p1 = getContentPane();
	    p1.setLayout(new GridLayout(6,2));
	    
	    L1 = new JLabel("Jogador");
	    L2 = new JLabel("Jogo");
	    L3 = new JLabel("Nota");
	    L4 = new JLabel("Horas Jogadas");
	    L5 = new JLabel("ID");
	    
	    txtHJ = new JTextField(); 
	    txtId = new JTextField();
	    txtNota = new JTextField();
	    
	    cmbJogador = new JComboBox();  
	    
	    ArrayList<jogador> lstJogador = jogador.listar();
			
        int str; 
 
        for(int i = 0;i<lstJogador.size(); i++ ){  

            str =lstJogador.get(i).getid();  
            cmbJogador.addItem(str);  
       } 
        
        cmbJogo = new JComboBox();  
	    
	    ArrayList<jogo> lstJogo = jogo.listar();
			
        String str2; 
 
        for(int i = 0;i<lstJogo.size(); i++ ){  

            str2 =lstJogo.get(i).getNome();
            cmbJogo.addItem(str2);  
       } 
	    
	    b1 = new JButton("Cadastrar");
	    b1.addActionListener(this);
	    b2 = new JButton("Listar");
	    b2.addActionListener(this);
	    
	    p1.add(L1); p1.add(cmbJogador); 
	    p1.add(L2); p1.add(cmbJogo); 
	    p1.add(L3); p1.add(txtNota); 
	    p1.add(L4); p1.add(txtHJ);
	    p1.add(L5); p1.add(txtId);
	      
	    p1.add(b1);  p1.add(b2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if(avaliacao.inserir((Integer) cmbJogador.getSelectedItem(), cmbJogo.getSelectedItem().toString(), Double.parseDouble(txtNota.getText()),Integer.parseInt(txtHJ.getText()), Integer.parseInt(txtId.getText())))
				
					JOptionPane.showMessageDialog(null, "Avaliacao inserido com sucesso");
			else 
				JOptionPane.showConfirmDialog(null, "Erro ao inserir o avaliacao");
		}
		else
			if (e.getSource() == b2) {
				ArrayList<Avaliacao> lstAva = avaliacao.listar();
				
				String conteudo = "Lista de Avaliações\n\n";
				
				for(int c = 0; c< lstAva.size();c++)
					conteudo += lstAva.get(c).getJogador()+ " - "
							 + lstAva.get(c).getJogo() + " - " + lstAva.get(c).getNota() +"\n";
				
				JOptionPane.showMessageDialog(null, conteudo);
			}
		
	}

}
