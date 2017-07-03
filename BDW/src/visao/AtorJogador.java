package visao;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import modelo.AtorNetGames;
import modelo.Mapa;


public class AtorJogador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PainelConectar painelConectar;
	private PainelInserirNome painelInserirNome;
	private PainelEscolherTrincheira painelEscolherTrincheira;
	
	private Mapa mapa;
	private AtorNetGames rede;
	private String nomeUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtorJogador frame = new AtorJogador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtorJogador() {
		
		this.setTitle("Black Dots War");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 336);
		setLocationRelativeTo(null);
		this.setVisible(true);
		setResizable(false);
		
		painelConectar = new PainelConectar();
		getContentPane().add(painelConectar);
		actionListenerBotaoConectar();
	}
	
	public void actionListenerBotaoConectar(){
		painelConectar.actionListenerBotaoConectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				painelInserirNome = new PainelInserirNome();
				getContentPane().add(painelInserirNome);
				revalidate();
				repaint();
				actionListenerBotaoContinuarNome();
				
			}
		});
	}
	
	public void actionListenerBotaoContinuarNome(){
		painelInserirNome.actionListenerBotaoContinuar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				painelEscolherTrincheira = new PainelEscolherTrincheira();
				getContentPane().add(painelEscolherTrincheira);
				revalidate();
				repaint();
				actionListenerBotaoContinuarTrincheira();
				
			}
		});
	}
	
	public void actionListenerBotaoContinuarTrincheira(){
		painelEscolherTrincheira.actionListenerBotaoContinuar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int trincheiraEscolhida = painelEscolherTrincheira.getTrincheiraEscolhida();
				iniciarNovaPartida(painelInserirNome.getNomeJogador(), trincheiraEscolhida);
				JanelaTabuleiro janelaTabuleiro = new JanelaTabuleiro(trincheiraEscolhida);
				fechaJanelaJogo();
				
			}
		});
	}
	
	private void fechaJanelaJogo(){
		Component comp = SwingUtilities.getRoot(this);
		((Window) comp).dispose();
	}
	
	private void iniciarNovaPartida(String nome, int trincheiraEscolhida) {
		this.mapa = new Mapa();
		mapa.criaJogador(nome);
		//! aqui so ta comentado pra funcionar a interface grafica ja que
		// nao foi implementado a parte do net games
		
		//mapa.criarJogadorAdversario(rede.informarAdversario());
		//mapa.jogadorTurnoInicial();
		//exibirEstado();
	}

}
