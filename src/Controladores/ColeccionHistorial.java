package Controladores;
import Modelo.Productos;
import java.util.LinkedList;
public class ColeccionHistorial {
    protected LinkedList<Productos> historial; 
    public ColeccionHistorial(){
        historial = new LinkedList<>();
    }
    public int tamaño(){
        return historial.size();
    }
    public void agrega(Productos s){
        historial.add(s);
    }
    public Productos obtiene(int i){
        return historial.get(i);
    }
    public int busca (String productos){
        for(int i=0; i<tamaño(); i++){
            if(obtiene(i).getCodigoProd().equalsIgnoreCase(productos))
                return i;
        }
        return -1;
    }
}
