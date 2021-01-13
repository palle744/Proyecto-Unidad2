
package proyectounidad2;


public class punto2 {
private int x,y;

/*
 *Generar un punto en las coordenadas (0,0)
 * */
public punto2() {
	this.x=0;
	this.y=0;
}
/*
 * */
 public punto2(int x, int y) {
	 this.x=x;
	 this.y=y;
 }
 
 public void setX(int x) {
	 this.x=x;
 }
 
 public int getX() {
	 return this.x;
 }
 
 public void setY(int y) {
	 this.y=y;
 }
 
 public int getY() {
	 return this.y;
 }
 
}