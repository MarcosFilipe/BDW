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
	private PainelJogoExecucao painelJogoExecucao;
	
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
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 839);
		this.setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		rede = new AtorNetgames(this);
		painelConectar = new PainelConectar();
		getContentPane().add(painelConectar);
		actionListenerBotaoConectar();
		
		
	}
	
	private void actionListenerBotaoConectar(){
		painelConectar.actionListenerBotaoConectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelConectar.setNomeJogador();
				//pegar daVez
				nomeUsuario = painelConectar.getNomeJogador();
				//solicita conexao
				rede.conectar(nomeUsuario, "localhost");
				
				actionListenerBotaoBatalha();
				actionListenerBotaoDesconectarMenu();
			}
		});
	}
	
	private void actionListenerBotaoBatalha(){
		painelConectar.actionListenerBotaoBatalha(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarBatalha();
				
				getContentPane().removeAll();
				painelJogoExecucao = new PainelJogoExecucao(0);
				getContentPane().add(painelJogoExecucao);
				revalidate();
				repaint();
				actionListenerBotaoDesconectarJogo();
			}
		});
		
	}
	
	private void actionListenerBotaoDesconectarMenu(){
		painelConectar.actionListenerBotaoDesconectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AtorJogador();
				fechaJanela();
				
			}
		});
	}
	
	private void actionListenerBotaoDesconectarJogo(){
		painelJogoExecucao.actionListenerBotaoDesconectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AtorJogador();
				fechaJanela();
			}
		});
	}
	
	public void enviarJogada() {
		if(mapa.ehMinhaVez())
		rede.enviarJogada(mapa.enviaJogada()); 
		else {
			JOptionPane.showMessageDialog(null, "Desculpe, N�o � a sua vez!");
		}
		
	}
	
	public void receberJogada(UmaJogada jogada) {
		this.mapa.receberJogada(jogada);
	}
	
	
	private void fechaJanela(){
		Component comp = SwingUtilities.getRoot(this);
		((Window) comp).dispose();
	}

	/*
	 * esse metodo eh chamado pelo AtorNetgames em ambos os jogadores para configurar
	 *  uma nova partida. 
	 *  parametro eh minha vez define se eu comecarei a partida
	 * 
	 */
	public void iniciarPartidaRede(boolean ehMinhaVez) {
		String nomeJogadorAdversario = rede.obterNomeAdversario();
		this.mapa = Mapa.getInstance();
		int trincheiraDefinida;
		if(ehMinhaVez) {
			mapa.criaJogador(this.nomeUsuario, true);
			mapa.criarJogadorAdversario(nomeJogadorAdversario, false);
			trincheiraDefinida = 1;
		} else {
			mapa.criaJogador(this.nomeUsuario, false);
			mapa.criarJogadorAdversario(nomeJogadorAdversario, true);
			trincheiraDefinida = 0;
		}
		
		/*
		 * tem que chamar todos os metodos de acoes dos botoes do painelJogoExecucao
		 * alem de setar valores de labels
		 */
		getContentPane().removeAll();
		painelJogoExecucao = new PainelJogoExecucao(0);
		getContentPane().add(painelJogoExecucao);
		revalidate();
		repaint();
		
	}
	
	/*
	 * solicita ao servidor iniciar uma nova partida
	 */
	public void iniciarBatalha() {
		rede.iniciarPartidaRede();
	}
	
	public void setEhMinhaVez(boolean ehMinhaVez) {
		mapa.setEhMinhaVez(ehMinhaVez);
	}

}
