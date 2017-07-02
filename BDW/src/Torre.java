public class Torre {
	protected int ptosdevida;
	protected int idjogadorResponsavel;
	protected String imagem;
	
	public Torre(int idJogadorResponsavel){
		this.idjogadorResponsavel = idJogadorResponsavel;
		this.ptosdevida = 30;
	}
	
	public int getPtosdevida() {
		return ptosdevida;
	}
	
	public void setPtosdevida(int ptosdevida) {
		this.ptosdevida = ptosdevida;
	}
	
	public int getIdjogadorResponsavel() {
		return idjogadorResponsavel;
	}
	
	public void incrementarVida(int defesa) {
		ptosdevida += defesa;
	}
	
	public void decrementarVida(int ataque){
		ptosdevida += ataque;
	}
}