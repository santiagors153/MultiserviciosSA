package Modelo;
import Vistas.MultiserVi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static Connection con = null;
        public static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        public static final String user="sa";
        public static final String pas="root";
        public static final String url = "jdbc:sqlserver://DESKTOP-Q9H7KO3\\EQUIPOHP:1433;databaseName=MultiserviciosSA";

    public Conexion(){
        con=null;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url,user,pas);
            if(con!= null){
            System.err.println("conexion Exitosa");
        }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("No se Conecto a la base de Datos");
        }finally{}
    }
    public Connection getConeccion(){
        return con;
    }
    public void desconectar(){
        con=null;
        if(con == null){
            System.out.println("terminado");
        }
    }
    public static boolean setCuenta(String usuario, String password ){
        Usuario u = new Usuario(usuario, password);
        if(user.equals(usuario) && pas.equals(password)){
            System.out.println("funciono");
            return true;
        }else{
            System.out.println("Valio Madre este Pedo");
            return false;
        }
    }
}
