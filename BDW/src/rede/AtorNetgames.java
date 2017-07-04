package rede;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import modelo.UmaJogada;
import visao.AtorJogador;

public class AtorNetgames implements OuvidorProxy {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Proxy proxy;
	private AtorJogador atorJogador;
	private boolean ehMinhaVez;
	
	public AtorNetgames(AtorJogador atorJogador) {
		super();
		ehMinhaVez = false;	
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	
	public void conectar(String nome, String servidor) {
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarJogada(UmaJogada jogada) {
		UmaJogada umaJogada = jogada;
		try {
			proxy.enviaJogada(umaJogada);
			this.ehMinhaVez = false;
		} catch (NaoJogandoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		if(posicao == 1) 
			ehMinhaVez = true;
		else if(posicao == 2)
			ehMinhaVez = false;
		
		atorJogador.iniciarPartidaRede(ehMinhaVez);
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(atorJogador, message);

	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberJogada(Jogada jogada) {
		UmaJogada lance = (UmaJogada) jogada;
		atorJogador.receberJogada(lance);
		ehMinhaVez = true;

	}

	@Override
	public void tratarConexaoPerdida() {
		JOptionPane.showMessageDialog(atorJogador,"A conexão com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador, message);

	}
	
	public void desconectar() {
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String obterNomeAdversario() {
		String nome = "";
		if(ehMinhaVez)
			nome = proxy.obterNomeAdversario(2);
		else 
			nome = proxy.obterNomeAdversario(1);
		return nome;
	}


}
