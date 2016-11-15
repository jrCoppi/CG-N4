package Principal;

import java.util.HashMap;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

import Elementos.ObjetoFactory;
import Outros.Camera;
import Cenario.Cenario;

/**
 * @author Classe principal da aplicação, contêm o mundo
 */
public class Mundo {
	private static Mundo instance;
	private String cameraEmUso;
	private Cenario tela;
	private ObjetoFactory objetoFactory;
	private HashMap<String, Camera> arrCameras;

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
		this.arrCameras = new HashMap<>();
		this.arrCameras.put("PESSOA", new Camera("PESSOA"));
		this.arrCameras.put("CIMA", new Camera("CIMA"));
		
		this.cameraEmUso = "PESSOA";
		this.objetoFactory = new ObjetoFactory();
	}

	public void desenhaTela(GL gl,GLUT glut) {
		float translacaoZ = 0;
		float translacaoX = 0;
		// Percorre o array e manda desenhar passando o valor da celula
		// Desenha apenas os vizinhos visiveis para não sobrecarregar
		for (int i = 0; i < this.tela.getInstance().CENARIO.length; i++,translacaoX++) {
			for (int j = 0; j < this.tela.getInstance().CENARIO[i].length; j++,translacaoZ++) {
				
				this.getObjetoFactory().desenha(
						this.tela.getInstance().CENARIO[i][j], 
						gl, 
						glut,
						translacaoX,
						0,
						translacaoZ
				);
			}
			translacaoZ= 0;
		}
	}

	public void realizarMovimento(char sentido) {
		if (Jogo.getInstance().isAtivo()) {
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
	
	/**
	 * Retorna a camera em uso
	 * @return
	 */
	public Camera getCamera(){
		return this.arrCameras.get(this.cameraEmUso);
	}
	
	public void setCameraEmUso(String cameraEmUso) {
		this.cameraEmUso = cameraEmUso;
	}

}
