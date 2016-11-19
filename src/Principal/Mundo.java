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
		int elemento = 0;
		
		// Percorre o array e manda desenhar passando o valor da celula
		// Desenha apenas os vizinhos visiveis para não sobrecarregar
		//Linha (Z)
		for (int i = 0; i < this.tela.getInstance().CENARIO.length; i++,translacaoZ++) {
			//Coluna (X)
			for (int j = 0; j < this.tela.getInstance().CENARIO[i].length; j++,translacaoX++) {
				elemento = this.tela.getInstance().CENARIO[i][j];
				
				//Player, seta a camera em primeira pessoa para essa posição
				if(elemento == 2){
					this.arrCameras.get("PESSOA").setColuna(j);
					this.arrCameras.get("PESSOA").setLinha(i);
					//P.Coluna * largura
					this.arrCameras.get("PESSOA").setxEye(j * 2);
					//P.Linha * largura
					this.arrCameras.get("PESSOA").setzEye(i * 2);
				}
				
				this.getObjetoFactory().desenha(
						elemento, 
						gl, 
						glut,
						translacaoX,
						0,
						translacaoZ
				);
			}
			translacaoX = 0;
		}
	}

   public void atualizaCamera(){
      int elemento = 0;
      for (int i = 0; i < this.tela.getInstance().CENARIO.length; i++) {
         //Coluna (X)
         for (int j = 0; j < this.tela.getInstance().CENARIO[i].length; j++) {
            elemento = this.tela.getInstance().CENARIO[i][j];
            
            //Player, seta a camera em primeira pessoa para essa posição
            if(elemento == 2){
               this.arrCameras.get("PESSOA").setColuna(j);
               this.arrCameras.get("PESSOA").setLinha(i);
               //P.Coluna * largura
               this.arrCameras.get("PESSOA").setxEye(j * 2);
               //P.Linha * largura
               this.arrCameras.get("PESSOA").setzEye(i * 2);
               break;
            }
         }
      }
      
      this.arrCameras.get("PESSOA").rotacionaCamera();
   }
   
	public void realizarMovimento(char sentido) {
		char proximo = 0;
		if (Jogo.getInstance().isAtivo()) {
			switch (sentido) {
			case 'C':
				//Só anda
				//Jogo.getInstance().setSentidoMovimento(sentido);
				Jogo.getInstance().moverFrente();
				break;
			case 'B':
				//Só anda
				//Jogo.getInstance().setSentidoMovimento(sentido);
				Jogo.getInstance().moverTras();
				break;
			case 'D':
				proximo = Jogo.getInstance().moverDireita();
				break;
			case 'E':
				proximo = Jogo.getInstance().moverEsquerda();
				break;
			default:
				return;
			}
		}
		
		
		System.out.println(Jogo.getInstance().getStatusAtual());
		if(proximo > 0){
			this.arrCameras.get("PESSOA").setDirecao(proximo);
         this.arrCameras.get("PESSOA").rotacionaCamera();
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
