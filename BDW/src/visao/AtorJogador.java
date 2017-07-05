package visao;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modelo.Carta;
import modelo.Mapa;
import modelo.UmaJogada;
import rede.AtorNetgames;


public class AtorJogador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PainelConectar painelConectar;
	private PainelJogoExecucao painelJogoExecucao;
	
	private Mapa mapa;
	private AtorNetgames rede;
	private String nomeUsuario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtorJogador frame = new AtorJogador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtorJogador() {
		
		this.setTitle("Black Dots War");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 839);
		this.setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		rede = new AtorNetgames(this);
		painelConectar = new PainelConectar();
		getContentPane().add(painelConectar);
		actionListenerBotaoConectar();
		
		
	}
	
	private void actionListenerBotaoConectar(){
		painelConectar.actionListenerBotaoConectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelConectar.setNomeJogador();
				//pegar daVez
				nomeUsuario = painelConectar.getNomeJogador();
				//solicita conexao
				rede.conectar(nomeUsuario, "localhost");
				
				actionListenerBotaoBatalha();
				actionListenerBotaoDesconectarMenu();
			}
		});
	}
	
	private void actionListenerBotaoBatalha(){
		painelConectar.actionListenerBotaoBatalha(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarBatalha();
				/*
				getContentPane().removeAll();
				painelJogoExecucao = new PainelJogoExecucao(0);
				getContentPane().add(painelJogoExecucao);
				revalidate();
				repaint();
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
				painelJogoExecucao.atualizaVidaTorres(mapa.getTrincheira(), mapa.getTrincheiraAdversario());
				*/
			}
		});
		
	}
	
	private void actionListenerBotaoDesconectarMenu(){
		painelConectar.actionListenerBotaoDesconectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rede.desconectar();
				new AtorJogador();
				fechaJanela();
				
			}
		});
	}
	
	private void actionListenerBotaoDesconectarJogo(){
		painelJogoExecucao.actionListenerBotaoDesconectar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rede.desconectar();
				new AtorJogador();
				fechaJanela();
			}
		});
	}
	
	private void actionListenerBotaoEncerrarTurno(){
		painelJogoExecucao.actionListenerBotaoEncerrarTurno(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * enviarJogada para adversario
				 * verificar de quem eh a vez
				 * 
				 * encerrarTurno:
				 * numJogadas
				 */
				enviarJogada();
				mapa.encerrarTurno();
				
			}
		});
	}
	
	private void actCarta0(){
		painelJogoExecucao.actCarta0(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.setIdCarta(0);
				painelJogoExecucao.elementosTurnoOponente();
				
			}
		});
	}
	private void actCarta1(){
		painelJogoExecucao.actCarta1(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.setIdCarta(1);
				painelJogoExecucao.elementosTurnoOponente();
				
			}
		});
	}
	private void actCarta2(){
		painelJogoExecucao.actCarta2(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.setIdCarta(2);
				painelJogoExecucao.elementosTurnoOponente();
				
			}
		});
	}
	private void actCarta3(){
		painelJogoExecucao.actCarta3(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelJogoExecucao.setIdCarta(3);
				painelJogoExecucao.elementosTurnoOponente();
				
			}
		});
	}

	private void actTorre1(){
		painelJogoExecucao.actTorre1(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.acaoBotaoTorre(0);
				mapa.invocarCarta(painelJogoExecucao.getIdCarta(), painelJogoExecucao.getAlvo());
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
				
			}
		});
	}
	private void actTorre2(){
		painelJogoExecucao.actTorre2(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.acaoBotaoTorre(1);
				mapa.invocarCarta(painelJogoExecucao.getIdCarta(), painelJogoExecucao.getAlvo());
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
				
			}
		});
	}
	private void actTorre3(){
		painelJogoExecucao.actTorre3(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.acaoBotaoTorre(2);
				mapa.invocarCarta(painelJogoExecucao.getIdCarta(), painelJogoExecucao.getAlvo());
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
				
			}
		});
	}
	private void actTorreA1(){
		painelJogoExecucao.actTorreA1(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.acaoBotaoTorre(0);
				mapa.invocarCarta(painelJogoExecucao.getIdCarta(), painelJogoExecucao.getAlvo());
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
				
			}
		});
	}
	private void actTorreA2(){
		painelJogoExecucao.actTorreA2(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.acaoBotaoTorre(1);
				mapa.invocarCarta(painelJogoExecucao.getIdCarta(), painelJogoExecucao.getAlvo());
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
				
			}
		});
	}
	private void actTorreA3(){
		painelJogoExecucao.actTorreA3(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painelJogoExecucao.acaoBotaoTorre(2);
				mapa.invocarCarta(painelJogoExecucao.getIdCarta(), painelJogoExecucao.getAlvo());
				painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
			}
		});
	}
	
	public void enviarJogada() {
		if(mapa.ehMinhaVez())
		rede.enviarJogada(mapa.enviaJogada()); 
		else {
			JOptionPane.showMessageDialog(null, "Desculpe, N�o � a sua vez!");
		}
		
	}
	
	public void receberJogada(UmaJogada jogada) {
		this.mapa.receberJogada(jogada, this);
		
	}
	
	
	private void fechaJanela(){
		Component comp = SwingUtilities.getRoot(this);
		((Window) comp).dispose();
	}

	/*
	 * esse metodo eh chamado pelo AtorNetgames em ambos os jogadores para configurar
	 *  uma nova partida. 
	 *  parametro eh minha vez define se eu comecarei a partida
	 * 
	 */
	public void iniciarPartidaRede(boolean ehMinhaVez) {
		String nomeJogadorAdversario = rede.obterNomeAdversario();
		this.mapa = Mapa.getInstance();
		int trincheiraDefinida;
		if(ehMinhaVez) {
			mapa.criaJogador(this.nomeUsuario, true);
			mapa.criarJogadorAdversario(nomeJogadorAdversario, false);
			trincheiraDefinida = 1;
			mapa.procedimentoDeLance(1, this);
		} else {
			mapa.criaJogador(this.nomeUsuario, false);
			mapa.criarJogadorAdversario(nomeJogadorAdversario, true);
			trincheiraDefinida = 0;
		}
		/*
		 * tem que chamar todos os metodos de acoes dos botoes do painelJogoExecucao
		 * alem de setar valores de labels
		 */
		getContentPane().removeAll();
		painelJogoExecucao = new PainelJogoExecucao(trincheiraDefinida);
		//painelJogoExecucao.imagemCartaBotao(mapa.getCartasDoJogo());
		//painelJogoExecucao.criaBotoes();
		getContentPane().add(painelJogoExecucao);
		revalidate();
		repaint();
		painelJogoExecucao.atualizaLabels(mapa.getAntimateria(), mapa.getNumTurnos());
		painelJogoExecucao.atualizaVidaTorres(mapa.getTrincheira(), mapa.getTrincheiraAdversario());
		mapa.criaPrimeirasCartas();
		setarFuncaoBotao();
		
	}
	
	/*
	 * solicita ao servidor iniciar uma nova partida
	 */
	public void iniciarBatalha() {
		rede.iniciarPartidaRede();
	}
	
	public void setEhMinhaVez(boolean ehMinhaVez) {
		mapa.setEhMinhaVez(ehMinhaVez);
	}
	
	private void setarFuncaoBotao(){
		actionListenerBotaoEncerrarTurno();
		actionListenerBotaoDesconectarJogo();
		actCarta0();
		actCarta1();
		actCarta3();
		actCarta2();
		actTorre1();
		actTorre2();
		actTorre3();
		actTorreA1();
		actTorreA2();
		actTorreA3();
	}
	
	private void criaCarta(Carta[] cartasJogador){
		painelJogoExecucao.imagemCartaBotao(cartasJogador);
		int id = painelJogoExecucao.getIdCarta();
		if(id == 0){
			painelJogoExecucao.criaBtnCarta0();
		}else{
			if(id == 1){
				painelJogoExecucao.criaBtnCarta1();
			}else{
				if(id == 2){
					painelJogoExecucao.criaBtnCarta2();
				}else{
					painelJogoExecucao.criaBtnCarta3();
				}
			}
		}
	}

}
