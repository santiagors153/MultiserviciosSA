package Controladores;

import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ControladorUsuario {
    private Conexion co;
    protected LinkedList<Usuario> login;
    private PreparedStatement ps;
    public ControladorUsuario(){
        co = new Conexion();
        login = new LinkedList<Usuario>();
        ps = null;
    }
    /*
    public LinkedList<Usuario> Select(){
        try{
        ps = co.getConeccion().prepareCall("exec MostarUsuari ?,?");
        ResultSet rs = ps.executeQuery();
        ps.setString(1, usuario);
        ps.setString(2, password);
        Usuario u = new Usuario(usuario, password);
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Logeo");
            return null;
        }finally{
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
    */
    public int tamaño(){
        return login.size();
    }
    public Usuario obtiene(int i){
        return login.get(i);
    }
    public void Elimina(){
        login.removeAll(login);
    }
    public int busca (String producto){
        for(int i=0; i<tamaño(); i++){
            if(obtiene(i).getUsuario().equalsIgnoreCase(producto))
                return i;
        }
        return -1;
    }
}
