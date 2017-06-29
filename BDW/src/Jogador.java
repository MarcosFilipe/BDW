public class Jogador implements InterfaceJogada {

	protected int ptosdevida;
	protected boolean vencedor;
	protected boolean daVez;
	protected Carta attribute;
	protected String nome;
	protected int id;
	protected Carta deck;
	protected boolean turno;
	protected int antimateria;

	/**
	 * 
	 * @param procedimento
	 */

	/**
	 * 
	 * @param tempoAtualTurno
	 */
	public boolean verificaTempoSeExcedeu(int tempoAtualTurno) {
		// TODO - implement Jogador.verificaTempoSeExcedeu
		throw new UnsupportedOperationException();
	}

	public void setDaVez(boolean daVez) {
		this.daVez = daVez;
	}
	

	public boolean informarDaVez() {
		// TODO - implement Jogador.informarDaVez
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement Jogador.operation
		throw new UnsupportedOperationException();
	}

	@Override
	public void enviaJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}

	public void iniciar(String idJogador) {
		// TODO Auto-generated method stub
		
	}
	
	public int getAntimateria() {
		return this.antimateria;
	}

}