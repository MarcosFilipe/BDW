public class Carta {

	protected int antimateria;
	protected int tipo;
	protected String nome;
	protected int id;
	protected String img;
	protected int defesa;
	protected int ataque;
	protected boolean habilitado;
	
	public Carta(int antimateria, int tipo, String nome, int id, String img, int defesa, int ataque) {
		this.antimateria = antimateria;
		this.tipo = tipo;
		this.nome = nome;
		this.id = id;
		this.img = img;
		this.defesa = defesa;
		this.ataque = ataque;
		this.habilitado = true;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getAntimateria() {
		return antimateria;
	}

	public int getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public int getDefesa() {
		return defesa;
	}

	public int getAtaque() {
		return ataque;
	}
	
	public void setHabilitado(boolean habilitado){
		this.habilitado = habilitado;
	}
			
	public boolean getHabilitado(){
		return habilitado;
	}
}