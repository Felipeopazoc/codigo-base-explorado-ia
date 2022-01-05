
package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;


public class Celda implements Constantes{
    public int xPixel;
    public int yPixel;
    public char tipo;
    
    public Celda(int x, int y,char tipo){
        this.xPixel = x;
        this.yPixel = y;
        this.tipo = tipo; //Tipo de obstaculo
    }
    public void paintCelda(Graphics g){
        switch(tipo){
            case CAMINO:{
                 g.drawRect(xPixel,yPixel,PIXELS,PIXELS);
                 break;
            }
            case OBSTACULO:{
                g.fillRect(xPixel, yPixel, PIXELS, PIXELS);
                break;
            }
            case AMOR:{
                g.setColor(Color.pink);
                g.fillRect(xPixel, yPixel, PIXELS, PIXELS);
                g.setColor(Color.black);
                g.drawRect(xPixel, yPixel, PIXELS,PIXELS);
            }
        }
    }
}
