package modelo;
public class Jogador {

	private int antimateria;
	private boolean vencedor;
	private boolean daVez;
	private String nome;
	private int[] deck;
	private Carta[] cartasEmJogo;
	private TimerTurno timer;    // nao usado
	
	public Jogador(String nome){
		this.nome = nome;
		this.deck = new int[4];
		this.antimateria = 10;
		this.vencedor = false;
		this.daVez = false;
	}
	
	public int[] getDeck() {
		return deck;
	}

	public void setDeck(int posicao, int indiceCarta) {
		this.deck[posicao] = indiceCarta;
	}

	/**
	 * 
	 * @param tempoAtualTurno
	 */
	
	/*
	 * necessidade do metodo na classe jogador?
	 * procedimento atributo da classe mapa
	 * 
	public Jogada enviaJogada() {
		Jogada jogada = new Jogada(id, procedimento, cartasEmJogo);
		return jogada;
	}
	*/
	
	public void adicionarAntimateria(int antimateriaAdicao){
		this.antimateria += antimateriaAdicao;
		if(antimateria > 10){
			this.antimateria = 10;
		}
	}
			
	public void decrementarAntimateria(int antimateriaDecremento){
		this.antimateria -= antimateriaDecremento;
	}
	
	public void setAntimateria(int antimateria) {
		this.antimateria = antimateria;
	}
	
	public int getAntimateria() {
		return this.antimateria;
	}
		
	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}
			
	public boolean getVencedor() {
		return vencedor;
	}
		
	public String getNome() {
		return nome;
	}
	
	public void setDaVez(boolean daVez) {
		this.daVez = daVez;
	}
			
	public boolean getDaVez(){
		return this.daVez;
	}	 
	
	public Carta[] getCartasEmJogo(){
		return cartasEmJogo;
	}
	public Carta getCartaDoCampo(int posicao) {
		return this.cartasEmJogo[posicao];
	}
	
	public void addCartaCampo(int posicao, Carta carta) {
		this.cartasEmJogo[posicao] = carta;
	}

}