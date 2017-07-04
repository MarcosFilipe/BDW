package visao;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class PainelConectar extends JPanel {
	
	private JButton btnConectar;
	private JTextField textField;
	private String nomeJogador;

	/**
	 * Create the panel.
	 */
	public PainelConectar() {
		criaPainel();
		criaBotaoConectar();
		criaTextField();
		criaLabel();
	}

	private void criaPainel() {
		this.setSize(500, 300);
		this.setLocation(0, 0);
		setLayout(null);
	}

	private void criaBotaoConectar() {
		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(161, 161, 165, 25);
		add(btnConectar);
	}
	
	private void criaTextField() {
		textField = new JTextField();
		textField.setBounds(161, 129, 165, 22);
		add(textField);
		textField.setColumns(10);
	}

	private void criaLabel() {
		JLabel lblNomeJogador = new JLabel("Nome jogador");
		lblNomeJogador.setBounds(161, 100, 97, 16);
		add(lblNomeJogador);
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
