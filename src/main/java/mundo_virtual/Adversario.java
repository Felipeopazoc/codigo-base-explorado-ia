
package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;


public class Adversario extends TimerTask implements Constantes{
    public int xMov,yMov;
    public MundoVirtual mv;
    
    public Adversario(int x, int y, MundoVirtual mv){
        this.xMov = x;
        this.yMov = y;
        this.mv = mv;
    }
    public void moverArriba(){
        if(yMov > 0){
            if (mv.escenario.celdas[xMov][yMov-1].tipo!=OBSTACULO){//Comprueba para que no pase por encima del obstaculo
                yMov--;
            }
        }
           
    }
    public void moverAbajo(){
        if(yMov < NUMERO_CELDAS_LARGO-1){
             if(mv.escenario.celdas[xMov][yMov+1].tipo!=OBSTACULO){
                 yMov++;
             }
        }
    }
    
    public void moverIzquierda(){
        if(xMov!=0){
             if(mv.escenario.celdas[xMov-1][yMov].tipo!=OBSTACULO){
                   xMov--;
             }
        }
    }
    public void moverDerecha(){
        if (xMov < NUMERO_CELDAS_ANCHO-1){
            if(mv.escenario.celdas[xMov+1][yMov].tipo!=OBSTACULO){
                  xMov++;
            }
        }
    }
      public void paintCelda(Graphics g) {  
        
        g.drawRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.red);//cambiamos color
        g.fillRect(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        
    }
     @Override
     public void run(){
        if( !fin()){
            mv.repaint(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
            realizar_Movimiento_Aleatorio();
           mv.repaint(xMov*PIXELS+DESPLAZAMIENTO,yMov*PIXELS+DESPLAZAMIENTO,PIXELS,PIXELS);
           
        }else{
            lanzar_mensaje("Adversario atrapó entidad");
            this.cancel();
            mv.entidad.cancel();
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
     public boolean fin(){
         return xMov == mv.entidad.xMov && yMov == mv.entidad.yMov;
     }
    
}
