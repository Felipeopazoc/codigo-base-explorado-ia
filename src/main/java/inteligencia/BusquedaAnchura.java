
package inteligencia;

import java.util.ArrayList;
import java.util.Collections;
import mundo_virtual.Constantes;

public class BusquedaAnchura implements Constantes{
    public ArrayList <Estado> colaEstados;
    public Estado inicial;
    public Estado meta;
    public Estado actual;
    public ArrayList<String> pasos;
    public boolean exito;
    public BusquedaAnchura(int x_o, int y_o, int x_d, int y_d){
        colaEstados = new ArrayList<>();
        inicial = new Estado(x_o,y_o,"inicial",null);
        meta = new Estado(x_d,y_d,"",null);
         exito = false;
    }
    
    public void busqueda(){
        if(inicial.equals(meta)){
           exito = true;
            System.out.println("Inicial es el mismo que meta");
        }else{
            while(!colaEstados.isEmpty() && !exito){
                actual = colaEstados.get(0);
                colaEstados.remove(0);
                procesarSucesores(actual);
            }
        }
    }
    public void procesarSucesores(Estado e){
        if (e.equals(meta)){
             meta = e;
             reconstruirSolucion();
             exito = true;
        }else{
            arriba(e);
            abajo(e);
            izquierda(e);
            derecha(e);
        }
    }
    public void arriba(Estado e){
        if(e.y>0){
            colaEstados.add(new Estado(e.x,e.y-1,"arriba",e));
        }
    }
    public void abajo(Estado e){
        if(e.y < NUMERO_CELDAS_LARGO-1){
            colaEstados.add(new Estado(e.x,e.y+1,"abajo",e));
        }
    }
    public void izquierda(Estado e){
        if(e.x > 0){
            colaEstados.add(new Estado(e.x-1,e.y,"izquierda",e));
        }
    }
    public void derecha(Estado e){
        if(e.x < NUMERO_CELDAS_ANCHO-1){
            colaEstados.add(new Estado(e.x+1,e.y,"derecha",e));
        }
    }
    public void reconstruirSolucion(){
        ArrayList <Estado> solucion = new ArrayList <>();
        Estado aux = meta;
        
        while(aux!=null){
              solucion.add(aux);
              aux = aux.pred;
        }
        Collections.reverse(solucion);
        
        for(int i=0; i<solucion.size();i++){
            pasos.add(solucion.get(i).oper);
        }
        
        
    }
    
}
