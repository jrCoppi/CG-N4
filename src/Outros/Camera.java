package Outros;
/**
 * Classe de camera
 */
public class Camera {
	private double xEye, yEye, zEye; //camera
	private double xCenter, yCenter, zCenter; //luz
	
	public Camera(String tipo){
		this.iniciaTipoPesoa();
		if(tipo == "CIMA"){
			this.iniciaTipoCima();
		}
	}
	
	private void iniciaTipoPesoa(){
		this.xEye = 20.0f; //20
		this.yEye = 0.0f;
		this.zEye = 0.0f;
		this.xCenter = 0.0f;
		this.yCenter = 0.0f;
		this.zCenter = 0.0f;
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
}
