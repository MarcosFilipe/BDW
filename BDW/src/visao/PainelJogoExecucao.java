package visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;

public class PainelJogoExecucao extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon planoDeFundo;
	private ImageIcon imagemTorre1;
	private ImageIcon imagemTorre2;
	private ImageIcon imagemTorre3;
	private JButton botaoDesconectar;
	private JButton botaoEncerrarTurno;

	/**
	 * Create the panel.
	 */
	public PainelJogoExecucao(int trincheiraEscolhida) {
		this.setLayout(null);
		this.setSize(602, 784);
		this.setLocation(0, 0);
		
		if(trincheiraEscolhida == 0){
			planoDeFundo = new ImageIcon("resources" + File.separator + "tabuleiro1.jpeg");
			imagemTorre1 = new ImageIcon("resources" + File.separator + "torreP1.jpg");
			imagemTorre2 = new ImageIcon("resources" + File.separator + "torreP2.jpg");
			imagemTorre3 = new ImageIcon("resources" + File.separator + "torreP3.jpg");
		}else{
			planoDeFundo = new ImageIcon("resources" + File.separator + "tabuleiro2.jpeg");
			imagemTorre1 = new ImageIcon("resources" + File.separator + "torreG1.jpg");
			imagemTorre2 = new ImageIcon("resources" + File.separator + "torreG2.jpg");
			imagemTorre3 = new ImageIcon("resources" + File.separator + "torreG3.jpg");
		}
		
		botaoDesconectar = new JButton("Desconectar");
		botaoDesconectar.setBounds(389, 625, 112, 25);
		add(botaoDesconectar);
		
		JButton botaoCarta0 = new JButton("");
		botaoCarta0.setBounds(484, 668, 64, 87);
		add(botaoCarta0);
		
		JButton botaoCarta1 = new JButton("");
		botaoCarta1.setBounds(415, 668, 64, 87);
		add(botaoCarta1);
		
		JButton botaoCarta2 = new JButton("");
		botaoCarta2.setBounds(345, 668, 64, 87);
		add(botaoCarta2);
		
		JButton botaoCarta3 = new JButton("");
		botaoCarta3.setBounds(275, 668, 64, 87);
		add(botaoCarta3);
		
		JLabel labelTurno = new JLabel("10");
		labelTurno.setForeground(Color.BLACK);
		labelTurno.setFont(new Font("Times New Roman", Font.BOLD, 28));
		labelTurno.setBounds(44, 655, 42, 25);
		add(labelTurno);
		
		JLabel labelAntimateria = new JLabel("10");
		labelAntimateria.setForeground(new Color(0, 51, 153));
		labelAntimateria.setFont(new Font("Times New Roman", Font.BOLD, 28));
		labelAntimateria.setBounds(44, 735, 42, 25);
		add(labelAntimateria);
		
		JProgressBar progressTorre3 = new JProgressBar();
		progressTorre3.setValue(30);
		progressTorre3.setMaximum(30);
		progressTorre3.setBounds(156, 560, 52, 9);
		add(progressTorre3);
		
		JProgressBar progressTorre2 = new JProgressBar();
		progressTorre2.setValue(30);
		progressTorre2.setMaximum(30);
		progressTorre2.setBounds(282, 570, 52, 9);
		add(progressTorre2);
		
		JProgressBar progressTorre1 = new JProgressBar();
		progressTorre1.setValue(30);
		progressTorre1.setMaximum(30);
		progressTorre1.setBounds(404, 560, 52, 9);
		add(progressTorre1);
		
		JProgressBar progressTorreAdversario1 = new JProgressBar();
		progressTorreAdversario1.setValue(30);
		progressTorreAdversario1.setMaximum(30);
		progressTorreAdversario1.setBounds(150, 240, 52, 9);
		add(progressTorreAdversario1);
		
		JProgressBar progressTorreAdversario2 = new JProgressBar();
		progressTorreAdversario2.setValue(30);
		progressTorreAdversario2.setMaximum(30);
		progressTorreAdversario2.setBounds(278, 220, 52, 9);
		add(progressTorreAdversario2);
		
		JProgressBar progressTorreAdversario3 = new JProgressBar();
		progressTorreAdversario3.setMaximum(30);
		progressTorreAdversario3.setValue(30);
		progressTorreAdversario3.setBounds(400, 240, 52, 9);
		add(progressTorreAdversario3);
		
		JButton botaoTorreAdversario3 = new JButton("", imagemTorre3);
		botaoTorreAdversario3.setBounds(401, 117, 50, 95);
		add(botaoTorreAdversario3);
		
		JButton botaoTorreAdversario1 = new JButton("", imagemTorre1);
		botaoTorreAdversario1.setBounds(151, 117, 50, 95);
		add(botaoTorreAdversario1);
		
		JButton botaoTorreAdversario2 = new JButton("", imagemTorre2);
		botaoTorreAdversario2.setBounds(270, 110, 70, 80);
		add(botaoTorreAdversario2);
		
		JButton botaoTorre1 = new JButton("");
		botaoTorre1.setBounds(405, 427, 50, 95);
		add(botaoTorre1);
		
		JButton botaoTorre2 = new JButton("");
		botaoTorre2.setBounds(274, 463, 70, 80);
		add(botaoTorre2);
		
		JButton botaoTorre3 = new JButton("");
		botaoTorre3.setBounds(157, 427, 50, 95);
		add(botaoTorre3);
		
		JButton btnEncerrarTurno = new JButton("Encerrar Turno");
		btnEncerrarTurno.setBounds(250, 625, 112, 23);
		add(btnEncerrarTurno);
		
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
