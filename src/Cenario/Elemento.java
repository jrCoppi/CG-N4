package Cenario;

import java.util.ArrayList;
import java.util.List;

public enum Elemento {

	LIVRE(0), PAREDE(1), PLAYER(2), BURACO(3), OURO(4), WUMPUS(5), SETA(6);

	private Elemento(int valor) {
		this.valor = valor;

	}

	private  int valor;
	
	public int getValor() {
        return valor;
    }
	
	public void setValor(int i) {
        valor = i;
    }
	
	public static boolean estaEm(Elemento direcao, int valor){
		return (valor & direcao.getValor()) != 0;
	}
	
	public static List<Elemento> todasDe(int valor){		
		List<Elemento> direcoes = new ArrayList<Elemento>();
		
		for(Elemento d : Elemento.values()){			
			if(Elemento.estaEm(d, valor)){
				direcoes.add(d);
			}
		}
		
		return direcoes;
	}

}
