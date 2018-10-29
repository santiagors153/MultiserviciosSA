package Modelo;

import java.sql.PreparedStatement;

public class Usuario {
    protected String usuario, password;
    private Conexion co;
    private PreparedStatement ps;
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        co = new Conexion();
        ps = null;
        
    }
    public boolean AgregarUsuario(){
        int a=0;
        try{
            ps.getConnection().prepareCall("exec AgregarUsuario ?,?");
            ps.setString(1,usuario);
            ps.setString(2, password);
            a=ps.executeUpdate();
            if (a>0){
             return true;   
            }else{
            return false;
            }
        }catch(Exception e){
            System.out.println("Error de Insersion de Datos "+e+a);
                return false;
        }
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
