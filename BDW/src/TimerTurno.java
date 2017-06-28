
public class TimerTurno extends Thread{
	protected int tempo;
	protected Jogador jogador;
	
	public TimerTurno(int procedimento, Jogador jogador) {
		if(procedimento == 1)
			this.tempo = 20;
		else 
			this.tempo = 10;
		
		this.jogador = jogador;
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
		
		jogador.setTurnoEncerrado(true);
		
		
	}

}
