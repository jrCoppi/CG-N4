package Elementos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.swing.JOptionPane;

import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.TextureData;

import Outros.Cor;

public class Parede extends ObjetoGrafico {
	private float escalaCubo1[]     = { 2.0f, 2.0f, 2.0f };
	private  int imageWidth, ImageHeight;
	private static BufferedImage image;
	private static TextureData td;	
	private int[] idTexture; // lista de identificadores de textura
	@Override
	public void desenha(GL gl, GLUT glut) {
		

		idTexture = new int[3];
		gl.glGenTextures(1, idTexture, 2);
		
		loadImage("C://temp//Imagens//Muro.jpg");
		
		
		//gl.glColor3f(Cor.CINZA[0],Cor.CINZA[1],Cor.CINZA[2]);
		
		gl.glPushMatrix();
		//gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.CINZA, 0);
			//desenhar cubo no chão
			//gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
			//posição
			gl.glTranslated(this.eixoX, this.eixoY, this.eixoZ);
			gl.glEnable(GL.GL_TEXTURE_2D);	// Primeiro habilita uso de textura
			
			gl.glBindTexture(GL.GL_TEXTURE_2D, idTexture[0]); 		// Especifica qual e a textura corrente pelo identificador 
			gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, 3, imageWidth, ImageHeight, 0, GL.GL_BGR,GL.GL_UNSIGNED_BYTE, (ByteBuffer)td.getBuffer()); 		// Envio da textura para OpenGL
			
			this.desenhaCubo(gl,this.escalaCubo1);
			
			gl.glDisable(GL.GL_TEXTURE_2D);
		gl.glPopMatrix();
		
	/*	gl.glColor3f(Cor.VERMELHO[0],Cor.VERMELHO[1],Cor.VERMELHO[2]);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.VERMELHO, 0);

		gl.glPushMatrix();
			//tamanho do cubo
			gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
			//posição
			gl.glTranslated(this.eixoX, this.eixoY, this.eixoZ);
			glut.glutSolidCube(1.0f);
		gl.glPopMatrix();*/
	}

	@Override
	public void loadImage(String nomeArquivo) {
		if(image != null)
			return;
		
		try {
			image = ImageIO.read(new File(nomeArquivo));
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Erro na leitura do arquivo "+nomeArquivo);
		}

		// Obtem largura e altura
		imageWidth  = image.getWidth();
		ImageHeight = image.getHeight();
		// Gera uma nova TextureData...
		td = new TextureData(0,0,false,image);
		
	}
}
