package visao;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class PainelConectar extends JPanel {
	
	private JButton btnConectar;
	private JButton botaoDesconectar;
	private JButton botaoBatalha;
	private JTextField textField;
	private JLabel lblNomeJogador;
	private String nomeJogador;

	/**
	 * Create the panel.
	 */
	public PainelConectar() {
		criaPainel();
		criaBotaoConectar();
		criaTextField();
		criaLabel();
		criaBotaoBatalha();
		criaBotaoDesconectar();
	}

	private void criaPainel() {
		this.setSize(603, 784);
		this.setLocation(0, 0);
		setLayout(null);
	}

	private void criaBotaoConectar() {
		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(190, 390, 234, 25);
		add(btnConectar);
	}
	
	private void criaTextField() {
		textField = new JTextField();
		textField.setBounds(190, 355, 234, 22);
		add(textField);
		textField.setColumns(10);
	}

	private void criaLabel() {
		lblNomeJogador = new JLabel("Nome jogador");
		lblNomeJogador.setBounds(190, 335, 97, 16);
		add(lblNomeJogador);
	}
	
	private void criaBotaoDesconectar() {
		botaoDesconectar = new JButton("Desconectar");
		botaoDesconectar.setEnabled(false);
		botaoDesconectar.setBounds(314, 428, 110, 25);
		add(botaoDesconectar);
	}

	private void criaBotaoBatalha() {
		botaoBatalha = new JButton("Batalha");
		botaoBatalha.setEnabled(false);
		botaoBatalha.setBounds(190, 428, 110, 25);
		add(botaoBatalha);
	}
	
	public void actionListenerBotaoConectar(ActionListener actionListener){
		btnConectar.addActionListener(actionListener);
	}
	
	public void actionListenerBotaoBatalha(ActionListener actionListener){
		botaoBatalha.addActionListener(actionListener);
		atualizaPainel();
	}
	
	public void actionListenerBotaoDesconectar(ActionListener actionListener){
		botaoDesconectar.addActionListener(actionListener);
	}
	
	public void setNomeJogador(){
		this.nomeJogador = textField.getText();
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}
	
	private void atualizaPainel(){
		lblNomeJogador.setEnabled(false);
		textField.setEnabled(false);
		btnConectar.setEnabled(false);
		botaoBatalha.setEnabled(true);
		botaoDesconectar.setEnabled(true);
	}
}
