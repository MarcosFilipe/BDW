package modelo;

public class CartaAtaque extends Carta{
	
	private int ataque;

	public CartaAtaque(int antimateria, String nome, int id, String img, int ataque) {
		super(antimateria,  nome, id, img);
		this.ataque = ataque;
	}

	public int getAtaque() {
		return ataque;
	}

}
