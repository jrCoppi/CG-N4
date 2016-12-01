package Elementos;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

import Outros.Cor;

public class Buraco extends ObjetoGrafico  {

	private float escalaCubo1[]     = { 2.0f, 2.0f, 2.0f };
	
	@Override
	public void desenha(GL gl, GLUT glut) {
		/*gl.glColor3f(Cor.VERDE[0],Cor.VERDE[1],Cor.VERDE[2]);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.VERDE, 0);

		gl.glPushMatrix();
			//tamanho do cubo
			gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
			//posição
			gl.glTranslated(this.eixoX, this.eixoY, this.eixoZ);
			glut.glutSolidCube(1.0f);
			//glut.glutSolidSphere(2,2,5);
		gl.glPopMatrix();*/
		
		gl.glColor3f(0.647059f,0.164706f,0.164706f);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.MARROM, 0);

			gl.glPushMatrix();
				//tamanho do cubo
				gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
				//posição
				gl.glTranslated(eixoX, this.eixoY-0.35f, eixoZ);
				glut.glutSolidSphere(0.5, 32, 32);
				
			gl.glPopMatrix();
		
	}

	@Override
	public void loadImage(String nome) {
		// TODO Auto-generated method stub
		
	}

}
