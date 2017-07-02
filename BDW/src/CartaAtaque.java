
public class CartaAtaque extends Carta{
	protected int alvo;
	protected int ataque;

	public CartaAtaque(int antimateria, String nome, int id, String img, int ataque) {
		super(antimateria,  nome, id, img);
		this.ataque = ataque;
	}

	public int getAlvo() {
		return alvo;
	}

	public void setAlvo(int alvo) {
		this.alvo = alvo;
	}

	public int getAtaque() {
		return ataque;
	}

}
