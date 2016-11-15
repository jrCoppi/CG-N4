package Elementos;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

import Outros.Cor;

public class Livre extends ObjetoGrafico  {

	private float escalaCubo1[]     = { 2.0f, 0.0f, 2.0f };
	
	@Override
	public void desenha(GL gl, GLUT glut) {
		gl.glColor3f(Cor.CINZA[0],Cor.CINZA[1],Cor.CINZA[2]);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.CINZA, 0);

		gl.glPushMatrix();
			//desenhar cubo no ch�o
			gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
			//posi��o
			gl.glTranslated(this.eixoX, this.eixoY, this.eixoZ);
			glut.glutSolidCube(1.0f);
			//glut.glutSolidSphere(2,2,5);
		gl.glPopMatrix();
	}

}
