
package mundo_virtual;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class MundoVirtual extends Canvas implements Constantes{
    //pintar mundo
    public Escenario escenario;
    public Entidad entidad;
    public Adversario adv1,adv2,adv3;
    //Doble buffer
    public Graphics gBuffer;
    public Image imag;
    
    public MundoVirtual(){
        escenario = new Escenario();
        entidad = new Entidad(0,0,this);
        adv1 = new Adversario(5,5,this);
        adv2 = new Adversario(6,6,this);
        adv3 = new Adversario(7,7,this);
        
        crearLaberinto();
          escenario.celdas[NUMERO_CELDAS_ANCHO-1]
                        [NUMERO_CELDAS_LARGO-1].tipo=AMOR;
        
        //color de fondo
        this.setBackground(Color.orange);
        this.setFocusable(true); //queremos que escuches en este elemento
        
        
    }
    private void crearLaberinto(){
        
        for(int i=1; i < 5; i++)
          escenario.celdas[i][i].tipo=OBSTACULO;
        for(int i=1; i < 5; i++)
          escenario.celdas[5][i].tipo=OBSTACULO;
        for(int i=5; i < 10; i++)
          escenario.celdas[i][1].tipo=OBSTACULO;
        for(int i=1; i < 7; i++)
          escenario.celdas[1][i].tipo=OBSTACULO;
    }
    @Override
    public void update(Graphics g){
        if(gBuffer==null){
            imag = createImage(this.getWidth(),this.getHeight());
            gBuffer = imag.getGraphics();
        }
          gBuffer.setColor(getBackground());
       gBuffer.fillRect(0,0,this.getWidth(),this.getHeight());
       entidad.paintCelda(gBuffer);
       adv1.paintCelda(gBuffer);
       adv2.paintCelda(gBuffer);
       adv3.paintCelda(gBuffer);
       escenario.paintEscenario(gBuffer);  
       //transfiere la imagen al contexto gráfico del applet
       g.drawImage(imag, 0, 0, null);  
    }
    @Override
    public void paint(Graphics g) {
       
       entidad.paintCelda(g);
       adv1.paintCelda(g);
       adv2.paintCelda(g);
       adv3.paintCelda(g);
       escenario.paintEscenario(g);
    }
}
