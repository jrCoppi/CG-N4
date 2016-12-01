package Executavel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import com.sun.opengl.util.GLUT;

import Outros.Camera;
import Outros.Cor;
import Padrao.Point4D;
import Principal.Jogo;
import Principal.Mundo;

//import Padrao.BoundingBox;
//import Padrao.Point4D;

public class Main implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {
	private GL gl;
	private GLU glu;
	private GLUT glut;
	private GLAutoDrawable glDrawable;
	private boolean luz;
	
	/*
	 * Iniciar
	 * 
	 * @see javax.media.opengl.GLEventListener#init(javax.media.opengl.
	 * GLAutoDrawable)
	 */
	public void init(GLAutoDrawable drawable) {
		glDrawable = drawable;
		gl = drawable.getGL();
		glu = new GLU();
		glut = new GLUT();
		glDrawable.setGL(new DebugGL(gl));
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glEnable(GL.GL_DEPTH_TEST);    
		
		gl.glEnable(GL.GL_COLOR_MATERIAL);
		gl.glColorMaterial(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT_AND_DIFFUSE);	
		
		this.iniciaLuz();
		
		// Habilita o modelo de colorizacao de Gouraud
		gl.glShadeModel(GL.GL_SMOOTH);
				
		gl.glTexParameteri(GL.GL_TEXTURE_2D,GL.GL_TEXTURE_MIN_FILTER,GL.GL_LINEAR);	
		gl.glTexParameteri(GL.GL_TEXTURE_2D,GL.GL_TEXTURE_MAG_FILTER,GL.GL_LINEAR);
		
	    gl.glEnable(GL.GL_CULL_FACE);
//	    gl.glDisable(GL.GL_CULL_FACE);
		
	    gl.glEnable(GL.GL_DEPTH_TEST);
	}
	
	private void iniciaLuz(){
		float posLight[] = { 5.0f, 5.0f, 10.0f, 0.0f };
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posLight, 0);
		gl.glEnable(GL.GL_LIGHT0);
		
		
	}
	

	/*
	 * Mostra
	 * 
	 * @see javax.media.opengl.GLEventListener#display(javax.media.opengl.
	 * GLAutoDrawable)
	 */
	public void display(GLAutoDrawable arg0) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		if (luz)
			gl.glEnable(GL.GL_LIGHT0);
		else
			gl.glDisable(GL.GL_LIGHT0);

		Mundo.getInstance().atualizaCamera();
		
		if(Jogo.getInstance().isAtivo() == false){
			Mundo.getInstance().setCameraEmUso("CIMA");
		}
		
		glu.gluLookAt(
				this.getCamera().getxEye(), //P.linha x largura 
				this.getCamera().getyEye(), //altura
				this.getCamera().getzEye(), //P.altura x largura 
				this.getCamera().getxCenter(), //Cx = P.coluna x largura
				this.getCamera().getyCenter(), //altura 
				this.getCamera().getzCenter(), //Cz(P.linha 1) * largura
				0.0f, 1.0f, 0.0f
		);

		//drawAxis();
		
		// Desenha a tela no mundo
		gl.glEnable(GL.GL_LIGHTING);
		
		Mundo.getInstance().desenhaTela(gl,glut);
		
		gl.glDisable(GL.GL_LIGHTING);
		
		//camera pra 2d
		//projection
		//
		
		gl.glFlush();
	}
	
	public Camera getCamera(){
		return Mundo.getInstance().getCamera();
	}
	
	public void drawAxis() {
		// eixo X - Red
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
			gl.glVertex3f(0.0f, 0.0f, 0.0f);
			gl.glVertex3f(50.0f, 0.0f, 0.0f);
		gl.glEnd();
		// eixo Y - Green
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
			gl.glVertex3f(0.0f, 0.0f, 0.0f);
			gl.glVertex3f(0.0f, 50.0f, 0.0f);
		gl.glEnd();
		// eixo Z - Blue
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		gl.glBegin(GL.GL_LINES);
			gl.glVertex3f(0.0f, 0.0f, 0.0f);
			gl.glVertex3f(0.0f, 0.0f, 50.0f);
		gl.glEnd();
	}

	/*
	 * Ao apertar mouse
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		char direcao = 'S';
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			direcao='C';
			break;
		case KeyEvent.VK_DOWN:
			direcao='B';
			break;		
		case KeyEvent.VK_LEFT:
			direcao='E';
			break;
		case KeyEvent.VK_RIGHT:
			direcao='D';
			break;		
		case KeyEvent.VK_1:
			Mundo.getInstance().setCameraEmUso("CIMA");			
			break;
		case KeyEvent.VK_2:
			Mundo.getInstance().setCameraEmUso("PESSOA");
			break;
		case KeyEvent.VK_3:
			luz= !luz;
			break;
		}
		Mundo.getInstance().realizarMovimento(direcao);
		glDrawable.display();		
		
	}

	// MATRIZ
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	    gl.glMatrixMode(GL.GL_PROJECTION);
	    gl.glLoadIdentity();
		gl.glViewport(0, 0, width, height);
	    glu.gluPerspective(60, width/height, 0.1, 100);		
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	/*
	 * Ao clicar no mouse
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		glDrawable.display();
	}

	public void mouseDragged(MouseEvent e) {
	}

	/*
	 * Quando o mouse é motivo atualiza o x do rastro sempre atualiza para zero,
	 * caso esta em edição usa a posição do mouse
	 * 
	 * @param
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {}

	public void SRU() {
		// eixo x
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glLineWidth(1.0f);
		gl.glBegin(GL.GL_LINES);
		gl.glVertex2f(-200.0f, 0.0f);
		gl.glVertex2f(200.0f, 0.0f);
		gl.glEnd();
		// eixo y
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
		gl.glVertex2f(0.0f, -200.0f);
		gl.glVertex2f(0.0f, 200.0f);
		gl.glEnd();
	}

}
