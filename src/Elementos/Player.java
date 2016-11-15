package Elementos;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

import Outros.Cor;

public class Player extends ObjetoGrafico {

	private float escalaCubo1[]     = { 2.0f, 2.0f, 2.0f };
	
	@Override
	public void desenha(GL gl, GLUT glut) {
		gl.glColor3f(Cor.AZUL[0],Cor.AZUL[1],Cor.AZUL[2]);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.AZUL, 0);

		gl.glPushMatrix();
			//tamanho do cubo
			gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
			//posição
			gl.glTranslated(this.eixoX, this.eixoY, this.eixoZ);
			//glut.glutSolidCube(1.0f);
		gl.glPopMatrix();
	}

}
