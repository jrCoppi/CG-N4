package Principal;

import javax.media.opengl.GL;

import Elementos.ObjetoFactory;

/**
 * @author
 * Classe principal da aplicação, contêm o mundo
 */
public class Mundo {
	private static Mundo instance;
	private Camera camera;
	private int[][] tela;
	private ObjetoFactory objetoFactory;
	
	public ObjetoFactory getObjetoFactory() {
		return objetoFactory;
	}

	public void setObjetoFactory(ObjetoFactory objetoFactory) {
		this.objetoFactory = objetoFactory;
	}

	public static Mundo getInstance() {
		if (instance == null) {
			instance = new Mundo();
		}
		return instance;
	}

	private Mundo() {
		this.camera = new Camera();
		this.objetoFactory = new ObjetoFactory();
		//0 - Livre | 1 - Parede | 2 - Player | 3 - Poço |  4  - Ouro| 5 - Wumpus 
		// 5 Poços, 1 Ouro e  1 Wumpus, varios caminho
		int[][] telaInt = 
					{{0, 0, 0,  1,  0,  1,  0,  0,  3,  0},
					{0,  1, 0,  0,  0,  0,  0,  1,  0,  0},
					{0,  1, 1,  1,  0,  1,  0,  1,  1,  1},
					{0,  0, 0,  4,  3,  1,  0,  1,  0,  0},
					{0,  1, 3,  1,  0,  1,  5,  0,  0,  1},
					{0,  1, 0,  1,  1,  1,  1,  1,  0,  1},
					{0,  0, 0,  0,  0,  0,  0,  1,  0,  1},
					{0,  1, 3,  1,  0,  1,  1,  1,  0,  1},
					{1,  1, 0,  1,  0,  0,  0,  0,  0,  1},
					{2,  0, 0,  0,  0,  1,  1,  1,  0,  3}};;
		this.tela = telaInt;
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
}
