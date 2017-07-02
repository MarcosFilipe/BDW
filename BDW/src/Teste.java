

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Teste {
	
	private Mapa mapa;
	
	@Before
    public void iniciaTestes(){
        mapa = new Mapa();
    }
	
	@Test
	public void verificaVencedorTurnoFinal() {
		mapa.jogador = new Jogador("nome1");
		mapa.jogadorAdversario = new Jogador("nome2");
		mapa.numTurnos = 20;
		for(int i = 0; i < 3; i++){
			mapa.trincheira[i] = new Torre(i);
		}
		for(int i = 0; i < 1; i++){
			mapa.trincheiraAdversario[i] = new Torre(i+3);
		}
		mapa.definirVencedor();
		//System.out.println(mapa.jogador.getVencedor());
		//System.out.println(mapa.jogadorAdversario.getVencedor());
		assertEquals(true, mapa.definirVencedor());
	}
	
	@Test
	public void verificaVencedorTrincheira() {
		mapa.jogador = new Jogador("nome1");
		mapa.jogadorAdversario = new Jogador("nome2");
		mapa.numTurnos = 5;
		for(int i = 0; i < 3; i++){
			mapa.trincheira[i] = new Torre(i);
		}
		mapa.definirVencedor();
		//System.out.println(mapa.jogador.getVencedor());
		//System.out.println(mapa.jogadorAdversario.getVencedor());
		assertEquals(true, mapa.definirVencedor());
		
		for(int i = 0; i < 1; i++){
			mapa.trincheiraAdversario[i] = new Torre(i+3);
		}
		assertEquals(false, mapa.definirVencedor());
	}
	
}
