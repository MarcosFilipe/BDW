package visao;
import javax.swing.JButton;

import modelo.AtorNetGames;
import modelo.Carta;
import modelo.Jogada;
import modelo.Mapa;

public class AtorJogador {

	protected Mapa mapa;
	protected AtorNetGames rede;
	protected String nomeUsuario;
	public JButton encerrarTurno; // nao usado
	public JButton sair;          // nao usado

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		mapa.receberJogada(jogada);
	}

	public void executarDefesa() {
		// TODO - implement AtorJogador.executarDefesa
		throw new UnsupportedOperationException();
	}

	public void iniciarNovaPartida(String nome, int trincheiraEscolhida) {
		this.mapa = new Mapa();
		mapa.criaJogador(nome);
		//! aqui so ta comentado pra funcionar a interface grafica ja que
		// nao foi implementado a parte do net games
		
		//mapa.criarJogadorAdversario(rede.informarAdversario());
		//mapa.jogadorTurnoInicial();
		//exibirEstado();
	}

	public void exibirEstado() {
		// TODO - implement AtorJogador.exibirEstado
		throw new UnsupportedOperationException();
	}

	public void notificarRegularidade() {
		// TODO - implement AtorJogador.notificarRegularidade
		throw new UnsupportedOperationException();
	}

	public void notificarIrregularidade() {
		// TODO - implement AtorJogador.notificarIrregularidade
		throw new UnsupportedOperationException();
	}

	public void encerrarTurno() {
		// TODO - implement AtorJogador.encerrarTurno
		throw new UnsupportedOperationException();
	}
	

	/**
	 * 
	 * @param listaCartas
	 */
	public Carta selecionarCarta(Carta listaCartas) {
		// TODO - implement AtorJogador.selecionarCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaCartas
	 */
	public Carta selecionarCarta(Carta[] listaCartas) {
		// TODO - implement AtorJogador.selecionarCarta
		throw new UnsupportedOperationException();
	}

}