package modelo;
public class Jogada {

	private String nomeJogadorResponsavel;
	private int tipoJogada;
	private Carta[] carta;
	
	public Jogada(String nomeJogadorResponsavel, int tipoJogada, Carta[] carta){
		this.nomeJogadorResponsavel = nomeJogadorResponsavel;
		this.tipoJogada = tipoJogada;
		this.carta = carta;
	}
	
	public String getIdJogadorResponsavel() {
		return nomeJogadorResponsavel;
	}
	
	public void setIdJogadorResponsavel(String nomeJogadorResponsavel) {
		this.nomeJogadorResponsavel = nomeJogadorResponsavel;
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