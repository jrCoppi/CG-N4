package Elementos;

import java.util.HashMap;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

public class ObjetoFactory {
    private HashMap<Integer,ObjetoGrafico> Elementos;

    public ObjetoFactory() {
        this.setElementos();
    }

    public HashMap<Integer, ObjetoGrafico> getListaElementos() {
        return Elementos;
    }

    private void setElementos() {
    	//0 - Livre | 1 - Parede | 2 - Player | 3 - Poço |  4  - Ouro| 5 - Wumpus 
        Elementos = new HashMap<Integer,ObjetoGrafico>();
        Livre liv = new Livre();
        liv.setHasImage(true);
        Elementos.put(0, new Livre());
        Elementos.put(1, new Parede());
        Elementos.put(2, new Player());
        Elementos.put(3, new Buraco());
        Elementos.put(4, new Ouro());
        Elementos.put(5, new Wumpus());
        //Elementos.put(6, new Seta());
    }
    
    public void desenha(Integer Key,GL gl,GLUT glut, float x, float y, float z){ 
        try {
        	Elementos.get(Key).eixoX = x;
        	Elementos.get(Key).eixoY = y;
        	Elementos.get(Key).eixoZ = z;
        	
        	if((Key == 4) || (Key == 2)){
        		this.desenhaBase(gl, glut, x, y, z);
        	}
        	
            Elementos.get(Key).desenha(gl,glut);
        } catch (Exception ex){
        	//
        }
    } 
    
    private void desenhaBase(GL gl,GLUT glut, float x, float y, float z){
    	Elementos.get(0).eixoX = x;
    	Elementos.get(0).eixoY = y;
    	Elementos.get(0).eixoZ = z;
    	Elementos.get(0).desenha(gl,glut);
    }
}
