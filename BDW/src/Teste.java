

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.*;


public class Teste {
	
	@Test
	public void testeCriaCartasDoJogo() {
		Mapa mapa = new Mapa();
		
		mapa.criaDeckCartasDoJogo();
		Carta carta = mapa.getCartaDeck(0);
		int defesa = carta.getDefesa();
		assertEquals(defesa, 20);
	}
	
}
