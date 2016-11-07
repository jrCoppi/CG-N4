package Principal;

import Cenario.Cenario;

public class Jogo {
	private int numeroJogadas;
	private char sentidoMovimento;
	private int dificuldade; // 1,2,3 facil,medio,dificil
	private String statusAtual;
	private boolean ativo;
	private static Jogo instance;
	private int[] posicaoAtual = { 0, 0 };

	public void setNumeroJogadas(int numeroJogadas) {
		this.numeroJogadas = numeroJogadas;
	}

	public char getSentidoMovimento() {
		return sentidoMovimento;
	}

	public void setSentidoMovimento(char sentidoMovimento) {
		this.sentidoMovimento = sentidoMovimento;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public String getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(String statusAtual) {
		this.statusAtual = statusAtual;
	}

	public int getNumeroJogadas() {
		return numeroJogadas;
	}

	public static Jogo getInstance() {
		if (instance == null)
			instance = new Jogo();

		return instance;

	}

	public String verificarStatusAtual() {

		numeroJogadas++;
		switch (Cenario.getInstance().getElemento(posicaoAtual)) {
		case BURACO:
			ativo=false;
			statusAtual="GAME OVER! Você caiu no poço!";
			break;
		case PAREDE:
			numeroJogadas--;
			return statusAtual= "movimento não permitido"; // não faz nada.			
		case LIVRE:		
				statusAtual="deslocamento para " + getSentidoMovimento();				
			break;
		case OURO:
			ativo=false;
			statusAtual="VICTORY! Você chegou a barra de ouro!";
			break;
		case WUMPUS:
			ativo=false;
			statusAtual="GAME OVER! Você foi pego pelo WUMPUS!";
			break;

		default:
			break;
		}
		return "";

	}

	private boolean podeMoverEsquerda() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean podeMoverDireita() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean podeMoverBaixo() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean podeMoverCima() {
		// TODO Auto-generated method stub
		return false;
	}

	public void moverTras() {
		
		if(getSentidoMovimento()=='E')
		{ 
			if(podeMoverDireita())
			posicaoAtual[0]++;		
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}
		if(getSentidoMovimento()=='D')
		{ 
			if(podeMoverEsquerda())
			posicaoAtual[0]--;
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}
		if(getSentidoMovimento()=='C')
		{ 
			if(podeMoverBaixo())
			posicaoAtual[1]++;			
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}		
		if(getSentidoMovimento()=='B')
		{ 
			if(podeMoverCima())
			posicaoAtual[1]--;	
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}
		Cenario.getInstance().moverTras();

	}


	public Jogo() {
		numeroJogadas = 0;
		dificuldade = 1;
		statusAtual = "Iniciando Jogo";
		ativo=true;
		Cenario.getInstance().exibirCenario();

	}

	public void moverFrente() {
		if(getSentidoMovimento()=='E')
		{ 
			if(podeMoverEsquerda())
			posicaoAtual[0]--;		
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}
		if(getSentidoMovimento()=='D')
		{ 
			if(podeMoverDireita())
			posicaoAtual[0]++;
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}
		if(getSentidoMovimento()=='C')
		{ 
			if(podeMoverCima())
			posicaoAtual[1]--;			
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}		
		if(getSentidoMovimento()=='B')
		{ 
			if(podeMoverBaixo())
			posicaoAtual[1]++;	
			else
			{
				statusAtual= "movimento não permitido";
				return;
			}
		}
		
		System.out.println(verificarStatusAtual());
		Cenario.getInstance().moverFrente();
	}

	

	
	public void moverDireita() {
		switch (getSentidoMovimento())
		{
		case 'D':
			setSentidoMovimento('B');
			break;
		case 'B':
			setSentidoMovimento('E');
			break;
		case 'C':
			setSentidoMovimento('D');
			break;
		case 'E':
			setSentidoMovimento('C');
			break;
		}		
		Cenario.getInstance().rotacionarDireita();

	}

	public void moverEsquerda() {
		switch (getSentidoMovimento())
		{
		case 'D':
			setSentidoMovimento('C');
			break;
		case 'B':
			setSentidoMovimento('D');
			break;
		case 'C':
			setSentidoMovimento('E');
			break;
		case 'E':
			setSentidoMovimento('B');
			break;
		}		
		Cenario.getInstance().rotacionarEsquerda();

	}

}
