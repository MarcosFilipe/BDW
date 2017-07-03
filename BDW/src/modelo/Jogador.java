package modelo;
public class Jogador {

	protected int antimateria;
	protected boolean vencedor;
	protected boolean daVez;
	protected String nome;
	protected int[] deck;
	protected Carta[] cartasEmJogo;
	protected TimerTurno timer;
	
	public Jogador(String nome){
		this.nome = nome;
		this.antimateria = 10;
		this.vencedor = false;
		this.daVez = false;
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