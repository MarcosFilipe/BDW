public class Torre {

	protected int ptosdevida;
	protected int idjogadorResponsavel;
	protected String imagem;
	protected Posicao posicao;
	
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

}