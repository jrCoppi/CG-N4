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

import Padrao.Point4D;
import Principal.Mundo;

//import Padrao.BoundingBox;
//import Padrao.Point4D;

public class Main implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {
	private GL gl;
	private GLU glu;
	private GLAutoDrawable glDrawable;
	private int antigoX, antigoY = 0;
	private double posicaoX = 0, posicaoY = 0;
	
	/* Iniciar
	 * @see javax.media.opengl.GLEventListener#init(javax.media.opengl.GLAutoDrawable)
	 */
	public void init(GLAutoDrawable drawable) {
		glDrawable = drawable;
		gl = drawable.getGL();
		glu = new GLU();
		glDrawable.setGL(new DebugGL(gl));
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	}
	 
	
	/* Mostra
	 * @see javax.media.opengl.GLEventListener#display(javax.media.opengl.GLAutoDrawable)
	 */
	public void display(GLAutoDrawable arg0) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		

		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		glu.gluOrtho2D(0, 400, 400, 0);
		SRU();
		
		//Desenha a tela no mundo
		Mundo.getInstance().desenhaTela(gl);
		
		gl.glFlush();
	}	

	
	/* Ao apertar mouse
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		glDrawable.display();
	}
	
	//MATRIZ
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	    gl.glMatrixMode(GL.GL_PROJECTION);
	    gl.glLoadIdentity();
		gl.glViewport(0, 0, width, height);
		System.out.println(width);
		System.out.println(height);
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
	
	public void mouseEntered(MouseEvent e) {}
	  
	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}
	    
	public void mouseReleased(MouseEvent e) {}
	    
	
	/* Ao clicar no mouse
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {		
		glDrawable.display();
	}
	    
	public void mouseDragged(MouseEvent e) {}
	    
	
	/* 
	 * Quando o mouse é motivo atualiza o x do rastro
	 * sempre atualiza para zero, caso esta em edição usa a posição do mouse
	 * @param java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		glDrawable.display();
	}
	
	public void SRU() {
		// eixo x
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glLineWidth(1.0f);
		gl.glBegin( GL.GL_LINES );
			gl.glVertex2f( -200.0f, 0.0f );
			gl.glVertex2f(  200.0f, 0.0f );
			gl.glEnd();
		// eixo y
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin( GL.GL_LINES);
			gl.glVertex2f(  0.0f, -200.0f);
			gl.glVertex2f(  0.0f, 200.0f );
		gl.glEnd();
	}

}
