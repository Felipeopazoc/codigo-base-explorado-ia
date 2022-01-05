package inteligencia;


public class Estado {
    public int x,y;
    public String oper;//Derecha, izquierda , etc
    public Estado pred; // Padre
    
    public Estado(int x,int y,String oper, Estado pred){
        this.x = x;
        this.y = y;
        this.oper = oper;
        this.pred = pred;
    }
    @Override
    public String toString(){
        return "ESTADO ( x = "+x+"; y = "+y+"; oper = "+oper+" )";
    }
    @Override
    public boolean equals(Object x){
        Estado e = (Estado)x;
        return this.x == e.x && this.y == e.y; 
    }
    
    
}
