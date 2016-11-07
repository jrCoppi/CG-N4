package Principal;


import javax.media.opengl.GL;

import Elementos.ObjetoFactory;
import Cenario.Cenario;

/**
 * @author
 * Classe principal da aplicação, contêm o mundo
 */
public class Mundo {
	private static Mundo instance;
	private Camera camera;
	private Cenario tela;
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
		
	}
	
	public void desenhaTela(GL gl) {
		//Percorre o array e manda desenhar passando o valor da celula OU
		//this.getObjetoFactory().desenha(Key, gl);
		//Desenha apenas os vizinhos visiveis para não sobrecarregar
	}
	
	public void realizarMovimento( char sentido)
	{
		switch (sentido) 
		{
		case 'C':
			Jogo.getInstance().moverFrente();
			break;
		case 'B':
			Jogo.getInstance().moverTras();
			break;
		case 'D':
			Jogo.getInstance().moverDireita();
			break;
		case 'E':
			Jogo.getInstance().moverEsquerda();
			break;
		default:
			return;
		}
		
		
	}
	
	
	
	
}
