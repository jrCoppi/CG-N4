package Elementos;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

import Outros.Cor;

public class Ouro extends ObjetoGrafico {

	private float escalaCubo1[]     = { 2.0f, 2.0f, 2.0f };
	
	@Override
	public void desenha(GL gl, GLUT glut) {
		this.desenhaMoeda(gl, glut, this.eixoX, this.eixoZ);
		this.desenhaMoeda(gl, glut, this.eixoX-0.3f, this.eixoZ);
		this.desenhaMoeda(gl, glut, this.eixoX+0.3f, this.eixoZ);
		this.desenhaMoeda(gl, glut, this.eixoX, this.eixoZ-0.3f);
		this.desenhaMoeda(gl, glut, this.eixoX, this.eixoZ+0.3f);
		this.desenhaMoeda(gl, glut, this.eixoX+0.2f, this.eixoZ + 0.2f);
		this.desenhaMoeda(gl, glut, this.eixoX-0.2f, this.eixoZ - 0.2f);
		this.desenhaMoeda(gl, glut, this.eixoX-0.2f, this.eixoZ - 0.2f);
		this.desenhaMoeda(gl, glut, this.eixoX-0.3f, this.eixoZ + 0.3f);
		
	}
	
	private void desenhaMoeda(GL gl, GLUT glut, float x, float z){
		gl.glColor3f(Cor.AMARELO[0],Cor.AMARELO[1],Cor.AMARELO[2]);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, Cor.AMARELO, 0);

		gl.glPushMatrix();
			//tamanho do cubo
			gl.glScalef(escalaCubo1[0],escalaCubo1[1],escalaCubo1[2]);
			//posi��o
			gl.glTranslated(x, this.eixoY, z);
			glut.glutSolidSphere(0.08, 16, 16);
			//gl.glTranslatef(this.eixoX-1, this.eixoY+1, this.eixoZ);
			
			//glut.glutSolidSphere(0.08, 16, 16);
		gl.glPopMatrix();
	}

	@Override
	public void loadImage(String nome) {
		// TODO Auto-generated method stub
		
	}

}
