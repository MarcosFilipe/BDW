package visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelJogoExecucao extends JPanel {
	
	private ImageIcon planoDeFundo;
	private JButton botaoDesconectar;
	private JButton botaoEncerrarTurno;
	private JLabel labelFundo;

	/**
	 * Create the panel.
	 */
	public PainelJogoExecucao(int trincheiraEscolhida) {
		this.setLayout(null);
		this.setSize(602, 784);
		this.setLocation(0, 0);
		
		
		labelFundo = new JLabel();
		labelFundo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "funfou :D");
			}
		});
		labelFundo.setBounds(391, 600, 102, 31);
		add(labelFundo);
		
		JLabel labelDesconectar = new JLabel("");
		labelDesconectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		labelDesconectar.setBackground(new Color(255, 255, 255));
		labelDesconectar.setIcon(new ImageIcon("C:\\Users\\filip\\Desktop\\BDW IMAGES\\tabuleiro.jpeg"));
		labelDesconectar.setBounds(0, 0, 602, 763);
		add(labelDesconectar);
		
		JLabel label = new JLabel("");
		label.setBounds(271, 600, 92, 31);
		add(label);
		
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
