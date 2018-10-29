package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TipoMovimiento {
   String descripcion;
   private Conexion co;

    private PreparedStatement ps;

    public TipoMovimiento(String descripcion) {
        this.descripcion = descripcion;
        co = new Conexion();
        ps = null;
    }

    public boolean insertarDato(){
        int as =0;
        try{
            ps = co.getConeccion().prepareCall("exec insertarMovimiento ? ");
            ps.setString(1, descripcion);
            
            as=ps.executeUpdate();
            if (as>0){
             return true;   
            }else{
            return false;   
            }
            
            }catch (SQLException e){
                System.out.println("Error de Insersion de Datos "+e+as);
                return false;
            }
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   
}
