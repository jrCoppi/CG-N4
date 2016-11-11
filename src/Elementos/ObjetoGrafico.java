package Elementos;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

public abstract class ObjetoGrafico {
	float eixoX;
	float eixoY;
	float eixoZ = 0;
	
	public abstract void desenha(GL gl,GLUT glut);
}
