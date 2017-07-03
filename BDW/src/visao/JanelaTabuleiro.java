package visao;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JanelaTabuleiro extends JFrame {
	
	private PainelJogoExecucao painelJogoExecucao;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaTabuleiro frame = new JanelaTabuleiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public JanelaTabuleiro(int trincheiraEscolhida, AtorJogador atorJogador) {
		this.setTitle("Black Dots War");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 839);
		this.setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		painelJogoExecucao = new PainelJogoExecucao(trincheiraEscolhida);
		getContentPane().add(painelJogoExecucao);
		
		actionListenerBotaoDesconectar();
	}
	
	public void actionListenerBotaoDesconectar(){
		painelJogoExecucao.actionListenerBotaoDesconectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaJogo();
				fechaJanelaTabuleiro();
				
			}
		});
	}
	
	public void atualizarJanela(int trincheiraEscolhida){
		
	}
	
	private void fechaJanelaTabuleiro(){
		Component comp = SwingUtilities.getRoot(this);
		((Window) comp).dispose();
	}
}
