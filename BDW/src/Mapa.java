import java.util.Random;

public class Mapa implements InterfaceJogada {

	protected Torre[] trincheira, trincheiraAdversario;
	protected boolean turno;
	protected String imagemMapa;
	protected int width;
	protected int heigt;
	protected int tempoTurno;
	protected Carta[] cartasDoJogo;
	protected Jogador jogador, jogadorAdversario;
	protected TimerTurno timer;
	protected boolean turnoEncerrado;
	protected Object tabuleiro[][];
	protected int numCartasEmJogo;
	protected Jogada jogadaRecebida;
	protected int numJogadas;
	

	public Mapa() {
		this.trincheira = new Torre[3];
		this.trincheiraAdversario = new Torre[3];
		this.imagemMapa = "";
		this.width = 5;
		this.heigt = 10;
		this.numCartasEmJogo = 0;
		cartasDoJogo = new Carta[8];
		criaDeckCartasDoJogo();
		this.tabuleiro = new Object[width][heigt];
		
	}
	
	public void procedimentoDeLance(int procedimento, AtorJogador atorJogador) {
		numJogadas = 0;
		iniciarTurno(procedimento);
		turnoEncerrado = false;
		timer = new TimerTurno(procedimento, this);
		timer.start();
		atorJogador.encerrarTurno.setEnabled(true);
		atorJogador.sair.setEnabled(true);
		
		boolean encerrar = false;
		while(encerrar == false)
			if(turnoEncerrado) {
				encerrarTurno(procedimento, numJogadas);
			}
		
				
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
	public boolean verificaAntimateria(Carta cartaSelecionada) {
		int antimateriaJogador = jogador.getAntimateria();
		int antimateriaCarta = cartaSelecionada.getAntimateria();
		
		if(antimateriaJogador >= antimateriaCarta)
			return true;
		else 
			return false;
	}
	
	public void setTurnoEncerrado(boolean encerrado) {
		this.turnoEncerrado = encerrado;
	}

	/**
	 * 
	 * @param idCartaSelecionada
	 * @param posiEscolhida
	 */
	public void invocarCarta(int idCartaSelecionada) {
		
			if(jogador.daVez) {
				Carta carta = getCartaDeck(idCartaSelecionada);
				if (!carta.getHabilitado()) {
					//alerta falha
				} else
					if (verificaAntimateria(carta)) {
						if(jogador.cartasEmJogo.length < 5) {
							addCartaCampo(carta);
							jogador.decrementarAntimateria(carta.getAntimateria());
							numJogadas++;
						}
					}
			}	
	}
			
	
	private void addNovaCartaMao() {
		  if (jogador.deck.length < 4) {
			 boolean existe = true;
			 int index = 0;
			 
			while(existe == true) {
				existe = false;
				Random gerador = new Random();
				 index = gerador.nextInt(8);
				
				for (int i = 0; i < jogador.deck.length; i++)
					if(jogador.deck[i] == index) {
						existe = true;
					}
			}
			int posicao = jogador.deck.length;
			jogador.deck[posicao] = index;
		}
	}
	
	private void removerCartaMao(int idCarta) {
		for (int i = 0; i < jogador.deck.length; i++) {
			if(jogador.deck[i] == idCarta) {
				jogador.deck[i] = (Integer) null;
				
				addNovaCartaMao();
				
			}
		}
	}
	
	private void addCartaCampo(Carta carta) {
		int posicao = jogador.cartasEmJogo.length;
		jogador.addCartaCampo(posicao, carta);
		removerCartaMao(carta.getId());
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
		this.jogadaRecebida = jogada;
		int tipoJogada = jogadaRecebida.getTipoJogada();
		if(tipoJogada == 1){
			jogador.setDaVez(true);
		}
 	}
		 	

	public void setJogador1() {
		// TODO - implement Mapa.setJogador1
		throw new UnsupportedOperationException();
	}

	/*
	 * verificar a necessidade de id
	 */
	public void criaJogador(String nome) {
		jogador = new Jogador(nome);
		for(int i = 0; i < 3; i++){
			trincheira[i] = new Torre(jogador.getId());
		}
	}
	
	public void criarJogadorAdversario(Jogador jogadorAdversario) {
		this.jogadorAdversario = jogadorAdversario;
		for(int i = 0; i < 3; i++){
			trincheiraAdversario[i] = new Torre(this.jogadorAdversario.getId());
		}
	}

	public void jogadorTurnoInicial() {
		Random gerador = new Random();
		int vez = gerador.nextInt(2);
		
		if(vez == 0) {
			jogador.setDaVez(true);
			jogadorAdversario.setDaVez(false);
		} else {
			jogadorAdversario.setDaVez(true);
			jogador.setDaVez(false);
		}
	}
	
	public Carta getCartaDeck(int id) {
		return cartasDoJogo[id];
	}

	public void encerrarTurno(int procedimento, int numJogadas) {
		if(procedimento == 1){
			jogador.setDaVez(false);
		}else{
			boolean vencedor = calcularDano();
			if(!vencedor){
				this.habilitarCarta();
				if(numJogadas == 0){
					jogador.decrementarAntimateria(1);
				}
			}
		}
	}
		
	public boolean calcularDano(){
		return false;
	}
		
	public boolean definirVencedor(){
		return false;
	}
		 	

	@Override
	public void enviaJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}
	
	public void criaDeckCartasDoJogo() {
		cartasDoJogo[0] = new CartaDefesa(9, "Defesa Alta", 0, "", 20);
		cartasDoJogo[1] = new CartaDefesa(6, "Defesa Media/Alta", 1, "", 15);
		cartasDoJogo[2] = new CartaDefesa(4, "Defesa Media", 2, "", 10);
		cartasDoJogo[3] = new CartaDefesa(3, "Defesa Baixa", 3, "", 5);
		cartasDoJogo[4] = new CartaAtaque(3, "Ataque Medio", 4, "", 6);
		cartasDoJogo[5] = new CartaAtaque(4, "Ataque Medio/Alto", 5, "", 8);
		cartasDoJogo[6] = new CartaAtaque(6, "Ataque Alto", 6, "", 10);
		cartasDoJogo[7] = new CartaAtaque(9, "Ataque Extremo", 7, "", 20);
		
	}
	
	public void iniciarTurno(int procedimento){
		boolean daVez = jogador.getDaVez();
		if(daVez){
			if(procedimento == 1){
				jogador.adicionarAntimateria(2);
				//definir tempo de turno
			}else{
				jogador.adicionarAntimateria(1);
				//definir tempo de turno
				this.desabilitarCarta();
			}
		}
	}
	
	public void desabilitarCarta(){
		for(int i = 0; i < cartasDoJogo.length; i++){
			int defesa = cartasDoJogo[i].getDefesa();
			if(defesa == 0){
				cartasDoJogo[i].setHabilitado(false);
			}
		}
	}
	
	public void habilitarCarta(){
		for(int i = 0; i < cartasDoJogo.length; i++){
			int defesa = cartasDoJogo[i].getDefesa();
			if(defesa == 0){
				cartasDoJogo[i].setHabilitado(true);
			}
		}
	}
	

}