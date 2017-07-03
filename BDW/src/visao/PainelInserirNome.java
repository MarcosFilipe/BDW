package visao;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PainelInserirNome extends JPanel {
	private JTextField textField;
	private JButton btnContinuar;

	private String nomeJogador;

	/**
	 * Create the panel.
	 */
	public PainelInserirNome() {
		setLayout(null);
		criaTextField();
		criaBotaoContinuar();
		criaLabel();
	}

	private void criaTextField() {
		textField = new JTextField();
		textField.setBounds(161, 129, 165, 22);
		add(textField);
		textField.setColumns(10);
	}

	private void criaBotaoContinuar() {
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(197, 164, 97, 25);
		add(btnContinuar);
	}

	private void criaLabel() {
		JLabel lblNomeJogador = new JLabel("Nome jogador");
		lblNomeJogador.setBounds(161, 100, 97, 16);
		add(lblNomeJogador);
	}
	
	public void actionListenerBotaoContinuar(ActionListener actionListener){
		btnContinuar.addActionListener(actionListener);
	}
	
	public void setNome(){
		this.nomeJogador = textField.getText();
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}

}
