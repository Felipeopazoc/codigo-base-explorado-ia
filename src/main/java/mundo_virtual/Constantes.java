
package mundo_virtual;

import java.util.Random;
import javax.swing.JOptionPane;


public interface Constantes {
      //tamaño de la celda
    public final int PIXELS=32;
    //el ancho de la celda
    public final int NUMERO_CELDAS_ANCHO=12;
    //largo de la celda
    public final int NUMERO_CELDAS_LARGO=9;
    //desplazamiento
    public final int ANCHO_BORDE_VENTANA=30;
    public final int LARGO_BORDE_VENTANA=50;
    public final int DESPLAZAMIENTO=10;
    
    public final int ANCHURA_ESCENARIO=(PIXELS*NUMERO_CELDAS_ANCHO)+
            ANCHO_BORDE_VENTANA;
    public final int LARGO_ESCENARIO=(PIXELS*NUMERO_CELDAS_LARGO)+
            LARGO_BORDE_VENTANA;
    
    //para la interaccion
    public final char OBSTACULO='O';
    public final char CAMINO='C';
    public final char AMOR='A';
  
    //funcion para generar un aleatorio
    default int numeroAleatorio(int minimo, int maximo) {
       Random random = new Random();
       int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
       return numero_aleatorio;
    }
    
    default void lanzar_mensaje(String mensaje) {
          JOptionPane.showMessageDialog(null,
            mensaje,
            "Mundo Virtual",
             JOptionPane.PLAIN_MESSAGE);
    }

}
