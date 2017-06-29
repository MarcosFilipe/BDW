import java.security.GeneralSecurityException;
import java.util.Random;

public class Mapa implements InterfaceJogada {

	protected Torre[] trincheira;
	protected boolean turno;
	protected String imagemMapa;
	protected int width;
	protected int heigt;
	protected int tempoTurno;
	protected Carta[] cartasDoJogo;
	protected Jogador jogador1, jogador2;
	protected TimerTurno timer;
	protected boolean turnoEncerrado;

	public Mapa() {
		this.trincheira = new Torre[3];
		this.imagemMapa = "";
		this.width = 5;
		this.heigt = 10;
		cartasDoJogo = new Carta[8];
		criaDeckCartasDoJogo();
		
	}
	
	public void procedimentoDeLance(int procedimento, AtorJogador atorJogador) {
		timer = new TimerTurno(procedimento, this);
		timer.start();
		atorJogador.encerrarTurno.setEnable(true);
		atorJogador.sair.setEnable(true);
				
	}
	
	public void setTempoTurno(int procedimento) {
		if(procedimento == 0)
			this.tempoTurno = 10; // 10 segundos
		else
			this.tempoTurno = 20; // 20 segundos
	}

	public int getTempo() {
		return this.tempoTurno;
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
	
	public void setTurnoEncerrado(boolean encerrado) {
		this.turnoEncerrado = encerrado;
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
		jogador2 = new Jogador();
		jogador2.iniciar(idJogador);
	}

	public void jogadorTurnoInicial() {
		Random gerador = new Random();
		int vez = gerador.nextInt(2);
		
		if(vez == 0) {
			jogador1.setDaVez(true);
			jogador2.setDaVez(false);
		} else {
			jogador2.setDaVez(true);
			jogador1.setDaVez(false);
		}
	}
	
	public Carta getCartaDeck(int id) {
		return cartasDoJogo[id];
	}

	public boolean encerrarTurno() {
		// TODO - implement Mapa.encerrarTurno
		throw new UnsupportedOperationException();
	}

	@Override
	public void enviaJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}
	public void iniciar() {
		setJogador1();
		//this.jogador1 = gerenciador.getUsuario ver com vinicius o que é isso
		jogador1 = new Jogador();
		
	}
	public void criaDeckCartasDoJogo() {
		cartasDoJogo[0] = new Carta(9, 1, "Defesa Alta", 0, "", 20, 0);
		cartasDoJogo[1] = new Carta(5, 1, "Defesa Baixa", 1, "", 5, 6);
		cartasDoJogo[2] = new Carta(4, 0, "Defesa Media", 2, "", 10, 0);
		cartasDoJogo[3] = new Carta(3, 0, "Defesa Baixa", 3, "", 5, 0);
		cartasDoJogo[4] = new Carta(3, 0, "Ataque Medio", 4, "", 0, 6);
		cartasDoJogo[5] = new Carta(4, 0, "Ataque Medio/Alto", 5, "", 0, 8);
		cartasDoJogo[6] = new Carta(6, 1, "Ataque Alto", 6, "", 0, 10);
		cartasDoJogo[7] = new Carta(9, 1, "Ataque Extremo", 7, "", 0, 20);
		
	}

}