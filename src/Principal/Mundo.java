package Principal;

import javax.media.opengl.GL;

/**
 * @author
 * Classe principal da aplica��o, cont�m o mundo
 */
public class Mundo {
	private static Mundo instance;
	private Camera camera;
	private int[][] tela;
	
	public static Mundo getInstance() {
		if (instance == null) {
			instance = new Mundo();
		}
		return instance;
	}

	private Mundo() {
		this.camera = new Camera();
		//ver como dividir a tela correatamente
		//definri o mapa e desenhar as paredes
		//Mudar a camera
		//numerar caminhos
		//N�o mostrar humanoide (jogo em primeira pessoa?)
		//0 - Livre | 1 - Parede | 2 - Po�o |  3  - Wumpus | 4 - Ouro
		
	}
	
	/**
	 * Desenha os elementos em tela
	 * @param gl
	 */
	public void desenhaTela(GL gl) {

	}
}
