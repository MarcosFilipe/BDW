package modelo;
public class Carta {

	protected int antimateria;
	protected String nome;
	protected int id;
	protected String img;
	protected boolean habilitado;
	protected int alvo;
	
	public Carta(int antimateria, String nome, int id, String img) {
		this.antimateria = antimateria;
		this.nome = nome;
		this.id = id;
		this.img = img;
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

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void setHabilitado(boolean habilitado){
		this.habilitado = habilitado;
	}
			
	public boolean getHabilitado(){
		return habilitado;
	}

	public int getAlvo() {
		return alvo;
	}

	public void setAlvo(int alvo) {
		this.alvo = alvo;
	}
}