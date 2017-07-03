package visao;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class JanelaJogo extends JFrame {

	private PainelConectar painelConectar;
	private PainelInserirNome painelInserirNome;
	private PainelEscolherTrinheira painelEscolherTrincheira;
	private AtorJogador atorJogador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaJogo frame = new JanelaJogo();
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
	public JanelaJogo() {
		atorJogador = new AtorJogador();
		
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
				painelEscolherTrincheira = new PainelEscolherTrinheira();
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
				atorJogador.iniciarNovaPartida(painelInserirNome.getNomeJogador(), trincheiraEscolhida);
				JanelaTabuleiro janelaTabuleiro = new JanelaTabuleiro(trincheiraEscolhida, atorJogador);
				fechaJanelaJogo();
				
			}
		});
	}
	
	private void fechaJanelaJogo(){
		Component comp = SwingUtilities.getRoot(this);
		((Window) comp).dispose();
	}

}
