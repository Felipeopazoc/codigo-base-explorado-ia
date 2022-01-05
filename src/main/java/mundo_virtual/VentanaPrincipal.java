
package mundo_virtual;

import java.awt.Color;
import java.util.Timer;
import javax.swing.JFrame;


public class VentanaPrincipal extends JFrame implements Constantes {
    public MundoVirtual mv;
    public Timer lanzador;
    
    public VentanaPrincipal(){
        mv = new MundoVirtual();
        this.getContentPane().setBackground(Color.orange);
        this.getContentPane().add(mv);
        this.setSize(ANCHURA_ESCENARIO,LARGO_ESCENARIO); 
        
        lanzador = new Timer();
        lanzador.scheduleAtFixedRate(mv.entidad,0,100);
        lanzador.scheduleAtFixedRate(mv.adv1, 0, 100);
         lanzador.scheduleAtFixedRate(mv.adv2, 0, 100);
          lanzador.scheduleAtFixedRate(mv.adv3, 0, 100);
                
    }
}
