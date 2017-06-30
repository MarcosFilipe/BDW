public class Jogada {

	protected int idJogadorResponsavel;
	protected int tipoJogada;
	protected Carta[] carta;
	
	public Jogada(int idJogadorResponsavel, int tipoJogada, Carta[] carta){
		this.idJogadorResponsavel = idJogadorResponsavel;
		this.tipoJogada = tipoJogada;
		this.carta = carta;
	}
	
	public int getIdJogadorResponsavel() {
		return idJogadorResponsavel;
	}
	
	public void setIdJogadorResponsavel(int idJogadorResponsavel) {
		this.idJogadorResponsavel = idJogadorResponsavel;
	}
	
	public int getTipoJogada() {
		return tipoJogada;
	}
	
	public void setTipoJogada(int tipoJogada) {
		this.tipoJogada = tipoJogada;
	}
	
	public Carta[] getCarta() {
		return carta;
	}
	
	public void setCarta(Carta[] carta) {
		this.carta = carta;
	}

}