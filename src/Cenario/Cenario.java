package Cenario;

import java.security.spec.ECField;
import java.util.HashMap;

import javax.media.opengl.GL;

import Elementos.ObjetoGrafico;
import Elementos.Ouro;

public class Cenario {
	// 0 - Livre | 1 - Parede | 2 - Player | 3 - Poço | 4 - Ouro| 5 - Wumpus
	// 5 Poços, 1 Ouro e 1 Wumpus, varios caminho
	private final int livre; 
	private final int parede; 
	private final int player; 
	private final int buraco;
	private final int ouro;
	private final int wumpus;
	private final int seta;
	private static Cenario instance;
	public static int[][] CENARIO;
	private HashMap<String, ObjetoGrafico> objetosCarregados;
	

	private Cenario() {
		livre = Elemento.LIVRE.getValor();
		parede = Elemento.PAREDE.getValor();
		player = Elemento.PLAYER.getValor();
		buraco = Elemento.BURACO.getValor();
		ouro = Elemento.OURO.getValor();
		wumpus = Elemento.WUMPUS.getValor();
		seta = Elemento.SETA.getValor();
		objetosCarregados = new HashMap<String,ObjetoGrafico>();
		mapearCenario();

	}
	
	public static Cenario getInstance()
		{
			
			if(instance == null)
				instance = new Cenario();
			return instance;
		}

	private void mapearCenario() {

		CENARIO = new int[][] 
				//  ----------------------------- > x - VERMELHO
			{ 	{ parede, parede, parede, parede, parede, parede, parede, parede, parede, parede, parede, parede }, // -
				{ parede, livre, livre, livre, parede, livre, parede, livre, livre, buraco, parede, parede },       // -
				{ parede, livre, parede, livre, livre, livre, livre, livre, parede, livre, buraco, parede },        // -
				{ parede, livre, parede, parede, parede, livre, parede, livre, livre, livre, parede, parede },      // -
				{ parede, livre, livre, livre/*teste*/, ouro, livre, parede, livre, parede, livre, livre, parede },          // Z
				{ parede, livre, parede, buraco, parede, buraco, parede, wumpus, livre, livre, parede, parede },	// -
				{ parede, livre, parede, livre, parede, parede, parede, parede, parede, livre, parede, parede },    // AZUL
				{ parede, livre, livre, livre, livre, livre, livre, livre, parede, livre, parede, parede },
				{ parede, livre, parede, buraco, parede, livre, parede, parede, parede, livre, parede, parede },
				{ parede, parede, parede, livre, parede, livre, livre, livre, livre, livre, parede, parede }, 
				{ parede, player, livre, livre, livre, livre, parede, parede, parede, livre, buraco, parede },
				{ parede, parede, parede, parede, parede, parede, parede, parede, parede, parede, parede } 
			};
	}

	public void exibirCenario() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Desenha os elementos em tela
	 * @param gl
	 */
	public void desenhaTela(GL gl) {
		//Percorre o array e manda desenhar passando o valor da celula OU
		//this.getObjetoFactory().desenha(Key, gl);
		//Desenha apenas os vizinhos visiveis para não sobrecarregar
	}

	public Elemento getElemento(int[] posicaoAtual) {
		// TODO Auto-generated method stub
		if(posicaoAtual.length==2){
			int valor =  CENARIO[posicaoAtual[0]][posicaoAtual[1]];
			Elemento el = Elemento.values()[valor];			
			return el;
		}
		return null; 
	}

	public void atualizarPosicaoPlayer(int[] posicaoAnterior, int[] posicaoAtual){
		if(posicaoAtual.length==2){
			CENARIO[posicaoAtual[0]][posicaoAtual[1]]= player;
			CENARIO[posicaoAnterior[0]][posicaoAnterior[1]] = livre;		
		}
	}

}
