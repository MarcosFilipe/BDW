package visao;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class PainelConectar extends JPanel {
	
	private JButton btnConectar;

	/**
	 * Create the panel.
	 */
	public PainelConectar() {
		this.setSize(500, 300);
		this.setLocation(0, 0);
		setLayout(null);
		
		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(183, 134, 138, 25);
		add(btnConectar);
		
	}
	
	public void actionListenerBotaoConectar(ActionListener actionListener){
		btnConectar.addActionListener(actionListener);
	}

}
