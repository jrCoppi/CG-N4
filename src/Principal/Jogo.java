package Principal;

import Cenario.Cenario;
import Cenario.Elemento;

public class Jogo {
	private int numeroJogadas;
	private char sentidoMovimento;
	private int dificuldade; // 1,2,3 facil,medio,dificil
	private String statusAtual;
	private boolean ativo;
	private static Jogo instance;
	private int[] posicaoAtual = { 0, 0 };

	public Jogo() {
		numeroJogadas = 0;
		dificuldade = 1;
		statusAtual = "Iniciando Jogo";
		ativo = true;
		setSentidoMovimento('D'); // começar na direita
		Cenario.getInstance().exibirCenario();

	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

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
			ativo = false;
			statusAtual = "GAME OVER! Você caiu no poço!";
			break;
		case PAREDE:
			numeroJogadas--;
			return statusAtual = "movimento não permitido"; // não faz nada.
		case LIVRE:
			statusAtual = "deslocamento para " + getSentidoMovimento();
			break;
		case OURO:
			ativo = false;
			statusAtual = "VICTORY! Você chegou a barra de ouro!";
			break;
		case WUMPUS:
			ativo = false;
			statusAtual = "GAME OVER! Você foi pego pelo WUMPUS!";
			break;

		default:
			break;
		}
		return "";

	}

	private boolean podeMoverEsquerda() {
		int[] proxPosicao = { posicaoAtual[0], posicaoAtual[1] - 1 };
		return (posicaoAtual[1] != 0) && Cenario.getInstance().getElemento(proxPosicao) != Elemento.PAREDE;

	}

	private boolean podeMoverDireita() {
		int[] proxPosicao = { posicaoAtual[0], posicaoAtual[1] + 1 };
		return (posicaoAtual[1] != Cenario.CENARIO.length - 1)
				&& Cenario.getInstance().getElemento(proxPosicao) != Elemento.PAREDE;
	}

	private boolean podeMoverBaixo() {
		int[] proxPosicao = { posicaoAtual[0] + 1, posicaoAtual[1] };
		return (posicaoAtual[0] != Cenario.CENARIO[posicaoAtual[0]].length - 1)
				&& Cenario.getInstance().getElemento(proxPosicao) != Elemento.PAREDE;
	}

	private boolean podeMoverCima() {
		int[] proxPosicao = { posicaoAtual[0] - 1, posicaoAtual[1] };
		return (posicaoAtual[0] != 0) && Cenario.getInstance().getElemento(proxPosicao) != Elemento.PAREDE;
	}

	public void moverTras() {

		int[] posicaoAnterior= posicaoAtual.clone();
		
		if (getSentidoMovimento() == 'E') {
			if (podeMoverDireita())
				posicaoAtual[0]++;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		if (getSentidoMovimento() == 'D') {
			if (podeMoverEsquerda())
				posicaoAtual[0]--;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		if (getSentidoMovimento() == 'C') {
			if (podeMoverBaixo())
				posicaoAtual[1]++;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		if (getSentidoMovimento() == 'B') {
			if (podeMoverCima())
				posicaoAtual[1]--;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		Cenario.getInstance().atualizarPosicaoPlayer(posicaoAnterior,posicaoAtual);

	}

	public void moverFrente() {
		int[] posicaoAnterior= posicaoAtual.clone();
		
		if (getSentidoMovimento() == 'E') {
			if (podeMoverEsquerda())
				posicaoAtual[0]--;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		if (getSentidoMovimento() == 'D') {
			if (podeMoverDireita())
				posicaoAtual[0]++;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		if (getSentidoMovimento() == 'C') {
			if (podeMoverCima())
				posicaoAtual[1]--;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}
		if (getSentidoMovimento() == 'B') {
			if (podeMoverBaixo())
				posicaoAtual[1]++;
			else {
				statusAtual = "movimento não permitido";
				return;
			}
		}

		System.out.println(verificarStatusAtual());
		Cenario.getInstance().atualizarPosicaoPlayer(posicaoAnterior,posicaoAtual);
	}

	public void moverDireita() {
		switch (getSentidoMovimento()) {
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
		switch (getSentidoMovimento()) {
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
