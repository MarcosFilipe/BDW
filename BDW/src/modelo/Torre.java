package modelo;
public class Torre {
	private int ptosdevida;
	private String nomeJogadorResponsavel;
	
	public Torre(String nomeJogadorResponsavel){
		this.nomeJogadorResponsavel = nomeJogadorResponsavel;
		this.ptosdevida = 30;
	}
	
	public int getPtosdevida() {
		return ptosdevida;
	}
	
	public void setPtosdevida(int ptosdevida) {
		this.ptosdevida = ptosdevida;
	}
	
	public String getNomeJogadorResponsavel() {
		return nomeJogadorResponsavel;
	}
	
	public void incrementarVida(int defesa) {
		ptosdevida += defesa;
	}
	
	public void decrementarVida(int ataque){
		ptosdevida += ataque;
	}
}