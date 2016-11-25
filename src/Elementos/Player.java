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

public class Player extends ObjetoGrafico {

	private float escalaCubo1[]     = { 2.0f, 0.0f, 2.0f };
	private  int imageWidth, ImageHeight;
	private static BufferedImage image;
	private static TextureData td;	
	private int[] idTexture; // lista de identificadores de textura
	
	@Override
	public void desenha(GL gl, GLUT glut) {

	}

	@Override
	public void loadImage(String nomeArquivo) {

	}

}
