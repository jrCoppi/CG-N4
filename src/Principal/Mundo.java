package Principal;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

import Elementos.ObjetoFactory;
import Cenario.Cenario;

/**
 * @author Classe principal da aplicação, contêm o mundo
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

	public void desenhaTela(GL gl,GLUT glut) {
		float translacaoX = 0;
		float translacaoY = 0;
		// Percorre o array e manda desenhar passando o valor da celula
		// Desenha apenas os vizinhos visiveis para não sobrecarregar
		for (int i = 0; i < this.tela.getInstance().CENARIO.length; i++,translacaoY++) {
			for (int j = 0; j < this.tela.getInstance().CENARIO[i].length; j++,translacaoX++) {
				
				this.getObjetoFactory().desenha(
						this.tela.getInstance().CENARIO[i][j], 
						gl, 
						glut,
						translacaoX,
						translacaoY
				);
			}
			translacaoX= 0;
		}
		
		
	}

	public void realizarMovimento(char sentido) {
		if (Jogo.getInstance().getInstance().isAtivo()) 
		{
			switch (sentido) {
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

}
