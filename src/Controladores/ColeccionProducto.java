package Controladores;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Productos;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class ColeccionProducto {
    private Conexion co;
    protected LinkedList<Productos> coleccion;
    private PreparedStatement ps;
    public ColeccionProducto(){
        co = new Conexion();
        coleccion = new LinkedList<Productos>();
        ps = null;
        
    }

    public LinkedList<Productos> select(){
        try{
            ps = co.getConeccion().prepareCall("exec MostrarStock");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String codigoPro = rs.getString(1);
                int tipoProd = rs.getInt(2);
                String nomPro = rs.getString(3);
                double PreciProd = rs.getDouble(4);
                int anioMov = rs.getInt(5);
                int mesMov = rs.getInt(6);
                int diaMov = rs.getInt(7);
                String tipMov = rs.getString(8);
                double canProd = rs.getDouble(9);
                String uniProd = rs.getString(10);
                String fechVen = rs.getString(11);
                int nroLote = rs.getInt(12);
                String nomProve = rs.getString(13);
                double stock = rs.getDouble(14);
                
                Productos p = new Productos(tipMov, codigoPro, tipoProd, nomPro, anioMov, mesMov, diaMov, fechVen, nomProve, uniProd, nroLote, PreciProd, canProd, stock);
                coleccion.add(p);
            }
            return coleccion;
        }catch(Exception e){
            System.out.println("Error1");
            return null;
        }
        finally{
            try{
                if(ps !=null){
                    ps.close();
                }
                if(co!=null){
                    co.desconectar();
                }
            }catch(SQLException ex){
                System.out.println("Error2");
            }
        }
    }
    public int tamaño(){
        return coleccion.size();
    }
    public Productos obtiene(int i){
        return coleccion.get(i);
    }
    public void Elimina(){
        coleccion.removeAll(coleccion);
    }
    public int busca (String producto){
        for(int i=0; i<tamaño(); i++){
            if(obtiene(i).getCodigoProd().equalsIgnoreCase(producto))
                return i;
        }
        return -1;
    }

    public void setColeccion(LinkedList<Productos> coleccion) {
        this.coleccion = coleccion;
    }
    
}
