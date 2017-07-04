package visao;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modelo.Mapa;
import modelo.UmaJogada;
import rede.AtorNetgames;


public class AtorJogador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PainelConectar painelConectar;
	private PainelInserirNome painelInserirNome;
	private PainelEscolherTrincheira painelEscolherTrincheira;
	
	private Mapa mapa;
	private AtorNetgames rede;
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
		
		painelInserirNome = new PainelInserirNome();
		getContentPane().add(painelInserirNome);
		actionListenerBotaoContinuarNome();
		
		rede = new AtorNetgames(this);
	}
	
	public void actionListenerBotaoConectar(){
		painelConectar.actionListenerBotaoConectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rede.conectar(nomeUsuario, "localhost");
				getContentPane().removeAll();
				painelEscolherTrincheira = new PainelEscolherTrincheira();
				getContentPane().add(painelEscolherTrincheira);
				revalidate();
				repaint();
				actionListenerBotaoContinuarTrincheira();
				
			}
		});
	}
	
	public void enviarJogada() {
		if(mapa.ehMinhaVez())
		rede.enviarJogada(mapa.enviaJogada()); 
		else {
			JOptionPane.showMessageDialog(null, "Desculpe, Não é a sua vez!");
		}
		
	}
	
	public void receberJogada(UmaJogada jogada) {
		this.mapa.receberJogada(jogada);
	}
	
	public void actionListenerBotaoContinuarNome(){
		painelInserirNome.actionListenerBotaoContinuar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeUsuario = painelInserirNome.getNomeJogador();
				getContentPane().removeAll();
				
				painelConectar = new PainelConectar();
				getContentPane().add(painelConectar);
				revalidate();
				repaint();
				actionListenerBotaoConectar();
				
			}
		});
	}
	
	public void actionListenerBotaoContinuarTrincheira(){
		painelEscolherTrincheira.actionListenerBotaoContinuar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int trincheiraEscolhida = painelEscolherTrincheira.getTrincheiraEscolhida();
				rede.iniciarPartidaRede();
				//iniciarNovaPartida(painelInserirNome.getNomeJogador(), trincheiraEscolhida);
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
		//this.mapa = Mapa.getInstance();
		//! aqui so ta comentado pra funcionar a interface grafica ja que
		// nao foi implementado a parte do net games
		
		//mapa.criarJogadorAdversario(rede.informarAdversario());
		//mapa.jogadorTurnoInicial();
		//exibirEstado();
	}

	public void iniciarPartidaRede(boolean ehMinhaVez) {
		String nomeJogadorAdversario = rede.obterNomeAdversario();
		this.mapa = Mapa.getInstance();
		
		if(ehMinhaVez) {
			mapa.criaJogador(this.nomeUsuario, true);
			mapa.criarJogadorAdversario(nomeJogadorAdversario, false);
		}
		//mapa.criaJogador(nomeUsuario);
		//mapa.criarJogadorAdversario(jogadorAdversario);
		
	}
	
	public void iniciarBatalha() {
		rede.iniciarPartidaRede();
	}

}
