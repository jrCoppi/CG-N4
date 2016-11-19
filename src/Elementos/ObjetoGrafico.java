package Elementos;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.TextureData;

public abstract class ObjetoGrafico {
	float eixoX;
	float eixoY;
	float eixoZ = 0;
	private boolean hasImage;
		
		public abstract void desenha(GL gl,GLUT glut);
		
		public abstract void loadImage(String nome);
		
		public void setHasImage(boolean possui)
		{
			hasImage = possui;
		}
		public boolean HasImage()
		{
			return hasImage;
		}
}
