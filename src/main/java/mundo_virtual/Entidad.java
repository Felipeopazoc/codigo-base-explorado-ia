
package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;

public class Entidad extends TimerTask implements Constantes{
    public int xMov, yMov;
    public MundoVirtual mv;
    
    public Entidad(int x, int y, MundoVirtual mv){
        this.xMov = x;
        this.yMov = y;
        this.mv = mv;
    }
     public void moverArriba() { 
        if ( yMov > 0 ) {
          if (  mv.escenario.celdas[xMov][yMov-1].tipo!=OBSTACULO  ) {
            yMov-=1; 
          }
        }
    }
    
    public void moverAbajo() {  
        if ( yMov < NUMERO_CELDAS_LARGO-1 ) {
          if ( mv.escenario.celdas[xMov][yMov+1].tipo!=OBSTACULO) {
            yMov+=1; 
          }
        }
    
    }
    
    public void moverIzquierda() { 
        if ( xMov!=0) {
           if ( mv.escenario.celdas[xMov-1][yMov].tipo!=OBSTACULO) {
             xMov-=1;
           }
        }
    }
    
    public void moverDerecha() {
        if ( xMov < NUMERO_CELDAS_ANCHO-1  ) {
           if ( mv.escenario.celdas[xMov+1][yMov].tipo!=OBSTACULO)
             xMov+=1; 
        }
    }
    
    //algoritmo de pintado de una entidad
    
    public void paintCelda(Graphics g) {  
        
        g.drawRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.green);//cambiamos color
        g.fillRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        
    }
    @Override
    public void run(){
           if ( !fin()) {
           mv.repaint(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
           realizar_Movimiento_Aleatorio();
           mv.repaint(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
           
        }else {
           System.out.println(" [ Entidad : "
                   + "LLegaste al final ");
           this.cancel();  //finalizo tarea
        }
    }
      private void realizar_Movimiento_Aleatorio() {
        int movAleatorio=numeroAleatorio(0,3);
        
        switch(movAleatorio) {
           case 0: moverArriba(); break;
           case 1: moverAbajo(); break;
           case 2: moverIzquierda(); break;
           case 3: moverDerecha();break;
        }
        
    }
     public boolean fin() {
        return mv.escenario.darCelda(xMov,yMov).tipo==AMOR;
    }
}
