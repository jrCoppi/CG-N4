package Outros;
/**
 * Classe de camera
 */
public class Camera {
	private double xEye, yEye, zEye; //camera
	private double xCenter, yCenter, zCenter; //luz
	private double linha,coluna;
	
	public Camera(String tipo){
		this.iniciaTipoPesoa();
		if(tipo == "CIMA"){
			this.iniciaTipoCima();
		}
	}
	
	private void iniciaTipoPesoa(){
		//P.Coluna = 1 * 2
		this.xEye = 2.0f; 
		this.yEye = 0.5f; //70% da altura da parede
		//P. Linha = 10 * 2
		this.zEye = 20.0f;
		
		//p.COLUNA(1) + direita(1) * lar
		this.xCenter = 4.0f;
		this.yCenter = 0.0f;
		//p.linha(10) * larg(2)
		this.zCenter = 20.0f;
		
		this.linha = 10.0f;
		this.coluna = 1.0f;
	}
	
	public void rotacionaCamera(char proximo){
		double colunaInt = this.coluna;
		double linhaInt = this.linha;
		
		//p.COLUNA(1) + direita(1) * lar
		//p.linha(10) * larg(2)
		switch(proximo){
			case 'D':
				colunaInt++;
				break;
			case 'B':
				linhaInt++;
				break;
			case 'C':
				linhaInt--;
				break;
			case 'E':
				colunaInt--;
				break;
		}
		this.xCenter = colunaInt * 2;
		this.zCenter = linhaInt * 2;
		//VER NOVO VALOR INICIAL
	}
	
	private void iniciaTipoCima(){
		this.xEye = 25.0f;
		this.yEye = 50.0f;
		this.zEye = 25.0f;
		this.xCenter = 0;
		this.yCenter = 0;
		this.zCenter = 0;
	}
	
	public static void rotate(float x, float y, float z){
        //glRotatef(x, 1, 0, 0);
       // glRotatef(y, 0, 1, 0);
        //glRotatef(z, 0, 0, 1);
    }
	
	public double getxEye() {
		return xEye;
	}
	public void setxEye(double xEye) {
		this.xEye = xEye;
	}
	public double getyEye() {
		return yEye;
	}
	public void setyEye(double yEye) {
		this.yEye = yEye;
	}
	public double getzEye() {
		return zEye;
	}
	public void setzEye(double zEye) {
		this.zEye = zEye;
	}
	public double getxCenter() {
		return xCenter;
	}
	public void setxCenter(double xCenter) {
		this.xCenter = xCenter;
	}
	public double getyCenter() {
		return yCenter;
	}
	public void setyCenter(double yCenter) {
		this.yCenter = yCenter;
	}
	public double getzCenter() {
		return zCenter;
	}
	public void setzCenter(double zCenter) {
		this.zCenter = zCenter;
	}

	public double getLinha() {
		return linha;
	}

	public void setLinha(double linha) {
		this.linha = linha;
	}

	public double getColuna() {
		return coluna;
	}

	public void setColuna(double coluna) {
		this.coluna = coluna;
	}
}
