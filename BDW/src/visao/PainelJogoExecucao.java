package visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PainelJogoExecucao extends JPanel {
	
	private ImageIcon planoDeFundo;
	private JButton botaoDesconectar;
	private JButton botaoEncerrarTurno;

	/**
	 * Create the panel.
	 */
	public PainelJogoExecucao(int trincheiraEscolhida) {
		this.setLayout(null);
		this.setSize(602, 802);
		this.setLocation(0, 0);
		
		botaoDesconectar = new JButton("Desconectar");
		botaoDesconectar.setBounds(389, 625, 112, 25);
		add(botaoDesconectar);
		
		botaoEncerrarTurno = new JButton("Encerrar Turno");
		botaoEncerrarTurno.setBounds(251, 625, 126, 25);
		add(botaoEncerrarTurno);
		
		if(trincheiraEscolhida == 0){
			planoDeFundo = new ImageIcon("resources" + File.separator + "tabuleiro1.jpeg");
		}else{
			planoDeFundo = new ImageIcon("resources" + File.separator + "tabuleiro2.jpeg");
		}
	}
	
	public void actionListenerBotaoEncerrarTurno(ActionListener actionListener){
		botaoEncerrarTurno.addActionListener(actionListener);
	}
	
	public void actionListenerBotaoDesconectar(ActionListener actionListener){
		botaoDesconectar.addActionListener(actionListener);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image img = planoDeFundo.getImage();
		g.drawImage(img, 0, 0, this);
	}

}
