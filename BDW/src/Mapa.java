import java.security.GeneralSecurityException;
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
	protected Carta[] cartasDaMao;
	protected Jogada jogadaRecebida;
	protected int numTurnos;

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
		this.numTurnos = 0;
	}
	
	public void procedimentoDeLance(int procedimento, AtorJogador atorJogador) {
		turnoEncerrado = false;
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
		if (this.turno == true) {
			Carta carta = getCartaDeck(idCartaSelecionada);
			
			if (verificaAntimateria(carta)) {
				if(numCartasEmJogo < 5) {
					addCartaCampo(carta);
				}
			}
		}
	}
	
	private void addCartaMao() {
		/* ta zoado. Refazer amanha. são 01:35 to caindo de sono. fui
		 * if (cartasDaMao.length < 4) {
			 boolean naoExiste = false;
			 int idCarta = 0;
			while(naoExiste == false) {
				
				Random gerador = new Random();
				int index = gerador.nextInt(8);
				for (int i = 0; i < cartasDaMao.length; i++)
					if(cartasDaMao[i].getId() == index) {
						naoExiste = true;
						break;
					}
			}
		}*/
	}
	
	private void removerCartaMao(int idCarta) {
		for (int i = 0; i < cartasDaMao.length; i++) {
			if(cartasDaMao[i].getId() == idCarta)
				cartasDaMao[i] = null;
		}
	}
	
	private void addCartaCampo(Carta carta) {
		this.numCartasEmJogo++;
		int posicao = numCartasEmJogo - 1;
		this.tabuleiro[9][posicao] = carta;
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
			numTurnos++;
			boolean vencedor = calcularDano();
			if(!vencedor){
				this.habilitarCarta();
				if(numJogadas == 0){
					jogador.decrementarAntimateria(1);
				}
			}
		}
	}
		
	private boolean calcularDano(){
		return definirVencedor();
	}
		
	private boolean definirVencedor(){
		if(numTurnos == 20){
			verificarVencedorTurnoLimite();
			return true;
		}else{
			if(verificarVencedorTrincheirasDestruidas()){
				return true;
			}
		}
		return false;
	}

	private boolean verificarVencedorTrincheirasDestruidas() {
		int numTrincheiras = 0;
		int numTrincheirasAdiversario = 0;
		for(int i = 0; i < trincheira.length; i++){
			if(trincheira[i] != null){
				numTrincheiras += 1;
			}
		}
		if(numTrincheiras == 0){
			jogadorAdversario.setVencedor(true);
			return true;
		}
		
		for(int i = 0; i < trincheiraAdversario.length; i++){
			if(trincheiraAdversario[i] != null){
				numTrincheirasAdiversario += 1;
			}
		}
		if(numTrincheirasAdiversario == 0){
			jogador.setVencedor(true);
			return true;
		}
		return false;
	}
	
	private void verificarVencedorTurnoLimite(){
		int numTrincheiras = 0;
		int numTrincheirasAdversario = 0;
		for(int i = 0; i < trincheira.length; i++){
			if(trincheira[i] != null){
				numTrincheiras += 1;
			}
		}
		for(int i = 0; i < trincheiraAdversario.length; i++){
			if(trincheiraAdversario[i] != null){
				numTrincheirasAdversario += 1;
			}
		}
		if(numTrincheiras > numTrincheirasAdversario){
			jogador.setVencedor(true);
		}else{
			if(numTrincheirasAdversario > numTrincheiras){
				jogadorAdversario.setVencedor(true);
			}
		}
	}
		 	

	@Override
	public void enviaJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
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
	
	private void desabilitarCarta(){
		for(int i = 0; i < cartasDoJogo.length; i++){
			int defesa = cartasDoJogo[i].getDefesa();
			if(defesa == 0){
				cartasDoJogo[i].setHabilitado(false);
			}
		}
	}
	
	private void habilitarCarta(){
		for(int i = 0; i < cartasDoJogo.length; i++){
			int defesa = cartasDoJogo[i].getDefesa();
			if(defesa == 0){
				cartasDoJogo[i].setHabilitado(true);
			}
		}
	}
	

}