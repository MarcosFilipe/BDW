package visao;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class PainelIniciarPartida extends JPanel {
	
	private JButton btnConectar;
	private JTextField textField;
	private String nomeJogador;

	/**
	 * Create the panel.
	 */
	public PainelIniciarPartida() {
		super();
		criaPainel();
		criaBotaoConectar();
		
	}

	private void criaPainel() {
		this.setSize(500, 300);
		this.setLocation(0, 0);
		setLayout(null);
	}

	private void criaBotaoConectar() {
		btnConectar = new JButton("Batalha");
		btnConectar.setBounds(161, 161, 165, 25);
		add(btnConectar);
	}
	
	
	public void actionListenerBotaoConectar(ActionListener actionListener){
		btnConectar.addActionListener(actionListener);
	}
	
	public void setNomeJogador(){
		this.nomeJogador = textField.getText();
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}

}
