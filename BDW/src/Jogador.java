public class Jogador implements InterfaceJogada {

	protected int ptosdevida;
	protected boolean vencedor;
	protected boolean daVez;
	protected Carta attribute;
	protected String nome;
	protected int id;
	protected Carta deck;
	protected boolean turno;
	protected TimerTurno timer;
	protected boolean turnoEncerrado;
	

	/**
	 * 
	 * @param procedimento
	 */
	public void procedimentoDeLance(int procedimento, AtorJogador atorJogador) {
		timer = new TimerTurno(procedimento, this);
		timer.start();
		atorJogador.encerrarTurno.setEnable(true);
		atorJogador.sair.setEnable(true);
				
		
	}

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
	
	public void setTurnoEncerrado(boolean encerrado) {
		this.turnoEncerrado = encerrado;
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

}