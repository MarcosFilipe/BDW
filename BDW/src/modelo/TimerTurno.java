package modelo;

public class TimerTurno extends Thread{
	protected int tempo;
	protected Mapa mapa;
	
	public TimerTurno(int procedimento, Mapa mapa) {
		if(procedimento == 1)
			this.tempo = 20;
		else 
			this.tempo = 10;
		
		this.mapa = mapa;
	}
	
	@Override
	public void run() {
		int cont = tempo;
		
		while(cont != 0) {
			try {
				System.out.println(cont);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cont--;
		}
		
		mapa.setTurnoEncerrado(true);
		
		
	}

}
