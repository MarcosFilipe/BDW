public class Mapa implements InterfaceJogada {

	protected String nome;
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Torre trincheira;
	protected Torre base;
	protected int turno;
	protected String imagemMapa;
	protected int width;
	protected int heigt;
	protected int tempoTurno;
	protected Carta deck;

	/**
	 * 
	 * @param procedimento
	 */
	public void setTempoTurno(int procedimento) {
		this.tempoTurno = procedimento;
	}

	public int getTempo() {
		// TODO - implement Mapa.getTempo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Carta selecionarCarta(int id) {
		// TODO - implement Mapa.selecionarCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cartaSelecionada
	 */
	public void verificaAntimateria(Carta cartaSelecionada) {
		// TODO - implement Mapa.verificaAntimateria
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cartaSelecionada
	 * @param posiEscolhida
	 */
	public void invocarCarta(Carta cartaSelecionada, Posicao posiEscolhida) {
		// TODO - implement Mapa.invocarCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param msg
	 */
	public void alertarFalha(String msg) {
		// TODO - implement Mapa.alertarFalha
		throw new UnsupportedOperationException();
	}

	public void mouseClicked() {
		// TODO - implement Mapa.mouseClicked
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement Mapa.operation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		// TODO - implement Mapa.receberJogada
		throw new UnsupportedOperationException();
	}

	public void setJogador1() {
		// TODO - implement Mapa.setJogador1
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idJogador
	 */
	public void criarJogador(String idJogador) {
		// TODO - implement Mapa.criarJogador
		throw new UnsupportedOperationException();
	}

	public void jogadorTurnoInicial() {
		// TODO - implement Mapa.jogadorTurnoInicial
		throw new UnsupportedOperationException();
	}

	public boolean encerrarTurno() {
		// TODO - implement Mapa.encerrarTurno
		throw new UnsupportedOperationException();
	}

	@Override
	public void enviaJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}

}