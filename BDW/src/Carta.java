public class Carta {

	protected int antimateria;
	protected int tipo;
	protected String nome;
	protected int id;
	protected String img;
	protected int defesa;
	protected int ataque;
	
	public Carta(int antimateria, int tipo, String nome, int id, String img, int defesa, int ataque) {
		this.antimateria = antimateria;
		this.tipo = tipo;
		this.nome = nome;
		this.id = id;
		this.img = img;
		this.defesa = defesa;
		this.ataque = ataque;
	}
}