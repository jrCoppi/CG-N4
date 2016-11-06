package Elementos;

import java.util.HashMap;

import javax.media.opengl.GL;

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
        Elementos.put(1, new Parede());
        Elementos.put(2, new Player());
        Elementos.put(3, new Buraco());
        Elementos.put(4, new Ouro());
        Elementos.put(5, new Wumpus());
    }
    
    public void desenha(Integer Key,GL gl){ 
        try {
            Elementos.get(Key).desenha(gl);;
        } catch (Exception ex){
        	//
        }
    } 
}
