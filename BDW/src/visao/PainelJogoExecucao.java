package visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;

import modelo.Carta;
import modelo.Torre;

public class PainelJogoExecucao extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon planoDeFundo;
	private ImageIcon imagemTorre1;
	private ImageIcon imagemTorre2;
	private ImageIcon imagemTorre3;
	private ImageIcon imagemTorreJogador1;
	private ImageIcon imagemTorreJogador2;
	private ImageIcon imagemTorreJogador3;
	private JButton botaoDesconectar;
	private JButton botaoEncerrarTurno;
	private JButton botaoCarta0;
	private JButton botaoCarta1;
	private JButton botaoCarta2;
	private JButton botaoCarta3;
	private JButton botaoTorreAdversario3;
	private JButton botaoTorreAdversario1;
	private JButton botaoTorreAdversario2;
	private JButton botaoTorre1;
	private JButton botaoTorre2;
	private JButton botaoTorre3;
	private List<JButton> listaBotaoCarta;
	private List<JButton> listaTorreAdversario;
	private List<JButton> listaTorreJogador;
	private JLabel labelTurno;
	private JLabel labelAntimateria;
	private JLabel labelTorreJogador3;
	private JLabel labelTorreJogador2;
	private JLabel labelTorreJogador1;
	private JLabel labelTorre1;
	private JLabel labelTorre2;
	private JLabel labelTorre3;
	
	private int idCarta;
	private int alvo;
	private Carta[] cartaJogador;

	/**
	 * Create the panel.
	 */
	public PainelJogoExecucao(int trincheiraEscolhida) {
		this.setLayout(null);
		this.setSize(602, 784);
		this.setLocation(0, 0);
		
		criaImagens(trincheiraEscolhida);
		criaBotoes();
		criaListaBotaoCarta();
		criaListaBotaoTorreAdversario();
		criaListaBotaoTorreJogador();
		
		criaLabels();
		actionListenerListaBotao();
		actionListenerBotaoTorres();
		
	}

	private void criaBotoes() {
		botaoDesconectar = new JButton("Desconectar");
		botaoDesconectar.setBounds(389, 625, 112, 25);
		add(botaoDesconectar);
		
		botaoEncerrarTurno = new JButton("Encerrar Turno");
		botaoEncerrarTurno.setBounds(253, 625, 130, 25);
		add(botaoEncerrarTurno);
		
		botaoCarta0 = new JButton("");
		botaoCarta0.setBounds(484, 668, 64, 87);
		add(botaoCarta0);
		
		botaoCarta1 = new JButton("");
		botaoCarta1.setBounds(415, 668, 64, 87);
		add(botaoCarta1);
		
		botaoCarta2 = new JButton("");
		botaoCarta2.setBounds(345, 668, 64, 87);
		add(botaoCarta2);
		
		botaoCarta3 = new JButton("");
		botaoCarta3.setBounds(275, 668, 64, 87);
		add(botaoCarta3);
		
		botaoTorreAdversario3 = new JButton("", imagemTorre3);
		botaoTorreAdversario3.setBounds(401, 117, 50, 95);
		add(botaoTorreAdversario3);
		
		botaoTorreAdversario1 = new JButton("", imagemTorre1);
		botaoTorreAdversario1.setBounds(151, 117, 50, 95);
		add(botaoTorreAdversario1);
		
		botaoTorreAdversario2 = new JButton("", imagemTorre2);
		botaoTorreAdversario2.setBounds(270, 110, 70, 80);
		add(botaoTorreAdversario2);
		
		botaoTorre1 = new JButton("", imagemTorreJogador1);
		botaoTorre1.setBounds(405, 427, 50, 95);
		add(botaoTorre1);
		
		botaoTorre2 = new JButton("", imagemTorreJogador2);
		botaoTorre2.setBounds(274, 463, 70, 80);
		add(botaoTorre2);
		
		botaoTorre3 = new JButton("", imagemTorreJogador3);
		botaoTorre3.setBounds(157, 427, 50, 95);
		add(botaoTorre3);
	}

	private void criaListaBotaoTorreJogador() {
		listaTorreJogador = new ArrayList<JButton>();
		listaTorreJogador.add(botaoTorre1);
		listaTorreJogador.add(botaoTorre2);
		listaTorreJogador.add(botaoTorre3);
	}

	private void criaListaBotaoTorreAdversario() {
		listaTorreAdversario = new ArrayList<JButton>();
		listaTorreAdversario.add(botaoTorreAdversario1);
		listaTorreAdversario.add(botaoTorreAdversario2);
		listaTorreAdversario.add(botaoTorreAdversario3);
	}

	private void criaListaBotaoCarta() {
		listaBotaoCarta = new ArrayList<JButton>();
		listaBotaoCarta.add(botaoCarta0);
		listaBotaoCarta.add(botaoCarta1);
		listaBotaoCarta.add(botaoCarta2);
		listaBotaoCarta.add(botaoCarta3);
	}

	private void criaImagens(int trincheiraEscolhida) {
		if(trincheiraEscolhida == 0){
			planoDeFundo = new ImageIcon("resources" + File.separator + "tabuleiro1.jpeg");
			imagemTorre1 = new ImageIcon("resources" + File.separator + "torreP1.jpg");
			imagemTorre2 = new ImageIcon("resources" + File.separator + "torreP2.jpg");
			imagemTorre3 = new ImageIcon("resources" + File.separator + "torreP3.jpg");
			imagemTorreJogador1 = new ImageIcon("resources" + File.separator + "torreGJ1.jpg");
			imagemTorreJogador2 = new ImageIcon("resources" + File.separator + "torreGJ2.jpg");
			imagemTorreJogador3 = new ImageIcon("resources" + File.separator + "torreGJ3.jpg");
		}else{
			planoDeFundo = new ImageIcon("resources" + File.separator + "tabuleiro2.jpeg");
			imagemTorre1 = new ImageIcon("resources" + File.separator + "torreG1.jpg");
			imagemTorre2 = new ImageIcon("resources" + File.separator + "torreG2.jpg");
			imagemTorre3 = new ImageIcon("resources" + File.separator + "torreG3.jpg");
			imagemTorreJogador1 = new ImageIcon("resources" + File.separator + "torrePJ1.jpg");
			imagemTorreJogador2 = new ImageIcon("resources" + File.separator + "torrePJ2.jpg");
			imagemTorreJogador3 = new ImageIcon("resources" + File.separator + "torrePJ3.jpg");
		}
	}

	private void criaLabels() {
		labelTurno = new JLabel("");
		labelTurno.setForeground(Color.BLACK);
		labelTurno.setFont(new Font("Times New Roman", Font.BOLD, 28));
		labelTurno.setBounds(44, 655, 42, 25);
		add(labelTurno);
		
		labelAntimateria = new JLabel("");
		labelAntimateria.setForeground(new Color(0, 51, 153));
		labelAntimateria.setFont(new Font("Times New Roman", Font.BOLD, 28));
		labelAntimateria.setBounds(44, 735, 42, 25);
		add(labelAntimateria);
		
		labelTorreJogador3 = new JLabel("");
		labelTorreJogador3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTorreJogador3.setForeground(Color.GREEN);
		labelTorreJogador3.setBounds(170, 558, 56, 25);
		add(labelTorreJogador3);
		
		labelTorreJogador2 = new JLabel("");
		labelTorreJogador2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTorreJogador2.setForeground(Color.GREEN);
		labelTorreJogador2.setBounds(295, 560, 56, 25);
		add(labelTorreJogador2);
		
		labelTorreJogador1 = new JLabel("");
		labelTorreJogador1.setForeground(Color.GREEN);
		labelTorreJogador1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTorreJogador1.setBounds(415, 558, 56, 25);
		add(labelTorreJogador1);
		
		labelTorre1 = new JLabel("");
		labelTorre1.setForeground(Color.GREEN);
		labelTorre1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTorre1.setBounds(162, 238, 56, 25);
		add(labelTorre1);
		
		labelTorre2 = new JLabel("");
		labelTorre2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTorre2.setForeground(Color.GREEN);
		labelTorre2.setBounds(290, 218, 56, 25);
		add(labelTorre2);
		
		labelTorre3 = new JLabel("");
		labelTorre3.setForeground(Color.GREEN);
		labelTorre3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTorre3.setBounds(410, 238, 56, 25);
		add(labelTorre3);
		
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
	
	public void atualizaLabels(int antimateria, int numTurnos){
		
		labelAntimateria.setText(antimateria+"");
		labelTurno.setText(numTurnos+"");
	}
	
	public void atualizaVidaTorres(Torre[] trincheira, Torre[] trincheiraAdversaria){
		labelTorreJogador1.setText("[" + trincheira[0].getPtosdevida() + "]");
		labelTorreJogador2.setText("[" + trincheira[1].getPtosdevida() + "]");
		labelTorreJogador3.setText("[" + trincheira[2].getPtosdevida() + "]");
		labelTorre1.setText("[" + trincheiraAdversaria[0].getPtosdevida() + "]");
		labelTorre2.setText("[" + trincheiraAdversaria[1].getPtosdevida() + "]");
		labelTorre3.setText("[" + trincheiraAdversaria[2].getPtosdevida() + "]");
	}
	
	public void elementosTurnoOponente(){
		/*
		 * bloquear botoes trincheiras
		 */
		botaoCarta0.setEnabled(false);
		botaoCarta1.setEnabled(false);
		botaoCarta2.setEnabled(false);
		botaoCarta3.setEnabled(false);
		botaoEncerrarTurno.setEnabled(false);
	}
	
	public void atribuirCartaBotao(Carta[] cartasJogador){
		/*
		 * verificar atributo habilitado de carta para habilitar ou nao botao
		 */
		this.cartaJogador = cartasJogador;
		for(int i = 0; i < cartasJogador.length; i++){
			
		}
	}
	
	private void actionListenerListaBotao(){
		for(int i = 0; i < listaBotaoCarta.size(); i++){
			int posicao = i;
			
			listaBotaoCarta.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					idCarta = posicao;
					botaoCarta0.setEnabled(false);
					botaoCarta1.setEnabled(false);
					botaoCarta2.setEnabled(false);
					botaoCarta3.setEnabled(false);
					botaoEncerrarTurno.setEnabled(false);
				}
			});
			
		}
	}
	
	private void actionListenerBotaoTorres(){
		for(int i = 0; i < listaTorreJogador.size(); i++){
			int posicao = i;
			listaTorreJogador.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acaoBotaoTorre(posicao);
					
				}
			});
		}
		for(int i = 0; i < listaTorreAdversario.size(); i++){
			int posicao = i;
			listaTorreAdversario.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acaoBotaoTorre(posicao);
					
				}
			});
		}
	}
	
	public void acaoBotaoTorre(int posicao){
		cartaJogador[idCarta].setAlvo(posicao);
		botaoCarta0.setEnabled(true);
		botaoCarta1.setEnabled(true);
		botaoCarta2.setEnabled(true);
		botaoCarta3.setEnabled(true);
		botaoEncerrarTurno.setEnabled(true);
	}
}
