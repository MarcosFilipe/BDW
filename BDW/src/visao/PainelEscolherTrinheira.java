package visao;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class PainelEscolherTrinheira extends JPanel {
	
	private JButton btnContinuar;
	private JRadioButton radioTorre1;
	private JRadioButton radioTorre2;
	
	private int trincheiraEscolhida;

	public PainelEscolherTrinheira() {
		setLayout(null);
		this.setLocation(0, 0);
		this.setVisible(true);
		
		criaBotaoContinuar();
		criaBotaoRadio();
		criaGrupoBotaoRadio();
		criaLabelTitulo();
		criaImagemTorre2();
		criaImagemTorre1();
	}

	private void criaBotaoContinuar() {
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(202, 262, 97, 25);
		add(btnContinuar);
	}

	private void criaBotaoRadio() {
		radioTorre1 = new JRadioButton("Torre 1");
		radioTorre1.setBounds(80, 73, 127, 25);
		add(radioTorre1);
		radioTorre1.setSelected(true);
		boolean selecaoBotaoTorre1 = radioTorre1.isSelected();
		if(selecaoBotaoTorre1){
			trincheiraEscolhida = 0;
		}
		radioTorre1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trincheiraEscolhida = 0;
			}
		});
		
		radioTorre2 = new JRadioButton("Torre 2");
		radioTorre2.setBounds(321, 73, 127, 25);
		add(radioTorre2);
		radioTorre2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trincheiraEscolhida = 1;
			}
		});
	}

	private void criaGrupoBotaoRadio() {
		ButtonGroup escolhaTorre = new ButtonGroup(); 
		escolhaTorre.add(radioTorre1); 
		escolhaTorre.add(radioTorre2);
	}

	private void criaLabelTitulo() {
		JLabel lblEscolhaASua = new JLabel("Escolha a sua torre");
		lblEscolhaASua.setBounds(187, 13, 120, 16);
		add(lblEscolhaASua);
	}

	private void criaImagemTorre2() {
		ImageIcon imagemTorre2 = new ImageIcon("resources" + File.separator + "torre2.png");
		JLabel label_2 = new JLabel();
		label_2.setIcon(imagemTorre2);
		label_2.setBounds(317, 107, 106, 105);
		add(label_2);
	}

	private void criaImagemTorre1() {
		ImageIcon imagemTorre1 = new ImageIcon("resources" + File.separator + "torre1.png");
		JLabel label_1 = new JLabel();
		label_1.setIcon(imagemTorre1);
		label_1.setBounds(90, 107, 106, 105);
		add(label_1);
	}
	
	public void actionListenerBotaoContinuar(ActionListener actionListener){
		btnContinuar.addActionListener(actionListener);
	}
	
	public int getTrincheiraEscolhida() {
		return trincheiraEscolhida;
	}

}
