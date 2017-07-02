import javax.swing.JButton;

public class AtorJogador {

	protected Mapa mapa;
	protected AtorNetGames rede;
	protected String idUsuario;
	public JButton encerrarTurno;
	public JButton sair;

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

	public void iniciarNovaPartida() {
		this.mapa = new Mapa();
		mapa.criaJogador("nome");
		mapa.criarJogadorAdversario(rede.informarAdversario());
		mapa.jogadorTurnoInicial();
		exibirEstado();
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